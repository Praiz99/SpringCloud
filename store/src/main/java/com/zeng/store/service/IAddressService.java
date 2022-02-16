package com.zeng.store.service;

import com.zeng.store.entity.Address;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/04/19:50
 * @Description:
 */
public interface IAddressService {
    void insertAddress(Integer uid, String username, Address address);
    List<Address> findByUid(Integer uid);
    void setDefault(Integer aid,Integer uid,String username);
    void deleteAddressByAid(Integer aid,Integer uid,String username);
    Address findByAid(Integer aid,Integer uid);


}
