package org.gdpi.course.dao;

import org.gdpi.course.pojo.TeacherResources;

/**
 * 资源表
 */
public interface ResourcesDao {
    /**
     * 保存教师文件
     * @param teacherResources
     */
    void saveTeacherFile(TeacherResources teacherResources);
}
