package com.zeng.store.service;

import com.zeng.store.entity.User;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/01/30/2:22
 * @Description:
 */
public interface IUserService {
    void reg(User user);
    User login(String username,String password);
    void changePassword(Integer uid,String username,String oldpassword,String newpassword);
    void changeInfo(Integer uid,String username,User user);
    User findUserByUid(Integer uid);
    void updateAvatar(Integer uid,String avatar,String username);
}
