package org.gdpi.course.service.impl;

import org.gdpi.course.dao.CourseDao;
import org.gdpi.course.dao.StudentDao;
import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.service.StudentService;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.FromCheck;
import org.gdpi.course.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生业务层接口实现类
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;


    @Override
    public Student saveStudent(Student student) throws ExceptionMessage {

        // 检查账号是否已注册
        if (studentDao.findByUsername(student.getUsername()) != null) {
            throw new ExceptionMessage("账号已被注册");
        }

        // 表单校验
        String msg = fromCheck(student);
        if (msg != null) {
            throw new ExceptionMessage(msg);
        }

        studentDao.saveStudent(student);
        return student;
    }


    @Override
    public void initIndex(Student student) {

    }

    @Override
    public Student login(String username, String password) {
        Student stu = studentDao.findByUsername(username);
        // 查询到账户
        if (stu != null && stu.getPassword().equals(password)) {
            return stu;
        }
        return null;
    }
    @Override
    public Student findByUsername(String username) {
        return studentDao.findByUsername(username);
    }

    /**
     * 表单校验
     * @param student
     * @return
     */
    @Override
    public String fromCheck(Student student) {
        String password = student.getPassword();
        String nickname = student.getNickname();
        String username = student.getUsername();
        if (nickname != null && !FromCheck.nickname(nickname)) {
            return "姓名长度为1-30";
        }
        if (username != null && !FromCheck.username(username)) {
            return "账号为6-12位(0-9a-zA-Z)";
        }
        if (password != null && !FromCheck.password(password)) {
            return "密码为6-30位(0-9a-zA-Z.)";
        }
        if (student.getPhoto() == null) {
            student.setPhoto("images/web/head.svg");
        }
        return null;
    }

    /**
     * 删除选课
     * @param cid 课程id
     * @param sid 学生id
     * @return
     */
    @Override
    public List<Course> removeCourse(Integer cid, Integer sid) {
        studentDao.removeCourse(cid, sid);
        return courseDao.findBySId(sid);
    }
}
