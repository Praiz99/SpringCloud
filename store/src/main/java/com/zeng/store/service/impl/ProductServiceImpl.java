package com.zeng.store.service.impl;

import com.zeng.store.entity.Product;
import com.zeng.store.mapper.ProductMapper;
import com.zeng.store.service.IProductService;
import com.zeng.store.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/07/18:05
 * @Description:
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> findHotProduct() {
        List<Product> hotProduct = productMapper.getHotProduct();
        for (Product product : hotProduct){
            product.setItemType(null);
            product.setNum(null);
            product.setItemType(null);
            product.setSellPoint(null);
            product.setNum(null);
            product.setStatus(null);
            product.setCreatedTime(null);
            product.setCreatedUser(null);
            product.setModifiedTime(null);
            product.setModifiedUser(null);
        }
        return hotProduct;
    }

    @Override
    public Product findById(Integer id) {
        Product product = productMapper.findById(id);
        if (product==null){
            throw new ProductNotFoundException("产品未找到的异常");
        }
        product.setPriority(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setModifiedUser(null);
        product.setModifiedTime(null);
        return product;
    }
}
