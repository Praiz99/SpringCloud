package com.zeng.store.controller;


import com.zeng.store.controller.ex.FileEmptyException;
import com.zeng.store.controller.ex.FileSizeException;
import com.zeng.store.controller.ex.FileTypeException;
import com.zeng.store.controller.ex.FileUploadException;
import com.zeng.store.entity.User;
import com.zeng.store.service.IUserService;
import com.zeng.store.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/01/30/15:31
 * @Description:
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    IUserService iUserService;
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        iUserService.reg(user);
        return new JsonResult<>(OK);
    }
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession httpSession){
        User data = iUserService.login(username, password);
        httpSession.setAttribute("uid",data.getUid());
        httpSession.setAttribute("username",data.getUsername());
        System.out.println(getuidFromSession(httpSession));
        System.out.println(getUsernameFromSession(httpSession));
        return new JsonResult<User>(OK,data);
    }
    @RequestMapping("change_password")
    public JsonResult<Void> changepassword(String oldPassword,String newPassword,HttpSession httpSession)
    {
        iUserService.changePassword(getuidFromSession(httpSession),
                getUsernameFromSession(httpSession),
                oldPassword,
                newPassword);
        return new JsonResult<>(OK);
    }
    @RequestMapping("get_by_uid")
    public JsonResult<User> getbyuid(HttpSession httpSession){
        Integer uid = getuidFromSession(httpSession);
        User user = iUserService.findUserByUid(uid);
        return new JsonResult<User>(OK,user);
    }
    @RequestMapping("change_info")
    public JsonResult<Void> changeinfo(HttpSession httpSession,User user){
        Integer uid = getuidFromSession(httpSession);
        String username = getUsernameFromSession(httpSession);
        iUserService.changeInfo(uid,username,user);
        return new JsonResult<>(OK);
    }
    //上传的头像大小限制为10MB
    public static  final int AVATAR_MAX_SIZE=10 * 1024 * 1024;
    public static  final List<String> AVATAR_TYPES=new ArrayList<>();
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
    }
    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession httpSession, MultipartFile file){
        if(file.isEmpty()){
            throw new FileEmptyException("上传的头像为空异常");
        }
        if (file.getSize()>AVATAR_MAX_SIZE){
        throw new FileSizeException("头像文件过大");
        }
         String contentType = file.getContentType();
        if (!AVATAR_TYPES.contains(contentType)){
            throw new FileTypeException("文件类型不符合");
        }
        // 获取当前项目的绝对磁盘路径
        String parent = httpSession.getServletContext().getRealPath("upload");
        System.out.println(parent);
        File dir=new File(parent);
        if(!dir.exists()){
            dir.mkdir();
        }
        String suffix="";
        String originalFilename = file.getOriginalFilename();
        int i = originalFilename.lastIndexOf(".");
        suffix = originalFilename.substring(i);
        String filename = UUID.randomUUID().toString() + suffix;
        File dest=new File(dir,filename);
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("文件状态异常");
        }
        catch (IOException e) {
            throw new FileUploadException("上传文件时读写错误");
        }
        String avatar="/upload/"+filename;
        System.out.println(avatar);
        Integer uid = getuidFromSession(httpSession);
        String username = getUsernameFromSession(httpSession);
        iUserService.updateAvatar(uid,avatar,username);
        return new JsonResult<String>(OK,avatar);
    }
}
