package com.zeng.store.mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/01/29/19:43
 * @Description:
 */

import com.zeng.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 持久层用户的mapper接口
 */

public interface UserMapper {
    int insertUser(User user);
    User findByUsername(String username);
    Integer updatePasswordByUid(@Param("uid") Integer uid,
                                @Param("password") String password,
                                @Param("modified_user")   String modifieUser,
                                @Param("modified_time") Date modifiedTime);
    User findByUid(Integer uid);
    Integer updateInfoByUid(User user);
    Integer updateAvatar(@Param("uid")Integer uid,
                         @Param("avatar") String avatar,
                         @Param("modified_user") String modified_user,
                         @Param("modified_time") Date modified_time);

}
