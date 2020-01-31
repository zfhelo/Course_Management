package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.Student;

import java.util.List;

/**
 * course表实体类
 */
public interface CourseDao {
    /**
     * 通过sid查找课程
     * @return
     */
    List<Course> findBySId(Integer sid);

    /**
     * 通过tid查找课程
     * @return
     */
    List<Course> findByTId(Integer tid);

    /**
     * 创建课程
     * @param course
     */
    void safeCourse(Course course);

    /**
     * 通过课程号查找课程
     * @param number
     * @return
     */
    Course findByNumber(String number);

    /**
     * 查找该课程所有学生
     * @param id 课程id
     * @return
     */
    List<Student> findStudentById(Integer id);

    /**
     * 通过名字模糊查找课程
     * @param name
     * @return
     */
    List<Course> findByNameLike(String name);

    /**
     * 通过id查找课程
     * @param id
     * @return
     */
    Course findById(Integer id);

    /**
     * 加入课程
     * @param sid 学生id
     * @param cid 课程id
     */
    void joinCourse(@Param("sid") Integer sid, @Param("cid")Integer cid);

    /**
     * 移除学员
     * @param cid 课程id
     * @param sid 学生id
     */
    void removeMember(@Param("cid") Integer cid, @Param("sid") Integer sid);

}
