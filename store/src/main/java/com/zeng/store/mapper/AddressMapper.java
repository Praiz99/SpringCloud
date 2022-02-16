package com.zeng.store.mapper;

import com.zeng.store.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/04/19:36
 * @Description:
 */
public interface AddressMapper {
    /**
     * 插入收货地址数据
     * @param address 收货地址数据
     * @return 受影响的行数
     */
    Integer insertAddress(Address address);

    /**
     * 统计某个用户的收货地址个数
     * @param uid 用户的id
     * @return 受影响的行数
     */
    Integer selectAddresscount(Integer uid);

    /**
     * 查询某个用户的收货地址列表
     * @param uid 用户的id
     * @return 用户的收货地址列表
     */
    List<Address> findByUid(Integer uid);

    /**
     * 设置某个用户所有的收货地址都为不默认
     * @param uid 用户的id
     * @return 受影响的行数
     */
    Integer setNoneByUid(Integer uid);

    /**
     * 将指定用户的收货地址设置为默认地址
     * @param aid 收货地址id
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @return 受影响行数
     */
    Integer updateByAid(@Param("aid") Integer aid,
                        @Param("modified_user") String modifiedUser,
                        @Param("modified_time") Date modifiedTime);

    /**
     * 查询收货地址
     * @param aid 收货地址唯一表示id
     * @return 一条收货地址
     */
    Address findByAid(Integer aid);

    /**
     * 删除一条收货地址
     * @param aid 收货地址的唯一表示id
     * @return 受影响的行数
     */
    Integer deleteByAid(Integer aid);

    /**
     * 查找最新修改的收货地址
     * @param uid 用户的唯一表示id
     * @return 最新修改的收货地址
     */
    Address findLastModified(Integer uid);
}
