package zeng.myssm.Controller;

import zeng.myssm.Annotation.ZengAutowired;
import zeng.myssm.Annotation.ZengController;
import zeng.myssm.Annotation.ZengRequestMapping;
import zeng.myssm.Annotation.ZengRequestParam;
import zeng.myssm.Bean.Student;
import zeng.myssm.Service.DemoSerivce;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@ZengController
@ZengRequestMapping("/demo")
public class DemoAction {
    @ZengAutowired
    private DemoSerivce demoService;

    @ZengRequestMapping("/get")
    public void get(HttpServletRequest req, HttpServletResponse res,
                    @ZengRequestParam("name") String name) {
        System.out.println(" 参数：====================" + name);
        try {
            res.getWriter().write("a");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @ZengRequestMapping("/add")
    public void add(HttpServletRequest req, HttpServletResponse res,
                    @ZengRequestParam("number1") Integer number1, @ZengRequestParam("number2") Integer number2) {
        try {
            res.getWriter().write(number1 + "+" + number2 + "=" + (number1 + number2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        @ZengRequestMapping("/hello")
    public void sayhello(HttpServletRequest req, HttpServletResponse res) {
        List<Student> students = demoService.getall();
        System.out.println(students);
        System.out.println("a");
        try {
            res.getWriter().write("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
