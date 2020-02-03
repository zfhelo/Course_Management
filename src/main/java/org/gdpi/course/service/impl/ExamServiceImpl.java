package org.gdpi.course.service.impl;

import org.gdpi.course.dao.*;
import org.gdpi.course.pojo.*;
import org.gdpi.course.service.CourseService;
import org.gdpi.course.service.ExamService;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.GenerateExamPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 试卷相关接口
 */
@Service("examService")
public class ExamServiceImpl implements ExamService {

    @Autowired
    private EssayQueDao essayQueDao;
    @Autowired
    private GapFillingDao gapFillingDao;
    @Autowired
    private SingleQueDao singleQueDao;
    @Autowired
    private GenerateExamPaper generateExamPaper;
    @Autowired
    private ExamDao examDao;
    @Autowired
    private CourseService courseService;

    /**
     * 为学生创建试卷
     * @param sid 学生id
     * @param mid 模板试卷id
     */
    @Override
    public void createPaper(Integer sid, Integer mid) {
        examDao.createPaper(sid, mid);
    }

    /**
     * 创建模板试卷
     * @param examPaperModel
     */
    @Override
    public void createPaperModel(ExamPaperModel examPaperModel) {
        examDao.createPaperModel(examPaperModel);
    }

    /**
     * 生成试卷
     * @param examPaperModel 模板试卷
     * @throws ExceptionMessage
     */
    public void generatePaper(ExamPaperModel examPaperModel) throws ExceptionMessage {
        // 生成试题
        Map<String, List<Set<Integer>>> questions = findQuestions(examPaperModel);
        // 创建模板试卷
        createPaperModel(examPaperModel);
        // 拿到所有选课学生
        List<Student> students = courseService.findStudentById(examPaperModel.getCid());
        // 为所以学生创建试卷
        for (Student s:students) {
            createPaper(s.getId(), examPaperModel.getId());
        }
        // 拿到所有试卷id
        List<Integer> paperId = examDao.findByMid(examPaperModel.getId());

        // 试卷添加题目
        insertQuestion(questions, paperId);
    }

    /**
     * 生成试卷
     * @param model
     * @throws ExceptionMessage
     * return 生成的试卷
     */
    private Map<String, List<Set<Integer>>> findQuestions(ExamPaperModel model) throws ExceptionMessage{
        boolean flag = false;
        Integer singleNum = model.getSingleNum();
        Integer gapNum = model.getGapNum();
        Integer essayNum = model.getEssayNum();

        Map questions = new HashMap<String,List<? extends Question>>();

        // 选择题数目大于0
        if (singleNum != null && singleNum > 0) {
            flag = true;
            // 查找
            List<SingleQuestion> singleQuestions = singleQueDao.findByGradeLessThan(model.getSingleGrade(), model.getCid());

            if (singleQuestions.size() < singleNum) {
                throw new ExceptionMessage("选择题数目不足");
            }
            questions.put("single", singleQuestions);
        }

        // 查找填空题
        if (gapNum != null && gapNum > 0) {
            flag = true;
            List<GapFilling> gapFillings = gapFillingDao.findByGradeLessThan(model.getGapGrade(), model.getCid());
            if (gapFillings.size() < gapNum) {
                throw new ExceptionMessage("填空题数目不足");
            }
            questions.put("gap", gapFillings);
        }

        // 查找解答题
        if (essayNum != null && essayNum > 0) {
            flag = true;
            List<EssayQuestion> essayQuestions = essayQueDao.findByGradeLessThan(model.getEssayGrade(), model.getCid());
            if (essayQuestions.size() < essayNum) {
                throw new ExceptionMessage("解答题数目不足");
            }
            questions.put("essay", essayQuestions);
        }
        // 都是 0
        if (!flag) {
            throw new ExceptionMessage("生成失败");
        }
        // 生成试卷
        return generateExamPaper.generate(model, questions);
    }

    /**
     * 给试卷插入题目
     * @param questions 题库
     * @param paperId 试卷id集合
     */
    private void insertQuestion(Map<String, List<Set<Integer>>> questions, List<Integer> paperId) {
        List<Set<Integer>> single = questions.get("single");
        List<Set<Integer>> gap = questions.get("gap");
        List<Set<Integer>> essay = questions.get("essay");
        Random random = new Random();

        for (Integer id:paperId) {

            if (single != null) {
                int i = random.nextInt(single.size());
                // 随机拿取一套试题
                Set<Integer> question = single.get(i);
                for (Integer qid:question) {
                    examDao.insertSingleQue(id,qid);
                }
            }

            if (gap != null) {
                int i = random.nextInt(gap.size());
                // 随机拿取一套试题
                Set<Integer> question = gap.get(i);
                for (Integer qid:question) {
                    examDao.insertGapQue(id,qid);
                }
            }

            if (essay != null) {
                int i = random.nextInt(essay.size());
                // 随机拿取一套试题
                Set<Integer> question = essay.get(i);
                for (Integer qid:question) {
                    examDao.insertEssayQue(id,qid);
                }
            }

        }

    }
}
