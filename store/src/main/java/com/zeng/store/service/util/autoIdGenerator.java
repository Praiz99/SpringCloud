package com.zeng.store.service.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 曾瑞楷
 * @Date: 2022/02/13/18:55
 * @Description:
 */
public class autoIdGenerator {
    private  static  SimpleDateFormat sdformat;
    public static Integer getOrderId(){
        Date date = new Date();
        sdformat = new SimpleDateFormat("HHmmssSSS");
        String id = sdformat.format(date);
        Integer integer = Integer.parseInt(id);
        return integer;
    }
}
