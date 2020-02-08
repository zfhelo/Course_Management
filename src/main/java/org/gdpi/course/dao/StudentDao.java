package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
import org.gdpi.course.pojo.Student;

/**
 * student表持久层接口
 */
public interface StudentDao {
    /**
     * 根据账户名查找用户
     * @return
     */
    Student findByUsername(String username);


    /**
     * 注册账号
     * @param student
     * @return
     */
    void saveStudent(Student student);

    /**
     * 移除选课
     * @param cid
     * @param sid
     */
    void removeCourse(@Param("cid") Integer cid, @Param("sid") Integer sid);

    /**
     * 通过id查找学生
     * @param id
     * @return
     */
    Student findById(Integer id);
}
