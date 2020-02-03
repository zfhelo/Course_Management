package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
import org.gdpi.course.pojo.ExamPaperModel;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 试卷相关dao层
 */
@Controller
public interface ExamDao {
    /**
     * 创建模板试卷
     * @param examPaperModel
     */
    void createPaperModel(ExamPaperModel examPaperModel);

    /**
     * 创建试卷
     * @param sid 学生id
     * @param mid 模板试卷id
     */
    void createPaper(@Param("sid") Integer sid, @Param("mid") Integer mid);

    /**
     * 查询此模板试卷生成的试卷
     * @param mid
     * @return 试卷id
     */
    List<Integer> findByMid(Integer mid);

    /**
     * 插入选择题
     * @param paperId 试卷id
     * @param qid 题目id
     */
    void insertSingleQue(@Param("paperId") Integer paperId, @Param("qId") Integer qid);

    /**
     * 插入填空题
     * @param paperId
     * @param qid
     */
    void insertGapQue(@Param("paperId") Integer paperId, @Param("qId") Integer qid);

    /**
     * 插入解答题
     * @param paperId
     * @param qid
     */
    void insertEssayQue(@Param("paperId") Integer paperId, @Param("qId") Integer qid);


}
