package test.org.gdpi.course.dao;

import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CourseDaoTest {
    @Autowired
    private CourseService courseService;

    @Test
    public void testSaveCourse() throws Exception{
        Course course = new Course();
        course.setName("英语1");
        course.setNumber("12314");
        course.setTid(1);
        courseService.saveCourse(course);
        System.out.println(course);
    }

    @Test
    public void testFindStduentById() {
        List<Student> studentById = courseService.findStudentById(3);
        System.out.println(studentById);
    }

    @Test
    public void testFindCourse() {
        List<Course> a = courseService.findCourse("数据");
        System.out.println(a);
    }
}
