package vip.yydz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vip.yydz.dao.ExaminationMapper;
import vip.yydz.domain.Examination;
import vip.yydz.domain.ExaminationExample;
import vip.yydz.service.ExaminationService;

import java.util.List;

public class ExaminationServicImpl implements ExaminationService {
    @Autowired
    private ExaminationMapper examinationMapper;
    @Override
    public long countByExample(ExaminationExample example) {
        return examinationMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ExaminationExample example) {
        return examinationMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return examinationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Examination record) {
        return examinationMapper.insert(record);
    }

    @Override
    public int insertSelective(Examination record) {
        return examinationMapper.insertSelective(record);
    }

    @Override
    public List<Examination> selectByExample(ExaminationExample example) {
        return examinationMapper.selectByExample(example);
    }

    @Override
    public Examination selectByPrimaryKey(Integer id) {
        return examinationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Examination record, ExaminationExample example) {
        return examinationMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Examination record, ExaminationExample example) {
        return examinationMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Examination record) {
        return examinationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Examination record) {
        return examinationMapper.updateByPrimaryKey(record);
    }
}
