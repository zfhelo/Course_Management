package org.gdpi.course.dao;

import org.gdpi.course.pojo.GapFilling;

public interface GapFillingDao {
    /**
     * 添加题目到题库
     * @param gapFilling
     */
    void saveQuestion(GapFilling gapFilling);
}
