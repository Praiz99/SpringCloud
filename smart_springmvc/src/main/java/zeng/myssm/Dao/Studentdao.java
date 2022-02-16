package zeng.myssm.Dao;

import org.apache.ibatis.annotations.Select;
import zeng.myssm.Annotation.ZengMapper;
import zeng.myssm.Bean.Student;

import java.util.List;

@ZengMapper
public interface Studentdao {
    @Select("select * from student")
    List<Student> getall();
}
