package com.zeng.store.service.impl;

import com.zeng.store.entity.District;
import com.zeng.store.mapper.DistrictMapper;
import com.zeng.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/04/21:10
 * @Description:
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> districtlist = districtMapper.findByParent(parent);
        //设置无关属性id和父code的属性值为null，提高系统性能
        for(District district:districtlist){
            district.setId(null);
            district.setParent(null);
        }
        return districtlist;
    }
    @Override
    public String selectByCode(String code) {
        return  districtMapper.selectByCode(code);
    }
}
