package com.zeng.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/27/16:55
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<E> {
    private Integer code;
    private String message;
    private E data;

    public JsonResult(Integer code, String message) {
        this(code,message,null);
    }
}
