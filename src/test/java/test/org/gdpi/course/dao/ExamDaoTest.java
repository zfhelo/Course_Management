package test.org.gdpi.course.dao;

import org.gdpi.course.dao.ExamDao;
import org.gdpi.course.pojo.ExamPaperModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ExamDaoTest {

    @Autowired
    ExamDao examDao;

    @Test
    public void testCratePaperModel() {
        ExamPaperModel examPaperModel = new ExamPaperModel();
        examPaperModel.setTitle("aaaaaaaa");
        examPaperModel.setTid(1);
        examPaperModel.setCid(1);
        examDao.createPaperModel(examPaperModel);
        System.out.println(examPaperModel);
    }
    @Test
    public void testCreatePaper() {
        examDao.createPaper(1, 2);
    }

    @Test
    public void testFindByMid() {
        List<Integer> byMid = examDao.findByMid(2);
        System.out.println(byMid);
    }

    @Test
    public void testFindByMidCount() {
        Integer byMIdCount = examDao.findByMIdCount(11);
        System.out.println(byMIdCount);
    }
    @Test
    public void testFindCommitNum() {
        Integer commitNum = examDao.findCommitNum(5);
        System.out.println(commitNum);
    }
}
