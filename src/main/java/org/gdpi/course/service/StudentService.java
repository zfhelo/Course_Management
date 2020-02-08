package org.gdpi.course.service;

import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.utils.ExceptionMessage;

import java.util.List;

/**
 * 学生业务层接口
 */
public interface StudentService {
    /**
     * 根据账号密码登录方法
     * @return
     */
    Student login(String username, String password);

    /**
     * 初始化主页
     * @param student 主页学生对象
     */
    void initIndex(Student student);

    /**
     * 注册账户
     * @param student
     * @return
     * @throws ExceptionMessage
     */
    Student saveStudent(Student student) throws ExceptionMessage;

    /**
     * 通过账号查找用户
     * @param username
     * @return
     */
    Student findByUsername(String username);

    /**
     * 表单校验
     * @param student
     * @return
     */
    String fromCheck(Student student);

    /**
     * 移除选课
     * @param cid 课程id
     * @param sid 学生id
     * @return 返回剩余的选课
     */
    List<Course> removeCourse(Integer cid, Integer sid);

}
