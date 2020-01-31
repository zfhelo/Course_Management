package test.org.gdpi.course.service;

import org.gdpi.course.pojo.Student;
import org.gdpi.course.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void testSaveStudent() throws Exception{
        Student student = new Student();
        student.setNickname("哈哈");
        student.setPassword("123");
        student.setUsername("11111111");
        studentService.saveStudent(student);
        System.out.println(student);
    }
}
