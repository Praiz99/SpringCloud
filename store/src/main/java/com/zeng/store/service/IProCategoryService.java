package com.zeng.store.service;

import com.zeng.store.entity.proCategory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/14/13:26
 * @Description:
 */
public interface IProCategoryService {
    /**
     * 展示分类列表
     * @param parentId 分类父id
     * @return 按条件查询出来的分类列表
     */
    List<proCategory> showproCategory(Integer parentId);
}
