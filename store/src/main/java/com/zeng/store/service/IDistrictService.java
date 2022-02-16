package com.zeng.store.service;

import com.zeng.store.entity.District;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/04/21:09
 * @Description:
 */
public interface IDistrictService {
    List<District>  getByParent(String parent);
    String selectByCode(String code);
}
