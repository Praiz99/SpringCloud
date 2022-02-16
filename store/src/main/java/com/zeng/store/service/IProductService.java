package com.zeng.store.service;

import com.zeng.store.entity.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/07/18:03
 * @Description:
 */
public interface IProductService {
    List<Product> findHotProduct();
    Product findById(Integer id);
}
