package com.zeng.store.mapper;

import com.zeng.store.entity.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/07/17:33
 * @Description:
 */
public interface ProductMapper {
    /**
     * 展示热销商品
     * @return 热销商品列表
     */
    List<Product> getHotProduct();

    /**
     * 查询某个产品
     * @param
     * @return  商品信息
     */
    Product findById(Integer id);
}
