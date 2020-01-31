package org.gdpi.course.service;

import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.pojo.Teacher;
import org.gdpi.course.utils.ExceptionMessage;

import java.util.List;

/**
 * 教师业务层接口
 */
public interface TeacherService {
    /**
     * 根据账号密码登录方法
     * @return
     */
    Teacher login(String username, String password);

    /**
     * 初始化主页
     * @param teacher 主页教师对象
     */
    void initIndex(Teacher teacher);

    /**
     * 注册账户
     * @param teacher
     * @throws ExceptionMessage
     * @return
     */
    Teacher saveTeacher(Teacher teacher) throws ExceptionMessage;

    /**
     * 通过账号查找用户
     * @param username
     * @return
     */
    Teacher findByUsername(String username);

    /**
     * 表单校验
     * @param teacher
     * @return
     */
    String fromCheck(Teacher teacher);

    /**
     * 删除课程
     * @param cid 课程id
     * @param tid 教师id
     * @return
     */
    List<Course> removeCourse(Integer cid, Integer tid);

    /**
     *
     * @param cid
     * @param sid
     * @return
     */
    List<Student> removeMember(Integer cid, Integer sid);
}
