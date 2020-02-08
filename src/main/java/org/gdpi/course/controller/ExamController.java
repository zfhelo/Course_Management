package org.gdpi.course.controller;

import org.gdpi.course.pojo.ExamPaperModel;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.pojo.Teacher;
import org.gdpi.course.service.ExamService;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 试题相关
 */
@Controller
public class ExamController {

    @Autowired
    private ExamService examService;
    /**
     * 生成试卷
     * @param session
     * @param examPaperModel
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/generatePaper")
    public ResponseMessage generatePaper(HttpSession session,
                                         ExamPaperModel examPaperModel) {
        Teacher teacher = (Teacher) session.getAttribute("TEACHER");
        // 拿到当前的课程id
        Integer id = (Integer) session.getAttribute("CURRENT_COURSE");

        if (teacher == null || id == null) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg("生成失败");
            return failed;
        }
        // 注入教师号和课程号
        examPaperModel.setCid(id);
        examPaperModel.setTid(teacher.getId());
        try {
            examService.generatePaper(examPaperModel);
        } catch (ExceptionMessage e) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg(e.getMsg());
            return failed;
        }

        return ResponseMessage.success();
    }

    /**
     * 更新用户答案
     * @param que 类型
     * @param id 题目id
     * @param answer 所选答案
     * @param pid 试卷id
     * @param mid 模板试卷id
     * @return
     */
    @PostMapping("/{que}/update")
    @ResponseBody
    public ResponseMessage updateAnswer(@PathVariable("que") String que,
                                        @RequestParam Integer id,
                                        @RequestParam String answer,
                                        @RequestParam Integer pid,
                                        @RequestParam Integer mid) {

        try {
            if("single".equals(que)) {
                examService.updateSingle(answer, id, mid, pid);
            } else if ("gap".equals(que)) {
                examService.updateGap(answer, id, mid, pid);
            } else if ("essay".equals(que)) {
                examService.updateEssay(answer, id, mid, pid);
            } else {
                throw new ExceptionMessage("未知题目类型");
            }
        } catch (ExceptionMessage exceptionMessage) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg(exceptionMessage.getMsg());
            return failed;
        }

        ResponseMessage success = ResponseMessage.success();
        success.setMsg("保存成功");
        return success;
    }

    @ResponseBody
    @PostMapping("/commitPaper")
    public ResponseMessage commitPaper(@RequestParam Integer id,
                                       @SessionAttribute("STUDENT") Student student) {
        try {
            examService.commitPaper(id, student.getId());
        } catch (ExceptionMessage exceptionMessage) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg(exceptionMessage.getMsg());
            return failed;
        }
        ResponseMessage success = ResponseMessage.success();
        success.setMsg("提交成功");

        return success;
    }
}
