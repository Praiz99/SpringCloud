package com.zeng.store.mapper;

import com.zeng.store.entity.Cart;
import com.zeng.store.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/08/1:59
 * @Description:
 */
public interface CartMapper {
    /**
     * 查询是否存在已经加入购物车
     * @param uid 用户唯一标识id
     * @param pid 商品唯一标识id
     * @return 一条购物车数据
     */
    Cart findByUidAndpid(@Param("uid") Integer uid,
                         @Param("pid") Integer pid);

    /**
     * 插入一条购物车信息
     * @param cart 购物车数据
     * @return 受影响的行数
     */
    Integer insertCart(Cart cart);

    /**
     * 更新一条购物车信息
     * @param uid 用户唯一标识id
     * @param pid 商品唯一标识id
     * @param amount 用户所选中商品加入购物车的数量
     * @param modifiedUser 用户名
     * @param modifiedTime 修改日期
     * @return 受影响行数
     */
    Integer updateCart(@Param("uid") Integer uid,
                       @Param("pid")Integer pid,
                       @Param("amount") Integer amount,
                       @Param("modifiedUser") String modifiedUser,
                       @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据用户查询购物车列表
     * @param uid 用户唯一标识id
     * @return 购物车列表
     */
    List<CartVO> showCarts(Integer uid);

    /**
     * 查询是否存在指定购物车的数据
     * @param cid 购物车信息唯一标识id
     * @return 一条指定购物车记录
     */
    Cart findByCid(Integer cid);

    /**
     * 查询购物车所选中商品后的购物车数据列表
     * @param cids 所选中购物车的数据的唯一标识
     * @return 匹配的购物车详情数据
     */
    List<CartVO> showCartsByCid(Integer[] cids);
}
