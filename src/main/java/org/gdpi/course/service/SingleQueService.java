package org.gdpi.course.service;

import org.gdpi.course.pojo.SingleQuestion;
import org.gdpi.course.utils.ExceptionMessage;

import java.util.List;

public interface SingleQueService {
    /**
     * 添加题目到题库
     * @param singleQuestion
     * @throws ExceptionMessage
     */
    void saveQuestion(SingleQuestion singleQuestion) throws ExceptionMessage;

    /**
     * 查找<=此分值的题目
     * @param grade
     * @return
     */
    List<SingleQuestion> findByGradeLessThan(Integer grade, Integer cid);
}
