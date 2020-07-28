import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vip.yydz.dao.StudentMapper;
import vip.yydz.dao.TestMapper;
import vip.yydz.domain.Student;
import vip.yydz.domain.StudentExample;
import vip.yydz.domain.TestExample;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class SelectTest {
   @Autowired
   private StudentMapper studentMapper;
   @Autowired
   private TestMapper testMapper;
    @Test
    public void test1()
    {
//        StudentExample studentExample=new StudentExample();
//        studentExample.createCriteria().andStuidEqualTo(1);
//       System.out.println(studentMapper.selectByPrimaryKeyWithTest(1));
//        //System.out.println(testMapper.selectByPrimaryKeyWithStu(1));
        TestExample example=new TestExample();
        example.createCriteria().andIsubmitEqualTo(true);
        example.createCriteria().andTestfkEqualTo(1);
        List<vip.yydz.domain.Test> tests=testMapper.selectByExample(example);
        System.out.println(tests);
    }
}
