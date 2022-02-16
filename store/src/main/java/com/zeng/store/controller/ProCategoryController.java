package com.zeng.store.controller;

import com.zeng.store.entity.BaseEntity;
import com.zeng.store.entity.proCategory;
import com.zeng.store.service.IProCategoryService;
import com.zeng.store.service.IProductService;
import com.zeng.store.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/14/13:40
 * @Description:
 */
@RestController
@RequestMapping("proCategories")
public class ProCategoryController extends BaseController {
    @Autowired
    private IProCategoryService iProCategoryService;
    @RequestMapping({"","/"})
    public JsonResult<List<proCategory>> showproCategory(Integer parentId){
        List<proCategory> proCategories = iProCategoryService.showproCategory(parentId);
        return new JsonResult<List<proCategory>>(OK,proCategories);
    }
}
