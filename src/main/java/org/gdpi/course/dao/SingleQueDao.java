package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
import org.gdpi.course.pojo.SingleQuestion;

import java.util.List;

public interface SingleQueDao {
    /**
     * 添加题目到题库
     * @param singleQuestion
     */
    void saveQuestion(SingleQuestion singleQuestion);


    /**
     * 查找grade小于此成绩的题目
     * @return
     */
    List<SingleQuestion> findByGradeLessThan(@Param("grade") Integer grade, @Param("cid") Integer cid);
}
