package com.zeng.store.controller;

import com.zeng.store.entity.Address;
import com.zeng.store.service.IAddressService;
import com.zeng.store.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/04/20:34
 * @Description:
 */
@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController{
    @Autowired
    private IAddressService iAddressService;
    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(HttpSession httpSession, Address address){
        Integer uid = getuidFromSession(httpSession);
        String username = getUsernameFromSession(httpSession);
        iAddressService.insertAddress(uid,username,address);
        return new JsonResult<>(OK);
    }
    @RequestMapping({"","/"})
    public JsonResult<List<Address>> findByUid(HttpSession httpSession){
        List<Address> list = iAddressService.findByUid(getuidFromSession(httpSession));
        return  new JsonResult<>(OK,list);
    }
    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefaultAddress(@PathVariable("aid") Integer aid,HttpSession httpSession){
        iAddressService.setDefault(aid,getuidFromSession(httpSession),getUsernameFromSession(httpSession));
        return new JsonResult<>(OK);
    }

    @RequestMapping("{aid}/deleteByAid")
    public JsonResult<Void> deleteByAid(@PathVariable("aid") Integer aid,HttpSession httpSession){
        iAddressService.deleteAddressByAid(aid,
                getuidFromSession(httpSession),
                getUsernameFromSession(httpSession));
        return new JsonResult<>(OK);
    }

}
