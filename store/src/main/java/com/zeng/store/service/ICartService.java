package com.zeng.store.service;

import com.zeng.store.vo.CartVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/08/1:59
 * @Description:
 */
public interface ICartService {
    /**
     * 加入购物车
     * @param uid 用户唯一标识id
     * @param pid 商品唯一标识id
     * @param amount 用户选中商品加入购物车数量
     * @param username 用户名
     */
    void addToCart(Integer uid,
                   Integer pid,
                   Integer amount,
                   String username);
    List<CartVO> showCarts(Integer uid);

    /**
     * 用户购物车某个商品数量加1
     * @param uid 用户唯一标识id
     * @param username 用户名
     * @return 增加后某个商品的在购物车中的数量
     */
    Integer addNum(Integer cid,Integer uid,String username);
    List<CartVO> showCartsByCid(Integer uid,Integer[] cids);
}
