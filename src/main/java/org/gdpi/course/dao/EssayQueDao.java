package org.gdpi.course.dao;

import org.gdpi.course.pojo.EssayQuestion;

public interface EssayQueDao {
    /**
     * 添加题目到题库
     * @param essayQuestion
     */
    void saveQuestion(EssayQuestion essayQuestion);
}
