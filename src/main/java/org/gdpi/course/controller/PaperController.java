package org.gdpi.course.controller;

import org.gdpi.course.pojo.ExamPaper;
import org.gdpi.course.pojo.ExamPaperModel;
import org.gdpi.course.pojo.Student;
import org.gdpi.course.service.ExamService;
import org.gdpi.course.utils.ExceptionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class PaperController {

    @Autowired
    private ExamService examService;
    @GetMapping("/student/paperModel")
    @ResponseBody
    public List<ExamPaperModel> pageList(@SessionAttribute("CURRENT_COURSE") Integer cid) {
        return examService.findByCidForStu(cid);
    }

    /**
     * 跳转试卷页面
     * @param id 模板试卷试卷id
     * @param student 学生对象
     * @param modelMap
     * @return
     * @throws ExceptionMessage
     */
    @GetMapping("/student/exam")
    public String enterExam(@RequestParam Integer id,
                            @SessionAttribute("STUDENT") Student student,
                            ModelMap modelMap) throws ExceptionMessage {
        ExamPaper paper = examService.findPaper(id, student.getId());
        modelMap.addAttribute("paper",paper);
        return "student/exam";
    }

    @GetMapping("/teacher/paperDetails")
    public String exterExam(@RequestParam Integer id,
                            @RequestParam Integer sid,
                            ModelMap modelMap) throws ExceptionMessage {

        ExamPaper paper = examService.findPaperTea(id, sid);
        modelMap.addAttribute("paper",paper);
        return "teacher/paper_details";
    }
}
