package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
import org.gdpi.course.pojo.EssayQuestion;

import java.util.List;

public interface EssayQueDao {
    /**
     * 添加题目到题库
     * @param essayQuestion
     */
    void saveQuestion(EssayQuestion essayQuestion);

    /**
     * 查找grade小于此成绩的题目
     * @return
     */
    List<EssayQuestion> findByGradeLessThan(@Param("grade") Integer grade, @Param("cid") Integer cid);
}
