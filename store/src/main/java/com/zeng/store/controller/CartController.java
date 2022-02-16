package com.zeng.store.controller;

import com.zeng.store.service.ICartService;
import com.zeng.store.service.util.JsonResult;
import com.zeng.store.vo.CartVO;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/08/1:58
 * @Description:
 */
@RestController
@RequestMapping("carts")
public class CartController extends BaseController{
    @Autowired
    private ICartService iCartService;
    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession httpSession ){
        iCartService.addToCart(getuidFromSession(httpSession),pid,amount,getUsernameFromSession(httpSession));
        return new JsonResult<>(OK);
    }
    @RequestMapping({"/",""})
    public JsonResult<List<CartVO>> showCarts(HttpSession httpSession ){
        List<CartVO> carts = iCartService.showCarts(getuidFromSession(httpSession));
        return new JsonResult<List<CartVO>>(OK,carts);
    }
    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession httpSession ){
        Integer data = iCartService.addNum(cid, getuidFromSession(httpSession), getUsernameFromSession(httpSession));
        return new JsonResult<Integer>(OK,data);
    }
    @RequestMapping("list")
    public JsonResult<List<CartVO>> showCartsByCid(Integer[] cids,HttpSession httpSession){
        List<CartVO> cartVOS = iCartService.showCartsByCid(getuidFromSession(httpSession), cids);
        return new JsonResult<>(OK,cartVOS);
    }
}
