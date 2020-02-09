package org.gdpi.course.dao;

import org.apache.ibatis.annotations.Param;
import org.gdpi.course.pojo.Comment;

import java.util.List;

public interface CommentDao {
    /**
     * 创建评论
     * @param comment
     * @return
     */
    boolean insertComment(Comment comment);

    /**
     * 生成帖子与学生的关系
     * @param sid
     * @param iid
     */
    void insertStuMap(@Param("sid") Integer sid, @Param("cid") Integer iid);

    /**
     * 生成帖子与教师的关系
     * @param tid
     * @param iid
     */
    void insertTeaMap(@Param("tid") Integer tid, @Param("cid") Integer iid);

    /**i
     * 根据id查找评论
     * @param iid
     * @return
     */
    List<Comment> findAllByIid(Integer iid);
}
