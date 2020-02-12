package org.gdpi.course.service.impl;

import org.gdpi.course.dao.CourseDao;
import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.Grade;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.service.CourseService;
import org.gdpi.course.utils.ExceptionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public Course saveCourse(Course course) throws ExceptionMessage {
        // 已存在该课程号
        if (courseDao.findByNumber(course.getNumber()) != null){
           throw new ExceptionMessage("课程号已被注册");
        }
        // 使用默认封面
        if (course.getImage() == null) {
            course.setImage("images/web/cover.png");
        }
        courseDao.safeCourse(course);
        return course;
    }

    /**
     * 通过tid查找课程
     * @param tid
     * @return
     */
    @Override
    public List<Course> findByTid(Integer tid) {
        return courseDao.findByTId(tid);
    }

    @Override
    public void updateGrade(Grade grade) {
        courseDao.updateGrade(grade);
    }

    /**
     * 通过sid查找课程
     * @param sid
     * @return
     */
    @Override
    public List<Course> findBySid(Integer sid) {
        return courseDao.findBySId(sid);
    }

    /**
     * 查找该课程的学生
     * @param id 课程id
     * @return
     */
    @Override
    public List<Student> findStudentById(Integer id) {
        return courseDao.findStudentById(id);
    }

    /**
     * 通过 key 查找课程
     * @param key 课程id或课程名
     * @return
     */
    @Override
    public List<Course> findCourse(String key) {
        // 先通过课程号查找
        Course course = courseDao.findByNumber(key);
        // 查找到
        if (course != null) {
            ArrayList<Course> courses = new ArrayList<>();
            courses.add(course);
            return courses;
        }

        // 没查找到 在通过name查找
        List<Course> courses = courseDao.findByNameLike("%"+key+"%");
        return courses;
    }

    @Override
    public Course joinCourse(Integer sid, Integer cid) throws ExceptionMessage {

        Course c = courseDao.findById(cid);
        // 没有该课程
        if (c == null) {
            throw new ExceptionMessage("没有该课程");
        }

        courseDao.joinCourse(sid, cid);
        courseDao.createGradeTable(sid ,cid);
        return c;
    }

    @Override
    public Course findById(Integer id) {
        return courseDao.findById(id);
    }

}
