package test.org.gdpi.course.dao;

import org.gdpi.course.dao.StudentDao;
import org.gdpi.course.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * student表dao测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testFindByUsername() {
        Student student = studentDao.findByUsername("zzzzzz");
        System.out.println(student);
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student();
        student.setNickname("哈哈");
        student.setPassword("123");
        student.setUsername("zzaaaaz");
        studentDao.saveStudent(student);
        System.out.println(student);
    }

    @Test
    public void t() {
        String pattern = "\\S{1,30}";
        System.out.println("123".matches(pattern));
    }
}
