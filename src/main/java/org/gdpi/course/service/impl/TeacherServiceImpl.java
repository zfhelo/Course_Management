package org.gdpi.course.service.impl;

import org.gdpi.course.dao.CourseDao;
import org.gdpi.course.dao.ExamDao;
import org.gdpi.course.dao.TeacherDao;
import org.gdpi.course.pojo.*;
import org.gdpi.course.service.TeacherService;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.FromCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教师业务层接口实现类
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private ExamDao examDao;

    /**
     * 通过课程号查找该课程所有试卷
     * @param cid
     * @return
     */
    @Override
    public List<ExamPaperModel> findPaperModelByCId(Integer cid) {
        List<ExamPaperModel> models = examDao.findByCId(cid);
        for (ExamPaperModel model:models) {
            // 查找试卷人数;
            Integer person = examDao.findByMIdCount(model.getId());
            model.setMember(person);

            // 查找提交的人数
            Integer commitNum = examDao.findCommitNum(model.getId());
            model.setCommit(commitNum);
        }

        return models;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) throws ExceptionMessage {
        // 检查账号是否已注册
        if (teacherDao.findByUsername(teacher.getUsername()) != null) {
            throw new ExceptionMessage("账号已被注册");
        }
        // 表单校验
        String msg = fromCheck(teacher);
        if (msg != null) {
            throw new ExceptionMessage(msg);
        }

        teacherDao.saveTeacher(teacher);
        return teacher;
    }


    @Override
    public void initIndex(Teacher student) {

    }

    @Override
    public Teacher login(String username, String password) {
        Teacher tea = teacherDao.findByUsername(username);
        // 查询到账户
        if (tea != null && tea.getPassword().equals(password)) {
            return tea;
        }
        return null;
    }
    @Override
    public Teacher findByUsername(String username) {
        return teacherDao.findByUsername(username);
    }

    /**
     * 表单校验
     * @param teacher
     * @return
     */
    @Override
    public String fromCheck(Teacher teacher) {
        String password = teacher.getPassword();
        String nickname = teacher.getNickname();
        String username = teacher.getUsername();

        if (nickname != null && !FromCheck.nickname(nickname)) {
            return "姓名长度为1-30";
        }
        if (username != null && !FromCheck.username(username)) {
            return "账号为6-12位(0-9a-zA-Z)";
        }
        if (password != null && !FromCheck.password(password)) {
            return "密码为6-30位(0-9a-zA-Z.)";
        }
        if (teacher.getPhoto() == null) {
            teacher.setPhoto("images/web/head.svg");
        }
        return null;
    }

    /**
     * 移除学员
     * @param cid
     * @param sid
     * @return
     */
    @Override
    public List<Student> removeMember(Integer cid, Integer sid) {
        courseDao.removeMember(cid, sid);
        // 删除学生试卷
        List<ExamPaperModel> byCId = examDao.findByCId(cid);
        for (ExamPaperModel e:byCId) {
            examDao.deletePaper(sid, e.getId());
            courseDao.deleteGradeTable(sid, cid);
        }
        return courseDao.findStudentById(sid);
    }

    /**
     * 删除课程
     * @param cid 课程id
     * @param tid 教师id
     * @return
     */
    @Override
    public List<Course> removeCourse(Integer cid, Integer tid) {
        teacherDao.removeCourse(cid, tid);
        return courseDao.findByTId(tid);
    }


    @Override
    public List<Grade> findAllGradeTable(Integer cid) {
        return courseDao.findAllGradeByCid(cid);
    }

    /**
     * 删除模板试卷
     * @param id 试卷id
     * @param cid 课程id
     * @throws ExceptionMessage
     */
    @Override
    public void deletePaper(Integer id, Integer cid) throws ExceptionMessage {
        examDao.deleteModelPaper(id, cid);
    }

    @Override
    public void updateEnable(Integer id, Integer enable) throws ExceptionMessage {
        if ( !(enable == 0 || enable ==1) ) {
            throw new ExceptionMessage("错误");
        }
        examDao.updateEnableById(id, enable);
    }

    /**
     * 切换hide状态
     * @param id
     * @param hide
     * @throws ExceptionMessage
     */
    public void updateHide(Integer id, Integer hide) throws ExceptionMessage {
        if ( !(hide == 0 || hide ==1) ) {
            throw new ExceptionMessage("错误");
        }
        // 更新
        examDao.updateHideById(id, hide);
    }


}
