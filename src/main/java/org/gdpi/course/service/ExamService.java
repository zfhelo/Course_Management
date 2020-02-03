package org.gdpi.course.service;

import org.gdpi.course.pojo.ExamPaperModel;
import org.gdpi.course.utils.ExceptionMessage;

/**
 * 试卷相关接口
 */
public interface ExamService {
    /**
     * 生成试卷
     * @param examPaperModel 模板试卷
     * @throws ExceptionMessage
     */
    void generatePaper(ExamPaperModel examPaperModel) throws ExceptionMessage;

    /**
     * 创建模板试卷
     * @param examPaperModel
     */
    void createPaperModel(ExamPaperModel  examPaperModel);

    /**
     * 创建试卷
     * @param sid 学生id
     * @param mid 模板试卷id
     */
    void createPaper(Integer sid, Integer mid);
}
