package org.gdpi.course.service;

import org.gdpi.course.pojo.EssayQuestion;
import org.gdpi.course.utils.ExceptionMessage;

import java.util.List;

public interface EssayQueService {
    /**
     * 添加题目到题库
     * @param essayQuestion
     * @throws ExceptionMessage
     */
    void saveQuestion(EssayQuestion essayQuestion) throws ExceptionMessage;

    /**
     * 查找<=此分值的题目
     * @param grade
     * @return
     */
    List<EssayQuestion> findByGradeLessThan(Integer grade, Integer cid);
}
