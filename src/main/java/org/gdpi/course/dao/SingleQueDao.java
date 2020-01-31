package org.gdpi.course.dao;

import org.gdpi.course.pojo.SingleQuestion;

public interface SingleQueDao {
    /**
     * 添加题目到题库
     * @param singleQuestion
     */
    void saveQuestion(SingleQuestion singleQuestion);
}
