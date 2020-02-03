package org.gdpi.course.controller;

import org.gdpi.course.pojo.ExamPaperModel;
import org.gdpi.course.pojo.Teacher;
import org.gdpi.course.service.ExamService;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
