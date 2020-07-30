package vip.yydz.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.yydz.domain.Student;
import vip.yydz.domain.StudentExample;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer stuid);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);
    List<Student> selectByExampleWithTest(StudentExample example);

    Student selectByPrimaryKey(Integer stuid);

    Student selectByPrimaryKeyWithTest(Integer stuid);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}