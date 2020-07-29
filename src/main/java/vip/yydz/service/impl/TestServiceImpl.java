package vip.yydz.service.impl;

import org.hamcrest.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import vip.yydz.dao.TestMapper;
import vip.yydz.domain.Test;
import vip.yydz.domain.TestExample;
import vip.yydz.service.TestService;

import java.util.List;
@Service(value = "testService")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public long countByExample(TestExample example) {
        return testMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TestExample example) {
        return testMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer testid) {
        return testMapper.deleteByPrimaryKey(testid);
    }

    @Override
    public int insert(Test record) {
        return testMapper.insert(record);
    }

    @Override
    public int insertSelective(Test record) {
        return testMapper.insertSelective(record);
    }

    @Override
    public List<Test> selectByExample(TestExample example) {
        return testMapper.selectByExample(example);
    }

    @Override
    public List<Test> selecByExampleWithStu(TestExample example) {
        return testMapper.selectByExampleWithStu(example);
    }

    @Override
    public Test selectByPrimaryKey(Integer testid) {
        return testMapper.selectByPrimaryKey(testid);
    }

    @Override
    public Test selectByPrimaryKeyWithStu(Integer testid) {
        return testMapper.selectByPrimaryKeyWithStu(testid);
    }

    @Override
    public int updateByExampleSelective(Test record, TestExample example) {
        return testMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Test record, TestExample example) {
        return testMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Test record) {
        return testMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Test record) {
        return testMapper.updateByPrimaryKey(record);
    }

    @Override
    public Test updateIthPath(int i, Test test, String path) {
        String paths=test.getPicturepaths();
        String[] list=paths.split(";");
        list[i-1]=path;
        String upadtepath=list[0];
        for(int j=1;j<list.length;j++){
            upadtepath=upadtepath+";"+list[j];
        }
        test.setPicturepaths(upadtepath);
        System.out.println(test);
        testMapper.updateByPrimaryKey(test);
        return testMapper.selectByPrimaryKey(test.getTestid());
    }
    @Override
    public Test upadteIthScore(int i, Test test, Integer score) {
        String scores=test.getScores();
        String[] list=scores.split(",");
        list[i-1]=i+"="+score;
        String updateScores=list[0];
        for(int j=1;j<list.length;j++){
            updateScores=updateScores+","+list[j];
        }
        test.setScores(updateScores);
        testMapper.updateByPrimaryKey(test);
        return testMapper.selectByPrimaryKey(test.getTestid());
    }

    @Override
    public Test deleteIthPath(int i, Integer testid) {
        Test test=testMapper.selectByPrimaryKey(testid);
        String paths=test.getPicturepaths();
        String[] list=paths.split(";");

        for(int j=i-1;j<list.length-1;j++){
            list[j]=list[j+1];
        }
        String upadtepath=list[0];
        if(list.length!=1){

            for(int j=1;j<list.length;i++){
                upadtepath=upadtepath+";"+list[j];
            }
        }
        else{
            upadtepath="";
        }
        test.setPicturepaths(upadtepath);
        testMapper.updateByPrimaryKey(test);
        return testMapper.selectByPrimaryKey(test.getTestid());
    }

    @Override
    public Test addPath(Integer testid, String path) {
        Test test=testMapper.selectByPrimaryKey(testid);
        String updatePaths=test.getPicturepaths();
        updatePaths=updatePaths+";"+path;
        test.setPicturepaths(updatePaths);
        testMapper.updateByPrimaryKey(test);
        return testMapper.selectByPrimaryKey(test.getTestid());
    }

    @Override
    public String getIthPath(int i, Test test) {
        String paths=test.getPicturepaths();
        String[] list=paths.split(";");
        return list[i-1];
    }

    @Override
    public Integer getIthScore(int i, Test test) {
        String scores=test.getScores();
        String[] list=scores.split(",");
        String score =list[i-1];
        score=scores.replaceAll(i+"=","");
        Integer ans=Integer.valueOf(scores);
        return ans;
    }

    @Override
    public String[] getPaths(Test test) {
        String[] ans=test.getPicturepaths().split(";");
        return ans;
    }

    @Override
    public Integer[] getScores(Test test) {
        String[] scores=test.getScores().split(",");
        Integer[] ans=new Integer[scores.length];
        for(int i=0;i<scores.length;i++)
        {
            ans[i]=Integer.valueOf(scores[i].split("=")[1]);
        }
        return ans;
    }
}
