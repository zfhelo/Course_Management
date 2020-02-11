package org.gdpi.course.controller;

import com.github.pagehelper.PageInfo;
import org.gdpi.course.pojo.Comment;
import org.gdpi.course.pojo.Issues;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.pojo.Teacher;
import org.gdpi.course.service.DiscussService;
import org.gdpi.course.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * 讨论板块
 */
@Controller
public class DiscussController {

    @Autowired
    private DiscussService discussService;

    /**
     * 发帖
     * @param identity 身份
     * @param id 课程id
     * @param file 图片资源
     * @param session
     * @param issues
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(path = "/{identity}/postIssues", params = {"title", "content"})
    public ResponseMessage postIssues(@PathVariable("identity") String identity,
                                      @SessionAttribute("CURRENT_COURSE") Integer id,
                                      MultipartFile file,
                                      HttpSession session,
                                      Issues issues) throws Exception{
        issues.setCid(id);
        // 教师
        if ("teacher".equals(identity)) {
            Teacher teacher = (Teacher)session.getAttribute("TEACHER");

            if (teacher == null) {
                return ResponseMessage.failed();
            }
            issues.setNickname(teacher.getNickname());
            discussService.createIssues(teacher, file, session, issues);
            return ResponseMessage.success();

        }
        // 学生
        if ("student".equals(identity)) {
            Student student = (Student) session.getAttribute("STUDENT");

            if (student == null) {
                return ResponseMessage.failed();
            }
            issues.setNickname(student.getNickname());
            discussService.createIssues(student, file, session, issues);
            return ResponseMessage.success();
        }
        return ResponseMessage.failed();
    }

    /**
     * 发送评论
     * @param identity 身份
     * @param file 图片
     * @param session
     * @param comment 内容
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(path = "/{identity}/postComment", params = {"content"})
    public ResponseMessage postComment(@PathVariable("identity") String identity,
                                      @SessionAttribute("CURRENT_COURSE") Integer id,
                                      MultipartFile file,
                                      HttpSession session,
                                      Comment comment) throws Exception{
        comment.setCid(id);

        // 教师
        if ("teacher".equals(identity)) {
            Teacher teacher = (Teacher)session.getAttribute("TEACHER");

            if (teacher == null) {
                return ResponseMessage.failed();
            }
            comment.setNickname(teacher.getNickname());
            comment = discussService.createComment(teacher, file, session, comment);
            ResponseMessage success = ResponseMessage.success();
            success.putAttribute("comment", comment);
            return success;

        }
        // 学生
        if ("student".equals(identity)) {
            Student student = (Student) session.getAttribute("STUDENT");

            if (student == null) {
                return ResponseMessage.failed();
            }
            comment.setNickname(student.getNickname());
            comment = discussService.createComment(student, file, session, comment);
            ResponseMessage success = ResponseMessage.success();
            success.putAttribute("comment", comment);
            return success;
        }
        return ResponseMessage.failed();
    }

    /**
     * 分页显示帖子
     * @param cid
     * @param page
     * @param pageSize
     * @return
     */
    @ResponseBody
    @PostMapping("/issues/findPage")
    public PageInfo<Issues> findIssuesPage(@SessionAttribute("CURRENT_COURSE") Integer cid,
                                     @RequestParam Integer page,
                                     @Value("${issuesPageSize}") Integer pageSize) {
        return discussService.findIssuesPage(cid, page, pageSize);
    }

    /**
     * 分页显示评论
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    @ResponseBody
    @PostMapping("/comment/findPage")
    public PageInfo<Comment> findCommentPage(@RequestParam Integer id,
                                     @RequestParam Integer page,
                                     @Value("${commentPageSize}") Integer pageSize) {
        return discussService.findCommentPage(id, page, pageSize);
    }
}
