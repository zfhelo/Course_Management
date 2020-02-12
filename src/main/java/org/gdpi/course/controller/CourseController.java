package org.gdpi.course.controller;

import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.Grade;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.pojo.Teacher;
import org.gdpi.course.service.CourseService;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"BAR_INDEX", "CURRENT_COURSE"})
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 创建课程
     * @param course
     * @param teacher
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/createCourse", params = {"number", "tid", "name"})
    public ResponseMessage saveCourse(Course course, @SessionAttribute("TEACHER")Teacher teacher) {
        try {
            courseService.saveCourse(course);
            // 创建成功 刷新域对象中teacher的课程
            List<Course> courses = courseService.findByTid(course.getTid());
            teacher.setCourses(courses);
        } catch (ExceptionMessage exceptionMessage) {
            // 出错
            ResponseMessage failed = ResponseMessage.failed();
            exceptionMessage.printStackTrace();
            failed.setMsg(exceptionMessage.getMsg());
            return failed;
        }

        return ResponseMessage.success();
    }

    /**
     * 查找该课程所有学员
     * @param identify 查询者
     * @param id 课程id
     * @param model
     * @return
     */
    @GetMapping("{identify}/member")
    public String enterCourse(@PathVariable("identify") String identify,
                              @RequestParam(required = false) Integer id, ModelMap model,
                              @SessionAttribute(required = false, value = "CURRENT_COURSE") Integer id2) {
        if (id == null) {
            id = id2;
        }
        List<Student> students = courseService.findStudentById(id);
        model.addAttribute("MEMBER",students);
        model.addAttribute("CURRENT_COURSE",id);
        model.addAttribute("BAR_INDEX","member");
        return identify+"/member";
    }

    /**
     * 搜索课程
     * @return
     */
    @ResponseBody
    @GetMapping("/search")
    public ResponseMessage findCourse(@RequestParam String key, @SessionAttribute("STUDENT") Student student) {
        // 搜索结果
        List<Course> courses = courseService.findCourse(key);
        // 已经加入的课程
        List<Course> alreadyJoinCourses = student.getCourses();
        // 删除已选课程
        courses.removeAll(alreadyJoinCourses);
        ResponseMessage success = ResponseMessage.success();

        for (Course c:courses) {
            success.putAttribute(c.getNumber(),c);
        }
        return success;
    }

    /**
     * 加入课程
     * @param id
     * @param student
     * @return
     */
    @ResponseBody
    @GetMapping("/joinCourse")
    public ResponseMessage joinCourse(@RequestParam Integer id,
                                      @SessionAttribute("STUDENT") Student student) {

        try {
            // 加入成功
            Course course = courseService.joinCourse(student.getId(), id);
            // 添加到学生对象中
            student.getCourses().add(course);
        } catch (ExceptionMessage exceptionMessage) {
            // 加入失败
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg(exceptionMessage.getMsg());
            return failed;
        }
        return ResponseMessage.success();
    }

    @PostMapping("/teacher/editGrade")
    @ResponseBody
    public ResponseMessage editGrade(Grade grade,
                                     @SessionAttribute("TEACHER") Teacher teacher) {
        if (grade.getRegularGrade() == null) {
            grade.setRegularGrade(0F);
        }
        if (grade.getFinalGrade() == null) {
            grade.setFinalGrade(0F);
        }

        courseService.updateGrade(grade);
        return ResponseMessage.success();
    }
}
