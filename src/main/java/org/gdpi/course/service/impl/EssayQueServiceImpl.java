package org.gdpi.course.service.impl;

import org.gdpi.course.dao.EssayQueDao;
import org.gdpi.course.dao.GapFillingDao;
import org.gdpi.course.pojo.EssayQuestion;
import org.gdpi.course.pojo.GapFilling;
import org.gdpi.course.service.EssayQueService;
import org.gdpi.course.service.GapFillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("esayQueService")
public class EssayQueServiceImpl implements EssayQueService {

    @Autowired
    private EssayQueDao essayQueDao;

    /**
     * 保存题目
     * @param essayQuestion
     */
    @Override
    public void saveQuestion(EssayQuestion essayQuestion) {
        essayQueDao.saveQuestion(essayQuestion);
    }
}
