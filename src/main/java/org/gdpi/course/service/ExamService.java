package org.gdpi.course.service;

import org.gdpi.course.pojo.ExamPaper;
import org.gdpi.course.pojo.ExamPaperModel;
import org.gdpi.course.utils.ExceptionMessage;

import java.util.List;

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

    /**
     * 通过课程号查找
     * @param cid
     * @return
     */
    List<ExamPaperModel> findByCidForStu(Integer cid);

    /**
     * 查找试卷
     * @param mid 模板试卷id
     * @param sid 学生id
     * @return
     */
    ExamPaper findPaper(Integer mid, Integer sid) throws ExceptionMessage;

    /**
     * 更新答案
     * @param answer
     * @param id
     * @param mid
     * @param pid
     * @throws ExceptionMessage
     */
    void updateSingle(String answer, Integer id, Integer mid, Integer pid) throws ExceptionMessage;

    void updateGap(String answer, Integer id, Integer mid, Integer pid) throws ExceptionMessage;
    void updateEssay(String answer, Integer id, Integer mid, Integer pid) throws ExceptionMessage;

    /**
     * 提交试卷
     * @param id
     * @param sid
     */
    void commitPaper(Integer id, Integer sid) throws ExceptionMessage;

    /**
     * 计算成绩
     * @param id 试卷id
     * @param sid 学生id
     */
    void computerGrade(Integer id, Integer sid);

    /**
     * 通过mid查找试卷
     * @param mid
     * @return
     */
    List<ExamPaper> findAllPaper(Integer mid);

    /**
     * 查找试卷
     * @param id 试卷id
     * @param sid 学生id
     * @return
     * @throws ExceptionMessage
     */
    ExamPaper findPaperTea(Integer id, Integer sid) throws ExceptionMessage;

    /**
     * 教师提交成绩
     * @param grade
     */
    void commitGrade(ExamPaper grade);
}
