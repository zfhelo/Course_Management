package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
import org.gdpi.course.pojo.Teacher;


public interface TeacherDao {
    /**
     * 根据账户名查找用户
     * @return
     */
    Teacher findByUsername(String username);


    /**
     * 注册账号
     * @param teacher
     * @return
     */
    void saveTeacher(Teacher teacher);

    /**
     * 通过id查找教师
     * @param id
     * @return
     */
    Teacher findById(Integer id);

    /**
     * 移除选课
     * @param cid
     * @param tid
     */
    void removeCourse(@Param("cid") Integer cid, @Param("tid") Integer tid);
}
