package com.zeng.store.service.impl;

import com.zeng.store.entity.proCategory;
import com.zeng.store.mapper.ProCategoryMapper;
import com.zeng.store.service.IProCategoryService;
import com.zeng.store.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/14/13:28
 * @Description:
 */
@Service
public class ProCategoryService implements IProCategoryService {
    @Autowired
    private ProCategoryMapper proCategoryMapper;
    @Override
    public List<proCategory> showproCategory(Integer parentId) {
        List<proCategory> proCategories = proCategoryMapper.findByparentId(parentId);
        for (proCategory proCategory:proCategories){
            proCategory.setIsParent(null);
            proCategory.setStatus(null);
            proCategory.setSortOrder(null);
            proCategory.setIsParent(null);
            proCategory.setCreatedTime(null);
            proCategory.setCreatedUser(null);
            proCategory.setModifiedTime(null);
            proCategory.setModifiedUser(null);
        }
        return proCategories;
    }
}
