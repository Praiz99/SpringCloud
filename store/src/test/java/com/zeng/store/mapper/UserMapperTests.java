package com.zeng.store.mapper;

import com.zeng.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/01/29/22:02
 * @Description:
 */
@SpringBootTest
//@RunWith：表示这个单元测试类（单元测试类是不能够运行的）,需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Autowired
    UserMapper userMapper;
    @Test
    public void insert(){
        User user=new User();
        user.setUsername("zengruikai");
        user.setPassword("123456");
        int i = userMapper.insertUser(user);
        System.out.println(i);
    }
    @Test
    public void findByUsername(){
        User zengruikai = userMapper.findByUsername("zengruikai");
        System.out.println(zengruikai);
    }
}
