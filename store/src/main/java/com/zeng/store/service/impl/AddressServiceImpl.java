package com.zeng.store.service.impl;

import com.zeng.store.entity.Address;
import com.zeng.store.mapper.AddressMapper;
import com.zeng.store.service.IAddressService;
import com.zeng.store.service.IDistrictService;
import com.zeng.store.service.IUserService;
import com.zeng.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/04/20:03
 * @Description:
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Value("${user.address.max-count}")
    private Integer maxaddresscount;
    @Autowired
    private IDistrictService iDistrictService;
    @Override
    public void insertAddress(Integer uid, String username, Address address) {
        Integer count = addressMapper.selectAddresscount(uid);
        if(count>=20){
            throw new  AddressCountLimitException("收货地址超出上限");
        }
        //通过code值来获取省市区的名称
        String areaname = iDistrictService.selectByCode(address.getAreaCode());
        String cityname = iDistrictService.selectByCode(address.getCityCode());
        String pronvincename = iDistrictService.selectByCode(address.getProvinceCode());
        //补全数据
        address.setAreaName(areaname);
        address.setProvinceName(pronvincename);
        address.setCityName(cityname);
        Date now=new Date();
        address.setUid(uid);
        address.setCreatedTime(now);
        address.setModifiedUser(username);
        address.setCreatedUser(username);
        address.setModifiedTime(now);
        address.setIsDefault(count==0 ? 1: 0);
        Integer rows = addressMapper.insertAddress(address);
        if(rows!=1){
            throw new InsertException("新增收货地址出现异常");
        }
    }

    @Override
    public List<Address> findByUid(Integer uid) {
        List<Address> addressList = addressMapper.findByUid(uid);
        for (Address address : addressList) {
            address.setProvinceCode(null);
            address.setAreaCode(null);
            address.setCityCode(null);
            address.setZip(null);
            address.setTel(null);
            address.setCreatedUser(null);
            address.setCreatedTime(null);
            address.setModifiedTime(null);
            address.setModifiedUser(null);
        }
        return addressList;
    }
    @Transactional
    @Override
    public void setDefault(Integer aid, Integer uid,String username) {
        Address result = addressMapper.findByAid(aid);
        if(!(result.getUid()==uid)){
            throw new AccessDeniedException("非法访问的异常");
        }
        if (result==null){
            throw new AddressNotFoundException("收货地址数据不存在的异常");
        }
        Integer rows = addressMapper.setNoneByUid(uid);
        if (rows==null){
            throw new UpdateException("设置默认地址时出现异常");
        }
         rows = addressMapper.updateByAid(aid,username,new Date());
        if (rows==null){
            throw new UpdateException("设置默认地址时出现异常");
        }


    }
    @Transactional
    @Override
    public void deleteAddressByAid(Integer aid, Integer uid, String username) {
        Address result = addressMapper.findByAid(aid);
        if (result==null){
            throw new AddressNotFoundException("删除的数据不存在");
        }
        if(result.getUid()!=uid){
            throw new AccessDeniedException("非法访问的异常");
        }
        Integer rows = addressMapper.deleteByAid(aid);
        if (rows!=1){
            throw new DeleteException("删除数据出现未知异常");
        }
        if(result.getIsDefault()==0){
            return;
        }
        if (addressMapper.selectAddresscount(uid)==0){
            return;
        }
        Address lastModified = addressMapper.findLastModified(uid);
        rows = addressMapper.updateByAid(lastModified.getAid(), username, new Date());
        if (rows!=1){
            throw new UpdateException("更新数据出现未知异常");
        }


    }

    @Override
    public Address findByAid(Integer aid, Integer uid) {
        Address address = addressMapper.findByAid(aid);
        if (!address.getUid().equals(uid)){
            throw new AccessDeniedException("非法访问");
        }
        if (address==null){
            throw new AddressNotFoundException("访问的地址不存在");
        }
        address.setProvinceCode(null);
        address.setCityCode(null);
        address.setAreaCode(null);
        address.setCreatedUser(null);
        address.setCreatedTime(null);
        address.setModifiedUser(null);
        address.setModifiedTime(null);
        return address;
    }

}
