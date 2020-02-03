package org.gdpi.course.service;

import org.gdpi.course.pojo.GapFilling;
import org.gdpi.course.utils.ExceptionMessage;

import java.util.List;

public interface GapFillingService {
    /**
     * 添加题目到题库
     * @param gapFilling
     * @throws ExceptionMessage
     */
    void saveQuestion(GapFilling gapFilling) throws ExceptionMessage;

    /**
     * 查找<=此分值的题目
     * @param grade
     * @return
     */
    List<GapFilling> findByGradeLessThan(Integer grade, Integer cid);
}
