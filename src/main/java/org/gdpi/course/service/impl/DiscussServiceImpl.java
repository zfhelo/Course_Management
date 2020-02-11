package org.gdpi.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.gdpi.course.dao.CommentDao;
import org.gdpi.course.dao.IssuesDao;
import org.gdpi.course.pojo.*;
import org.gdpi.course.service.DiscussService;
import org.gdpi.course.utils.ExceptionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("discussService")
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private IssuesDao issuesDao;

    @Autowired
    private CommentDao commentDao;
    /**
     * 创建帖子
     * @param student 学生对象
     * @param file 图片
     * @param session
     * @param issues 贴
     * @throws ExceptionMessage
     */
    @Override
    public void createIssues(Student student, MultipartFile file, HttpSession session, Issues issues) throws ExceptionMessage {
        issues = create(student, file, session, issues);
        if (issues == null) {
            throw new ExceptionMessage("创建失败");
        }
        issuesDao.insertStuMap(student.getId(), issues.getId());

    }

    /**
     * 创建帖子
     * @param teacher
     * @param file 图片
     * @param session
     * @param issues 贴
     * @throws ExceptionMessage
     */
    @Override
    public void createIssues(Teacher teacher, MultipartFile file, HttpSession session, Issues issues) throws ExceptionMessage {
        issues = create(teacher, file, session, issues);
        if (issues == null) {
            throw new ExceptionMessage("创建失败");
        }
        issuesDao.insertTeaMap(teacher.getId(), issues.getId());
    }

    /**
     * 创建评论
     * @param student 身份
     * @param file 图片
     * @param session
     * @param comment 内容
     * @return
     * @throws ExceptionMessage
     */
    @Override
    public Comment createComment(Student student, MultipartFile file, HttpSession session, Comment comment) throws ExceptionMessage {
        comment = create(student, file, session, comment);
        if (comment == null) {
            throw new ExceptionMessage("创建失败");
        }
        commentDao.insertStuMap(student.getId(), comment.getId());
        comment.setTime(new Date());
        return comment;
    }

    /**
     * 创建评论
     * @param teacher 身份
     * @param file 图片
     * @param session
     * @param comment 内容
     * @return
     * @throws ExceptionMessage
     */
    @Override
    public Comment createComment(Teacher teacher, MultipartFile file, HttpSession session, Comment comment) throws ExceptionMessage {
        comment = create(teacher, file, session, comment);
        if (comment == null) {
            throw new ExceptionMessage("创建失败");
        }
        commentDao.insertStuMap(teacher.getId(), teacher.getId());
        comment.setTime(new Date());
        return comment;
    }

    /**
     * 分页查找
     *
     * @param cid
     * @param page 页码
     * @param pageSize 条数
     * @return
     */
    @Override
    public PageInfo<Issues> findIssuesPage(Integer cid, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Issues> all = issuesDao.findAllByCId(cid);
        return new PageInfo<Issues>(all, 5);
    }

    /**
     * 评论分页显示
     * @param iid
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Comment> findCommentPage(Integer iid, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Comment> all = commentDao.findAllByIid(iid);
        return new PageInfo<Comment>(all, 5);
    }

    /**
     * 创建帖子
     * @param user
     * @param file
     * @param session
     * @param issues
     * @return 失败返回Null
     */
    private Issues create(User user, MultipartFile file, HttpSession session, Issues issues) {
        if (user == null || issues == null) {
            return null;
        }

        // 有文件
        if (file != null) {
            saveFile(file, session, issues);
        }

        // 写入数据库
        boolean result = issuesDao.insertIssues(issues);

        return result ? issues : null;
    }

    /**
     * 创建评论
     * @param user
     * @param file
     * @param session
     * @param comment
     * @return 失败返回Null
     */
    private Comment create(User user, MultipartFile file, HttpSession session, Comment comment) {
        if (user == null || comment == null) {
            return null;
        }

        // 有文件
        if (file != null) {
            saveFile(file, session, comment);
        }

        // 写入数据库
        boolean result = commentDao.insertComment(comment);

        return result ? comment : null;
    }

    /**
     * 保存帖子文件
     * @param file
     * @param session
     * @param issues
     */
    private void saveFile(MultipartFile file, HttpSession session, Issues issues) {
        //images/issues/课程id/
        String path = session.getServletContext().getRealPath("/");
        String filePath = "images/issues/"+issues.getCid();
        File parent = new File(path+filePath);
        // 判断是否存在
        if (!parent.exists()) {
            parent.mkdirs();
        }
        String filename = saveFile(file, parent);
        issues.setPath(filePath + "/" + filename);
    }

    /**
     * 保存评论文件
     * @param file
     * @param session
     * @param comment
     */
    private void saveFile(MultipartFile file, HttpSession session, Comment comment) {
        //images/comment/课程id/帖子id
        String path = session.getServletContext().getRealPath("/");
        String filePath = "images/comment/"+comment.getCid()+"/"+comment.getIid();
        File parent = new File(path+filePath);
        // 判断是否存在
        if (!parent.exists()) {
            parent.mkdirs();
        }
        String filename = saveFile(file, parent);
        comment.setPath(filePath + "/" + filename);
    }

    /**
     * 写入文件
     * @param file 文件
     * @param parent 父目录
     */
    private String saveFile(MultipartFile file, File parent) {
        // 拿到文件名
        String filename = file.getOriginalFilename();
        // 获取一个随机字符串
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().split("-")[0];
        filename = s + "_"+ filename;

        try {
            file.transferTo(new File(parent,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

}
