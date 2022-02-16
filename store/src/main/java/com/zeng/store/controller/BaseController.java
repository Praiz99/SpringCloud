package com.zeng.store.controller;

import com.zeng.store.controller.ex.*;
import com.zeng.store.service.ex.*;
import com.zeng.store.service.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/01/30/15:31
 * @Description:
 */
public class BaseController {
    /** 操作成功的状态码 */
    public static final int OK = 200;
   /**ExceptionHandler用于统一处理方法抛出的异常，会调用该方法*/
    @ExceptionHandler({ServiceException.class,FileUploadException.class})
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult<Void>  jsonResult=new JsonResult<>(e);
        if(e instanceof InsertException){
            jsonResult.setState(5001);
            jsonResult.setMessage("注册时产生未知的异常");
        }else if (e instanceof AddressCountLimitException) {
            jsonResult.setState(4003);
            jsonResult.setMessage("地址数量上限的异常");
        }
        else if (e instanceof AddressNotFoundException ) {
            jsonResult.setState(4004);
            jsonResult.setMessage("地址未找到异常");
        }
        else if (e instanceof AccessDeniedException){
            jsonResult.setMessage("收货地址非法访问的异常");
            jsonResult.setState(4005);
        }
        else if (e instanceof UsernameDuplicatedException){
            jsonResult.setMessage("用户名不存在异常");
            jsonResult.setState(5001);
        }else if (e instanceof PasswordNotMatchException){
            jsonResult.setMessage("用户名的密码错误异常");
            jsonResult.setState(5002);
        }
        else if (e instanceof InsertException){
            jsonResult.setMessage("插入数据时产生未知的异常");
            jsonResult.setState(5000);
        }else if (e instanceof UpdateException){
            jsonResult.setMessage("更新数据时产生未知的异常");
            jsonResult.setState(5001);
        }else if (e instanceof DeleteException){
            jsonResult.setMessage("删除数据时产生未知的异常");
            jsonResult.setState(5001);
        }else if (e instanceof FileEmptyException) {
            jsonResult.setState(6000);
        } else if (e instanceof FileSizeException) {
            jsonResult.setState(6001);
        } else if (e instanceof FileTypeException) {
            jsonResult.setState(6002);
        } else if (e instanceof FileStateException) {
            jsonResult.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            jsonResult.setState(6004);
        }
        return jsonResult;
    }

    /**
     * 获取当前登录用户的uid
     * @param httpSession
     * @return 当前登录用户的uid
     */
    protected Integer getuidFromSession(HttpSession httpSession){
         return  Integer.valueOf(httpSession.getAttribute("uid").toString());
    }

    /**
     * 获取当前登录用户的username
     * @param httpSession
     * @return 当前登录用户的用户名
     */
    protected String getUsernameFromSession(HttpSession httpSession){
        return httpSession.getAttribute("username").toString();
    }
}
