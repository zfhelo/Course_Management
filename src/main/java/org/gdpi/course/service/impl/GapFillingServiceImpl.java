package org.gdpi.course.service.impl;

import org.gdpi.course.dao.GapFillingDao;
import org.gdpi.course.pojo.GapFilling;
import org.gdpi.course.service.GapFillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gapFillingService")
public class GapFillingServiceImpl implements GapFillingService {

    @Autowired
    private GapFillingDao gapFillingDao;

    /**
     * 保存题目
     * @param gapFilling
     */
    @Override
    public void saveQuestion(GapFilling gapFilling) {
        gapFillingDao.saveQuestion(gapFilling);
    }

    @Override
    public List<GapFilling> findByGradeLessThan(Integer grade, Integer cid) {
        return gapFillingDao.findByGradeLessThan(grade, cid);
    }
}
