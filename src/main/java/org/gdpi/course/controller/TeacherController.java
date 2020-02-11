package org.gdpi.course.controller;

import org.gdpi.course.pojo.Course;
import org.gdpi.course.pojo.ExamPaperModel;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.pojo.Teacher;
import org.gdpi.course.service.TeacherService;
import org.gdpi.course.utils.CheckCode;
import org.gdpi.course.utils.DeleteFiles;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
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
        if (code != null && code.equalsIgnoreCase(reallyCode)) {
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
            session.removeAttribute("STUDENT");
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
                                        @SessionAttribute("TEACHER") Teacher teacher,
                                        HttpSession session) {
        Integer tid = teacher.getId();
        List<Course> courses = teacherService.removeCourse(id, tid);
        teacher.setCourses(courses);
        String realPath = session.getServletContext().getRealPath("/");
        File file = new File(realPath + "/" + "comment/");
        File file2 = new File(realPath + "/" + "issues/");
        // 删除课程相关文件
        DeleteFiles.deleteFiles(file, file2);
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

    /**
     * 进入试题管理页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/exam")
    public String exam(@SessionAttribute("CURRENT_COURSE") Integer id, ModelMap model) {
        model.addAttribute("BAR_INDEX","exam");
        return "teacher/exam";
    }

    /**
     * 进入试题页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/paper")
    public String paper(@SessionAttribute("CURRENT_COURSE") Integer id, ModelMap model) {
        // 设置活动页面
        model.addAttribute("BAR_INDEX","paper");
        List<ExamPaperModel> papers = teacherService.findPaperModelByCId(id);
        model.addAttribute("model_papers", papers);
        return "teacher/paper";
    }

    /**
     * 切换试卷的是是否隐藏
     * @param id  模板试卷id
     * @param hide 0 隐藏 1 显示
     * @return
     */
    @PostMapping("/hide")
    @ResponseBody
    public ResponseMessage toogelHide(@RequestParam Integer id, @RequestParam Integer hide) {
        try {
            teacherService.updateHide(id, hide);
        } catch (ExceptionMessage exceptionMessage) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg(exceptionMessage.getMsg());
            return failed;
        }
        return ResponseMessage.success();
    }

    /**
     * 更改试卷是否可以提交
     * @param id
     * @param enable
     * @return
     */
    @PostMapping("/enable")
    @ResponseBody
    public ResponseMessage toogleEnable(@RequestParam Integer id, @RequestParam Integer enable) {
        try {
            teacherService.updateEnable(id, enable);
        } catch (ExceptionMessage exceptionMessage) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg(exceptionMessage.getMsg());
            return failed;
        }
        return ResponseMessage.success();
    }

    /**
     * 删除模板试卷
     * @param id 试卷id
     * @param cid 课程号
     * @return
     */
    @ResponseBody
    @PostMapping("/deletePaper")
    public ResponseMessage deletePaper(@RequestParam Integer id, @SessionAttribute("CURRENT_COURSE") Integer cid) {
        try {
            teacherService.deletePaper(id, cid);
        } catch (ExceptionMessage exceptionMessage) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg(exceptionMessage.getMsg());
            return failed;
        }
        return ResponseMessage.success();
    }

    /**
     * 进入资源页
     * @param id 课程id
     * @return
     */
    @GetMapping("/resources")
    public String enterResources(@SessionAttribute("CURRENT_COURSE") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("BAR_INDEX", "resources");
       return "teacher/resources";
    }

    @GetMapping("/discuss")
    public String enterDiscuss(@SessionAttribute("CURRENT_COURSE")Integer id,
                               ModelMap modelMap) {
        modelMap.addAttribute("BAR_INDEX", "discuss");
        return "teacher/discuss";
    }

}
