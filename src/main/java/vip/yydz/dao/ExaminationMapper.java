package vip.yydz.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.yydz.domain.Examination;
import vip.yydz.domain.ExaminationExample;

public interface ExaminationMapper {
    long countByExample(ExaminationExample example);

    int deleteByExample(ExaminationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Examination record);

    int insertSelective(Examination record);

    List<Examination> selectByExample(ExaminationExample example);

    Examination selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Examination record, @Param("example") ExaminationExample example);

    int updateByExample(@Param("record") Examination record, @Param("example") ExaminationExample example);

    int updateByPrimaryKeySelective(Examination record);

    int updateByPrimaryKey(Examination record);
}