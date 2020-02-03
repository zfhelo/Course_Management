package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
import org.gdpi.course.pojo.GapFilling;

import java.util.List;

public interface GapFillingDao {
    /**
     * 添加题目到题库
     * @param gapFilling
     */
    void saveQuestion(GapFilling gapFilling);


    /**
     * 查找grade小于此成绩的题目
     * @return
     */
    List<GapFilling> findByGradeLessThan(@Param("grade") Integer grade, @Param("cid") Integer cid);
}
