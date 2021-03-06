package vip.yydz.service.impl;
import org.springframework.stereotype.Service;
import vip.yydz.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import vip.yydz.dao.StudentMapper;
import vip.yydz.domain.Student;
import vip.yydz.domain.StudentExample;

import java.util.List;
@Service(value = "studentService")
public class StudentServiceImpl implements  StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public long countByExample(StudentExample example) {
        return studentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(StudentExample example) {
        return studentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer stuid) {
        return studentMapper.deleteByPrimaryKey(stuid);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public List<Student> selectByExample(StudentExample example) {
        return studentMapper.selectByExample(example);
    }

    @Override
    public List<Student> selectByExampleWithTest(StudentExample example) {
        return studentMapper.selectByExampleWithTest(example);
    }

    @Override
    public Student selectByPrimaryKey(Integer stuid) {
        return studentMapper.selectByPrimaryKey(stuid);
    }

    @Override
    public Student selectByPrimaryKeyWithTest(Integer stuid) {
        return studentMapper.selectByPrimaryKey(stuid);
    }

    @Override
    public int updateByExampleSelective(Student record, StudentExample example) {
        return studentMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Student record, StudentExample example) {
        return studentMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }
}
