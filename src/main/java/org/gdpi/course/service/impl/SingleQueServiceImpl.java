package org.gdpi.course.service.impl;

import org.gdpi.course.dao.SingleQueDao;
import org.gdpi.course.pojo.SingleQuestion;
import org.gdpi.course.service.SingleQueService;
import org.gdpi.course.utils.ExceptionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("singleQueService")
public class SingleQueServiceImpl implements SingleQueService {

    @Autowired
    SingleQueDao singleQueDao;

    @Override
    public void saveQuestion(SingleQuestion singleQuestion) {
        singleQueDao.saveQuestion(singleQuestion);
    }
}
