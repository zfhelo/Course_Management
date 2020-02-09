package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
import org.gdpi.course.pojo.Issues;

import java.util.List;

public interface IssuesDao {
    /**
     * 保存帖子
     * @param issues
     * @return
     */
    boolean insertIssues(Issues issues);

    /**
     * 生成帖子与学生的关系
     * @param sid
     * @param iid
     */
    void insertStuMap(@Param("sid") Integer sid, @Param("iid") Integer iid);

    /**
     * 生成帖子与教师的关系
     * @param tid
     * @param iid
     */
    void insertTeaMap(@Param("tid") Integer tid, @Param("iid") Integer iid);

    /**
     * 查找所有评论
     * @return
     * @param cid
     */
    List<Issues> findAllByCId(Integer cid);
}
