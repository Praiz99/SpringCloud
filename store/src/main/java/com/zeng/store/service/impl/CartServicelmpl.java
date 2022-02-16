package com.zeng.store.service.impl;

import com.zeng.store.entity.Cart;
import com.zeng.store.entity.Product;
import com.zeng.store.mapper.CartMapper;
import com.zeng.store.mapper.ProductMapper;
import com.zeng.store.service.ICartService;
import com.zeng.store.service.ex.AccessDeniedException;
import com.zeng.store.service.ex.CartNotFoundException;
import com.zeng.store.service.ex.InsertException;
import com.zeng.store.service.ex.UpdateException;
import com.zeng.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/08/1:59
 * @Description:
 */
@Service
public class CartServicelmpl implements ICartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        Cart result = cartMapper.findByUidAndpid(uid, pid);
        if(result==null){
            Cart cart=new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            Product produtct = productMapper.findById(pid);
            cart.setPrice(produtct.getPrice());
            Date date =new Date();
            cart.setCreatedTime(date);
            cart.setModifiedTime(date);
            cart.setCreatedUser(username);
            cart.setModifiedUser(username);
            Integer rows = cartMapper.insertCart(cart);
            if (rows!=1){
                throw new InsertException("添加购物车时的异常");
            }
        }else {
            cartMapper.updateCart(uid,pid,result.getNum()+amount,username,new Date());
            throw new UpdateException("添加购物车时的异常");
        }
    }

    @Override
    public List<CartVO> showCarts(Integer uid) {
        List<CartVO> result = cartMapper.showCarts(uid);
        return result;
    }

    @Override
    public Integer addNum(Integer cid,Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if (result == null) {
            throw new CartNotFoundException("购物车数据未找到");
        }

        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法访问");
        }
        int addCount = result.getNum() + 1;
        Integer rows = cartMapper.updateCart(uid, result.getPid(), addCount, username, new Date());
        if (rows != 1) {
            throw new InsertException("修改商品数量时出现未知错误，请联系系统管理员");
        }
        return addCount;
    }

    @Override
    public List<CartVO> showCartsByCid(Integer uid, Integer[] cids) {
        List<CartVO> cartVOS = cartMapper.showCartsByCid(cids);
        for (CartVO cartVO:cartVOS){
            //把不属于当前用户的购物车数据移除
            if(!cartVO.getUid().equals(uid)){
                cartVOS.remove(cartVO);
            }
        }
        return cartVOS;
    }
}
