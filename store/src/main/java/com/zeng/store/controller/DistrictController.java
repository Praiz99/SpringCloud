package com.zeng.store.controller;

import com.zeng.store.controller.BaseController;
import com.zeng.store.entity.District;
import com.zeng.store.service.IDistrictService;
import com.zeng.store.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/04/21:27
 * @Description:
 */
@RestController
@RequestMapping("/districts")
public class DistrictController extends BaseController {
    @Autowired
    private IDistrictService iDistrictService;
    @RequestMapping({"","/"})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> districtList=iDistrictService.getByParent(parent);
        return new JsonResult<List<District>>(OK,districtList);
    }
}
