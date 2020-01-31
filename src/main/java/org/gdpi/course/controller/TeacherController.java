package org.gdpi.course.controller;

import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.pojo.Teacher;
import org.gdpi.course.service.TeacherService;
import org.gdpi.course.utils.CheckCode;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/teacher")
@SessionAttributes({"BAR_INDEX"})
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    /**
     * 登录方法
     * @param username 账号
     * @param password 密码
     * @param code 验证码
     * @param reallyCode session中的验证码
     * @param session
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public ResponseMessage login(@RequestParam String username, @RequestParam String password,
                                 @RequestParam String code, @SessionAttribute("CHECKCODE_SERVER") String reallyCode,
                                 HttpSession session) {
        // 验证码错误
        if (code != null && !code.equalsIgnoreCase(reallyCode)) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setCode(ResponseMessage.codeError);
            failed.setMsg("验证码错误");
            return failed;
        }

        Teacher user = teacherService.login(username, password);
        // 查询到用户
        if (user != null && user.getPassword().equals(password)) {
            // 添加到域对象
            session.setAttribute("TEACHER", user);
            // 删除验证码
            session.removeAttribute("CHECKCODE_SERVER");
            return ResponseMessage.success();
        }
        // 登录失败
        ResponseMessage failed = ResponseMessage.failed();
        failed.setMsg("用户名或密码错误");
        return failed;
    }

    /**
     * 注册账号
     * @return
     */
    @PostMapping(path = "/saveUser", params = {"username", "password", "nickname", "code"})
    @ResponseBody
    public ResponseMessage saveUser(Teacher teacher, @RequestParam String code,
                                    @SessionAttribute(value = "CHECKCODE_SERVER", required = false) String reallyCode,
                                    HttpSession session) {
        // 检查验证码
        if (code != null && !code.equalsIgnoreCase(reallyCode)) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setCode(ResponseMessage.codeError);
            failed.setMsg("验证码错误");
            return failed;
        }
        // 插入数据库
        try {
            teacherService.saveTeacher(teacher);
        } catch (ExceptionMessage exceptionMessage) {
            System.out.println(exceptionMessage.getMsg());
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg(exceptionMessage.getMsg());
            return failed;
        }
        // 删除验证码
        session.removeAttribute("CHECKCODE_SERVER");
        return ResponseMessage.success();
    }

    /**
     * 验证账号是否已注册
     * @param username
     * @return
     */
    @RequestMapping("/findByUsername")
    @ResponseBody
    public ResponseMessage findByUsername(@RequestParam String username) {
//        账号未注册
        if (teacherService.findByUsername(username) == null) {
            return ResponseMessage.success();
        } else {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg("账号已被注册");
            return failed;
        }
    }
    @ResponseBody
    @GetMapping("/checkCode")
    public void getCheckCode(HttpSession session, HttpServletResponse response) throws IOException {
        CheckCode.get(session, response);
    }

    /**
     * 初始化主页
     * @param user
     * @return
     */
    @RequestMapping("/index")
    public String initIndex(@SessionAttribute("TEACHER") Teacher user) {
        return "teacher/index";
    }

    /**
     * 查找拥有的课程
     * @param teacher
     * @return
     */
    @ResponseBody
    @GetMapping("/selectCourse")
    public ResponseMessage selectCourse(@SessionAttribute("TEACHER") Teacher teacher) {
        ResponseMessage success = ResponseMessage.success();
        for (Course course:teacher.getCourses()) {
            success.putAttribute(course.getNumber(), course);
        }
        return success;
    }

    /**
     * 移除课程
     * @return
     * @id 课程号
     */
    @PostMapping("/removeCourse")
    @ResponseBody
    public ResponseMessage removeCourse(@RequestParam Integer id,
                                        @SessionAttribute("TEACHER") Teacher teacher) {
        Integer tid = teacher.getId();
        List<Course> courses = teacherService.removeCourse(id, tid);
        teacher.setCourses(courses);
        return ResponseMessage.success();
    }

    /**
     * 移除学员
     * @param cid 课程id
     * @param sid 学生id
     * @return
     */
    @ResponseBody
    @PostMapping("/removeMember")
    public ResponseMessage removeMember(@SessionAttribute("CURRENT_COURSE") Integer cid,
                                        @RequestParam Integer sid, HttpSession session) {
        List<Student> students = teacherService.removeMember(cid, sid);
        session.setAttribute("MEMBER", students);
        return ResponseMessage.success();
    }
    @GetMapping("/exam")
    public String exam(@SessionAttribute("CURRENT_COURSE") Integer id, ModelMap model) {
        model.addAttribute("BAR_INDEX","exam");
        return "teacher/exam";
    }
}
