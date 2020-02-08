package org.gdpi.course.service.impl;

import org.gdpi.course.dao.GapFillingDao;
import org.gdpi.course.pojo.GapFilling;
import org.gdpi.course.service.GapFillingService;
import org.gdpi.course.utils.ExceptionMessage;
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
    public void saveQuestion(GapFilling gapFilling) throws ExceptionMessage {
        check(gapFilling);
        gapFillingDao.saveQuestion(gapFilling);
    }

    @Override
    public List<GapFilling> findByGradeLessThan(Integer grade, Integer cid) {
        return gapFillingDao.findByGradeLessThan(grade, cid);
    }

    private void check(GapFilling gapFilling) throws ExceptionMessage {
        boolean flag = false;
        if (gapFilling.getGrade() == null) {
            flag = true;
        }
        if (gapFilling.getContent() == null || gapFilling.getContent().equals("")) {
            flag = true;
        }
        if (gapFilling.getAnswer() == null || gapFilling.getAnswer().equals("")) {
            flag = true;
        }
        if (flag) {
            throw new ExceptionMessage("题目不完整");
        }
    }
}
