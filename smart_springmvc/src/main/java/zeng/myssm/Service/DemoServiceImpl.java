package zeng.myssm.Service;

import zeng.myssm.Annotation.ZengAutowired;
import zeng.myssm.Annotation.ZengService;
import zeng.myssm.Bean.Student;
import zeng.myssm.Dao.Studentdao;

import java.io.InputStream;
import java.util.List;

@ZengService
public class DemoServiceImpl implements DemoSerivce {



    //读取配置文件
    InputStream inputStream=null;
    @ZengAutowired
    Studentdao studentdao;

    public List<Student> getall() {
        List<Student> getall = studentdao.getall();
        return getall;

    }
}

