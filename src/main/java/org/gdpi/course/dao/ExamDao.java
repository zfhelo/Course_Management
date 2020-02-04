package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
import org.gdpi.course.pojo.ExamPaperModel;
import org.gdpi.course.utils.ExceptionMessage;
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

    /**
     * 通过课程号查找所有模板试卷
     * @return
     */
    List<ExamPaperModel> findByCId(Integer cid);

    /**
     * 查找该模板试卷的所有试卷
     * @return
     */
    Integer findByMIdCount(Integer mid);

    /**
     * 查找已提交的学生人数
     * @return
     */
    Integer findCommitNum(Integer mid);

    /**
     * 改变hide字段
     * @param id 试卷id
     * @param hide 状态
     */
    void updateHideById(@Param("id") Integer id, @Param("hide") Integer hide);

    /**
     * 改变enable字段
     * @param id 模板试卷id
     * @param enable 0 不可提交 1 可提交
     */
    void updateEnableById(@Param("id") Integer id, @Param("enable") Integer enable);

    /**
     * 删除模板试卷
     * @param id 试卷id
     * @param cid 课程
     * @throws ExceptionMessage
     */
    void deleteModelPaper(@Param("id") Integer id , @Param("cid") Integer cid) throws ExceptionMessage;
}
