package org.gdpi.course.service;

import org.gdpi.course.pojo.EssayQuestion;
import org.gdpi.course.pojo.GapFilling;
import org.gdpi.course.utils.ExceptionMessage;

public interface EssayQueService {
    /**
     * 添加题目到题库
     * @param essayQuestion
     * @throws ExceptionMessage
     */
    void saveQuestion(EssayQuestion essayQuestion) throws ExceptionMessage;
}
