package com.zeng.store.controller;

import com.zeng.store.controller.BaseController;
import com.zeng.store.entity.Product;
import com.zeng.store.service.IProductService;
import com.zeng.store.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/07/18:12
 * @Description:
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController {
    @Autowired
    IProductService iProductService;
    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotlist(){
        List<Product> hotProduct = iProductService.findHotProduct();
        return new JsonResult<List<Product>>(OK,hotProduct);
    }
    @RequestMapping("{id}/details")
    public JsonResult<Product> details(@PathVariable Integer id){
        Product result = iProductService.findById(id);
        return new  JsonResult<Product>(OK,result);
    }
}
