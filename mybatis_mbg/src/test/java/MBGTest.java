import com.lyl.bean.Employee;
import com.lyl.bean.EmployeeExample;
import com.lyl.bean.Teacher;
import com.lyl.dao.EmployeeMapper;
import com.lyl.dao.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MBGTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void initSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() {
        SqlSession openSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = openSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = new ArrayList<Teacher>();
        for (int i = 0; i < 1000; i++) {
            Teacher teacher = new Teacher();
            teacher.setTeachername(UUID.randomUUID().toString().substring(0,5));
            teacher.setClassName(UUID.randomUUID().toString().substring(0,5));
            teachers.add(teacher);
        }
        mapper.insertBatch(teachers);
        openSession.commit();
        openSession.close();
    }

    @Test
    public void test01() {
        SqlSession openSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = openSession.getMapper(TeacherMapper.class);
        try {
            Teacher teacher = mapper.selectByPrimaryKey(1);
            System.out.println(teacher);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test02() {
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
        try {
            Employee employee = mapper.selectByPrimaryKey(1);
            System.out.println(employee);
//            EmployeeExample employeeExample = new EmployeeExample();
//            mapper.selectByExample(employeeExample);
//            System.out.println(employeeExample);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test03() {
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
        try {
            Employee employee = new Employee();
            employee.setId(1);
            employee.setEmpname("李一龙");
            employee.setGender(1);
            employee.setEmail("LYL1009@qq.com");
            employee.setLoginAccount("LYL");
//            int i = mapper.updateByPrimaryKeySelective(employee);
            mapper.updateByPrimaryKey(employee);
        } finally {
            openSession.commit();
            openSession.close();
        }
    }
}