package test.org.gdpi.course.dao;

import org.gdpi.course.dao.TeacherDao;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.pojo.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TeacherDaoTest {
    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void testSaveTeacher() {
        Teacher teacher = new Teacher();
        teacher.setNickname("哈哈");
        teacher.setPassword("123");
        teacher.setUsername("zzaaaaz");
        teacherDao.saveTeacher(teacher);
    }

    @Test
    public void test() {
        Teacher teacher = teacherDao.findByUsername("cheng");
        //
    }
}
