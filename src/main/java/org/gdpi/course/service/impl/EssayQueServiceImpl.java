package org.gdpi.course.service.impl;

import org.gdpi.course.dao.EssayQueDao;
import org.gdpi.course.pojo.EssayQuestion;
import org.gdpi.course.service.EssayQueService;
import org.gdpi.course.utils.ExceptionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("esayQueService")
public class EssayQueServiceImpl implements EssayQueService {

    @Autowired
    private EssayQueDao essayQueDao;

    /**
     * 保存题目
     * @param essayQuestion
     */
    @Override
    public void saveQuestion(EssayQuestion essayQuestion) throws ExceptionMessage {
        check(essayQuestion);
        essayQueDao.saveQuestion(essayQuestion);
    }

    @Override
    public List<EssayQuestion> findByGradeLessThan(Integer grade, Integer cid) {
        return essayQueDao.findByGradeLessThan(grade, cid) ;
    }

    private void check(EssayQuestion essayQuestion) throws ExceptionMessage {
        if (essayQuestion.getGrade() == null) {
            throw new ExceptionMessage("题目不完整");
        }
        if (essayQuestion.getContent() == null || essayQuestion.getContent().equals("")) {
            throw new ExceptionMessage("题目不完整");
        }
    }
}
