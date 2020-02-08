package org.gdpi.course.service.impl;

import org.gdpi.course.dao.SingleQueDao;
import org.gdpi.course.pojo.SingleQuestion;
import org.gdpi.course.service.SingleQueService;
import org.gdpi.course.utils.ExceptionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("singleQueService")
public class SingleQueServiceImpl implements SingleQueService {

    @Autowired
    SingleQueDao singleQueDao;

    @Override
    public List<SingleQuestion> findByGradeLessThan(Integer grade, Integer cid) {
        return singleQueDao.findByGradeLessThan(grade, cid);
    }

    @Override
    public void saveQuestion(SingleQuestion singleQuestion) throws ExceptionMessage{
        check(singleQuestion);
        singleQueDao.saveQuestion(singleQuestion);
    }
    private void check(SingleQuestion singleQuestion) throws ExceptionMessage {
        boolean flag = false;
        if (singleQuestion.getGrade() == null) {
            flag = true;
        }
        if (singleQuestion.getContent() == null || singleQuestion.getContent().equals("")) {
            flag = true;
        }
        if (singleQuestion.getChoise1() == null || singleQuestion.getChoise1().equals("")) {
            flag = true;
        }
        if (singleQuestion.getChoise2() == null || singleQuestion.getChoise2().equals("")) {
            flag = true;
        }
        if (singleQuestion.getChoise3() == null || singleQuestion.getChoise3().equals("")) {
            flag = true;
        }
        if (singleQuestion.getChoise4() == null || singleQuestion.getChoise4().equals("")) {
            flag = true;
        }
        if (flag) {
            throw new ExceptionMessage("题目不完整");
        }
    }
}
