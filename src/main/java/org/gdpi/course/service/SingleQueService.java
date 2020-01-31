package org.gdpi.course.service;

import org.gdpi.course.pojo.SingleQuestion;
import org.gdpi.course.utils.ExceptionMessage;

public interface SingleQueService {
    /**
     * 添加题目到题库
     * @param singleQuestion
     * @throws ExceptionMessage
     */
    void saveQuestion(SingleQuestion singleQuestion) throws ExceptionMessage;
}
