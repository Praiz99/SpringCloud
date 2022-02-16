package com.zeng.store.service;

import com.zeng.store.entity.User;
import com.zeng.store.service.ex.ServiceException;
import com.zeng.store.service.ex.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/01/30/2:37
 * @Description:
 */
@SpringBootTest
//@RunWith：表示这个单元测试类（单元测试类是不能够运行的）,需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    IUserService iUserService;
    @Test
    public void reg(){
       try {
            User user=new User();
            user.setUsername("test07");
            user.setPassword("123456");
            iUserService.reg(user);
            System.out.println("success");
        }catch (ServiceException e){
           System.out.println(e.getMessage());

       }

    }
    @Test
    public void login(){
        User admin1 = iUserService.login("admin1", "123456");
        System.out.println(admin1);
    }
    @Test
    public void changePassword(){
        iUserService.changePassword(14,"test06","654321","123");
    }
    @Test
    public void changeInfo() {
        User user=new User();
        user.setGender(1);
        user.setEmail("1045000133@qq.com");
        user.setPhone("13868866459");
        user.setModifiedUser("管理员");
        user.setModifiedTime(new Date());
        iUserService.changeInfo(15,"test07",user);
    }


    @Test
    public void findUserByUid() {
        User userByUid = iUserService.findUserByUid(15);
        System.out.println(userByUid);
    }
}
