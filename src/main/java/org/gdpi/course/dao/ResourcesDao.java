package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
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
     * 查询所有
     * @return
     */
    List<TeacherResources> findTeacherAll(Integer cid);

    /**
     * 删除资源
     * @param id
     * @param cid
     */
    void deleteTeaResources(@Param("id") Integer id, @Param("cid") Integer cid);

    /**
     * 查找教师资源
     * @param id
     */
    TeacherResources findTeaById(Integer id);
}
