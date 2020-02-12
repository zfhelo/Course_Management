package org.gdpi.course.service;

import org.gdpi.course.pojo.*;
import org.gdpi.course.utils.ExceptionMessage;

import java.util.List;

/**
 * 教师业务层接口
 */
public interface TeacherService {
    /**
     * 根据账号密码登录方法
     * @return
     */
    Teacher login(String username, String password);

    /**
     * 初始化主页
     * @param teacher 主页教师对象
     */
    void initIndex(Teacher teacher);

    /**
     * 注册账户
     * @param teacher
     * @throws ExceptionMessage
     * @return
     */
    Teacher saveTeacher(Teacher teacher) throws ExceptionMessage;

    /**
     * 通过账号查找用户
     * @param username
     * @return
     */
    Teacher findByUsername(String username);

    /**
     * 表单校验
     * @param teacher
     * @return
     */
    String fromCheck(Teacher teacher);

    /**
     * 删除课程
     * @param cid 课程id
     * @param tid 教师id
     * @return
     */
    List<Course> removeCourse(Integer cid, Integer tid);

    /**
     *
     * @param cid
     * @param sid
     * @return
     */
    List<Student> removeMember(Integer cid, Integer sid);

    /**
     * 通过课程号查找该课程所有试卷
     * @return
     */
    List<ExamPaperModel> findPaperModelByCId(Integer cid);

    /**
     * 切换hide状态
     * @param id
     * @param hide
     * @throws ExceptionMessage
     */
    void updateHide(Integer id, Integer hide) throws ExceptionMessage;

    /**
     * 改变enable字段
     * @param id
     * @param enable
     * @throws ExceptionMessage
     */
    void updateEnable(Integer id, Integer enable) throws ExceptionMessage;

    /**
     * 删除模板试卷
     * @param id 试卷id
     * @param cid 课程id
     * @throws ExceptionMessage
     */
    void deletePaper(Integer id, Integer cid) throws ExceptionMessage;

    /**
     * 查询所有成绩表
     * @param cid
     * @return
     */
    List<Grade> findAllGradeTable(Integer cid);
}
