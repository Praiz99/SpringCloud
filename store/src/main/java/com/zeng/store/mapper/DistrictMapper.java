package com.zeng.store.mapper;

import com.zeng.store.entity.District;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/04/20:49
 * @Description:
 */
public interface DistrictMapper {
    List<District> findByParent(String parent);
    String selectByCode(String code);
}
