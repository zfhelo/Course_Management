package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
import org.gdpi.course.pojo.StudentResources;
import org.gdpi.course.pojo.TeacherResources;

import java.util.List;

/**
 * 资源表
 */
public interface ResourcesDao {
    /**
     * 保存教师文件
     * @param teacherResources
     */
    void saveTeacherFile(TeacherResources teacherResources);

    /**
     * 保存学生文件
     * @param studentResources
     */
    void saveStudentFile(StudentResources studentResources);

    /**
     * 查询所有
     * @return
     */
    List<TeacherResources> findTeacherAll(Integer cid);

    List<StudentResources> findStudentAll(Integer cid);

    /**
     * 删除资源
     * @param id
     * @param cid
     */
    void deleteTeaResources(@Param("id") Integer id, @Param("cid") Integer cid);

    void deleteStuResources(@Param("id") Integer id, @Param("cid") Integer cid);

    /**
     * 查找教师资源
     * @param id 资源id
     */
    TeacherResources findTeaById(Integer id);

    /**
     * 查找学生资源
     * @param id 资源id
     */
    StudentResources findStuById(Integer id);
}
