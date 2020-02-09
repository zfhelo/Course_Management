package org.gdpi.course.service;

import com.github.pagehelper.PageInfo;
import org.gdpi.course.pojo.Comment;
import org.gdpi.course.pojo.Issues;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.pojo.Teacher;
import org.gdpi.course.utils.ExceptionMessage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * 讨论业务层接口
 */
public interface DiscussService {
    /**
     * 学生发帖
     * @param student 学生对象
     * @param file 图片
     * @param session
     * @param issues 贴
     * @throws ExceptionMessage
     */
    void createIssues(Student student, MultipartFile file, HttpSession session,  Issues issues) throws ExceptionMessage;

    /**
     * 教师发帖
     * @param teacher
     * @param file 图片
     * @param session
     * @param issues 贴
     * @throws ExceptionMessage
     */
    void createIssues(Teacher teacher, MultipartFile file, HttpSession session, Issues issues) throws ExceptionMessage;

    /**
     * 帖子分页
     *
     * @param cid
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<Issues> findIssuesPage(Integer cid, Integer page, Integer pageSize);

    /**
     * 评论分页
     *
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<Comment> findCommentPage(Integer id, Integer page, Integer pageSize);

    /**
     * 发送评论
     * @param student 身份
     * @param file 图片
     * @param session
     * @param comment 内容
     * @return
     * @throws ExceptionMessage
     */
    Comment createComment(Student student, MultipartFile file, HttpSession session, Comment comment) throws ExceptionMessage;

    /**
     * 发送评论
     * @param teacher 身份
     * @param file 图片
     * @param session
     * @param comment 内容
     * @return
     * @throws ExceptionMessage
     */
    Comment createComment(Teacher teacher, MultipartFile file, HttpSession session, Comment comment) throws ExceptionMessage;

}
