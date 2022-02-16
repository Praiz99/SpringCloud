package com.zeng.store.mapper;

import com.zeng.store.entity.proCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/14/13:20
 * @Description:
 */
public interface ProCategoryMapper {
    /**
     * 查找分类
     * @param parentId 分类数据的父id
     * @return 分类数据列表
     */
    List<proCategory> findByparentId(@Param("parent_id") Integer parentId);
}
