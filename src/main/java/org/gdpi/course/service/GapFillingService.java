package org.gdpi.course.service;

import org.gdpi.course.pojo.GapFilling;
import org.gdpi.course.utils.ExceptionMessage;

public interface GapFillingService {
    /**
     * 添加题目到题库
     * @param gapFilling
     * @throws ExceptionMessage
     */
    void saveQuestion(GapFilling gapFilling) throws ExceptionMessage;
}
