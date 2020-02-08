package org.gdpi.course.controller;

import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.service.StudentService;
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

/**
 *
 */
@Controller
@RequestMapping("/student")
@SessionAttributes({"BAR_INDEX"})
public class StudentController {
    @Autowired
    StudentService studentService;

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
                                 @RequestParam String code, @SessionAttribute(value = "CHECKCODE_SERVER", required = false) String reallyCode,
                                 HttpSession session) {
        // 验证码错误
        if (code != null && !code.equalsIgnoreCase(reallyCode)) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setCode(ResponseMessage.codeError);
            failed.setMsg("验证码错误");
            return failed;
        }

        Student user = studentService.login(username, password);
        // 查询到用户
        if (user != null && user.getPassword().equals(password)) {
            // 添加到域对象
            session.setAttribute("STUDENT", user);
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
    public ResponseMessage saveUser(Student student, @RequestParam String code,
                                    @SessionAttribute("CHECKCODE_SERVER") String reallyCode,
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
            studentService.saveStudent(student);
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
        if (studentService.findByUsername(username) == null) {
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
    public String initIndex(@SessionAttribute("STUDENT") Student user) {
        return "student/index";
    }

    /**
     * 查找所拥有的课程
     * @param student
     * @return
     */
    @ResponseBody
    @GetMapping("/selectCourse")
    public ResponseMessage selectCourse(@SessionAttribute("STUDENT") Student student) {
        ResponseMessage success = ResponseMessage.success();
        for (Course course:student.getCourses()) {
            success.putAttribute(course.getNumber(), course);
        }
        return success;
    }

    /**
     * 移除选课
     * @return
     * @id 课程号
     */
    @PostMapping("/removeCourse")
    @ResponseBody
    public ResponseMessage removeCourse(@RequestParam Integer id,
                                        @SessionAttribute("STUDENT") Student student) {
        Integer sid = student.getId();
        List<Course> courses = studentService.removeCourse(id, sid);
        student.setCourses(courses);
        return ResponseMessage.success();
    }

    /**
     * 进入试卷列表
     * @param student
     * @param cid
     * @return
     */
    @GetMapping("/paper")
    public String enterPaper(@SessionAttribute("STUDENT") Student student,
                             @SessionAttribute("CURRENT_COURSE") Integer cid,
                             ModelMap modelMap) {
        modelMap.addAttribute("BAR_INDEX","paper");
        return "student/paper";
    }
}
