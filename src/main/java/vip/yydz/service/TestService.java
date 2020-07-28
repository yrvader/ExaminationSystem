package vip.yydz.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vip.yydz.dao.TestMapper;
import vip.yydz.domain.Test;
import vip.yydz.domain.TestExample;

import java.util.List;

/**
 * 提供对考试进行更改的服务
 */
public interface TestService {
    /**
     * 求数量
     * @param example
     * @return
     */
    long countByExample(TestExample example);

    /**
     * 删除
     * @param example
     * @return
     */
    int deleteByExample(TestExample example);

    /**
     * 删除
     * @param testid
     * @return
     */
    int deleteByPrimaryKey(Integer testid);
    int insert(Test record);
    int insertSelective(Test record);
    List<Test> selectByExample(TestExample example);
    Test selectByPrimaryKey(Integer testid);
    Test selectByPrimaryKeyWithStu(Integer testid);
    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);
    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);
    int updateByPrimaryKeySelective(Test record);
    int updateByPrimaryKey(Test record);
    /**
     * 更改第i个路径
     */
    public Test updateIthPath(int i,Test test,String path);

    /**
     * 修改ith的成绩
     */
    Test upadteIthScore(int i,Test test,Integer score);
    Test deleteIthPath(int i,Integer testid);
    Test addPath(Integer testid,String path);
    /**
     * 获得第i个路径
     */
    String getIthPath(int i,Test test);
    Integer getIthScore(int i,Test test);
    String[] getPaths(Test test);
}
