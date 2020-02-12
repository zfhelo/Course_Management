package org.gdpi.course.service;

import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.Grade;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.utils.ExceptionMessage;

import java.util.List;

/**
 * 课程业务层接口
 */
public interface CourseService {

    /**
     * 创建课程
     * @param course
     * @return
     * @throws ExceptionMessage
     */
    Course saveCourse(Course course) throws ExceptionMessage;

    /**
     * 通过tid查找课程
     * @param tid 教师id
     * @return
     */
    List<Course> findByTid(Integer tid);

    /**
     * 查找该课程所有学生
     * @param id
     * @return
     */
    List<Student> findStudentById(Integer id);

    /**
     * 查找课程
     * @param key 课程id或名称
     * @return
     */
    List<Course> findCourse(String key);

    /**
     * 加入课程
     * @param sid 学生id
     * @param cid 课程id
     * @return
     */
    Course joinCourse(Integer sid, Integer cid) throws ExceptionMessage;

    /**
     * 通过id查找课程
     * @param id
     * @return
     */
    Course findById(Integer id);

    /**
     * 通过sid查找课程
     * @param sid
     * @return
     */
    List<Course> findBySid(Integer sid);

    /**
     * 更改成绩
     * @param grade
     */
    void updateGrade(Grade grade);
}
