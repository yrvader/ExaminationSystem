package vip.yydz.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.yydz.domain.Test;
import vip.yydz.domain.TestExample;

public interface TestMapper {
    long countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int deleteByPrimaryKey(Integer testid);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);
    Test selectByPrimaryKeyWithStu(Integer testid);
    List<Test> selectByExampleWithStu(TestExample example);
    Test selectByPrimaryKey(Integer testid);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);


}