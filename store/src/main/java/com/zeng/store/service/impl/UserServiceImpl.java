package com.zeng.store.service.impl;

import com.zeng.store.entity.User;
import com.zeng.store.mapper.UserMapper;
import com.zeng.store.service.IUserService;
import com.zeng.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/01/30/2:29
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public void reg(User user) {
        String username = user.getUsername();
        User byUsername = userMapper.findByUsername(username);
        if(!(byUsername==null)){
            throw new UsernameDuplicatedException("用戶名被占用");
        }
        //密码加密处理的实现：md5算法的形式
        //(串+password+串)-----md5算法进行加密，连续加密三次
        //盐值+password+盐值----盐值就是一个随机的字符串
        String oldpassword = user.getPassword();
        //获取盐值（随机生成一个盐值）
        String salt = UUID.randomUUID().toString().toUpperCase();
        //保存盐值
        user.setSalt(salt);
        //把旧密码经过md5加密三次
        String md5Password = getMD5Password(oldpassword, salt);
        //设置用户密码为加密过的密码
        user.setPassword(md5Password);
        Date nowdate = new Date();
        user.setIsDelete(0);
        user.setCreatedUser(username);
        user.setCreatedTime(nowdate);
        user.setModifiedUser(username);
        user.setModifiedTime(nowdate);
        int i = userMapper.insertUser(user);
        if (i!=1){
            throw  new InsertException("服务器宕机");
        }
    }

    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUsername(username);
        if(result==null || result.getIsDelete()==1){
            throw new UserNotFoundException("用户不存在");
        }
        String salt = result.getSalt();
        String password1 = result.getPassword();
        String md5Password = getMD5Password(password, salt);
        if(!md5Password.equals(password1)){
            throw  new PasswordNotMatchException("密码不正确");
        }
        //为了提升系统系统，这边新建一个user对象存入登录用户的信息
        User newuser=new User();
        newuser.setUid(result.getUid());
        newuser.setUsername(result.getUsername());
        newuser.setAvatar(result.getAvatar());
        //将当前的用户数据返回，返回的数据是为了辅助其他页面做数据展示使用
        return newuser;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldpassword, String newpassword) {
        User result = userMapper.findByUid(uid);
        if(uid==null || result.getIsDelete()==1){
            throw  new UserNotFoundException("用户不存在");
        }
        String password = result.getPassword();
        String salt = result.getSalt();
        String md5Password = getMD5Password(oldpassword,salt);
        if(!password.equals(md5Password)){
            throw  new PasswordNotMatchException("旧密码不正确");
        }
        Integer i = userMapper.updatePasswordByUid(uid, getMD5Password(newpassword, salt), username, new Date());
        if(i==0){
            throw new UpdateException("更新异常，请联系管理员");
        }
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if(result==null || result.getIsDelete()==1){
            throw  new UserNotFoundException("用户不存在");
        }
        user.setUid(result.getUid());
        user.setModifiedTime(new Date());
        user.setModifiedUser(result.getUsername());
        Integer rows = userMapper.updateInfoByUid(user);
        if(rows!=1){
            throw new UpdateException("更新用户数据异常，请联系管理员");
        }
    }
    @Override
    public User findUserByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if(result==null || result.getIsDelete()==1){
            throw  new UserNotFoundException("用户名不存在");
        }
        User user=new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    /**
     *
     * @param uid 用户id
     * @param avatar 用户头像
     * @param username 用户名
     */
    @Override
    public void updateAvatar(Integer uid, String avatar, String username) {
        User result = userMapper.findByUid(uid);
        if(result==null || result.getIsDelete()==1){
            throw  new UserNotFoundException("用户名不存在");
        }
        Integer rows = userMapper.updateAvatar(uid, avatar, username, new Date());
        if (rows!=1){
            throw new UpdateException("更新头像异常");
        }
    }

    public String getMD5Password(String password,String salt){
        for (int i=0;i<3;i++){
            password  = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toString();
        }
        return password;
    }
}
