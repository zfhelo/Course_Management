package org.gdpi.course.controller;

import org.gdpi.course.pojo.EssayQuestion;
import org.gdpi.course.service.EssayQueService;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequestMapping("/essay")
@Controller
public class EssayQueController {

    @Autowired
    private EssayQueService essayQueService;
    /**
     * 添加解答题到题库
     * @param essayQuestion
     * @param id
     * @return
     */
    @PostMapping(path = "/add", params = {"content","grade"})
    @ResponseBody
    public ResponseMessage add(EssayQuestion essayQuestion,
                               @SessionAttribute("CURRENT_COURSE") Integer id) {

        essayQuestion.setCid(id);
        try {
            essayQueService.saveQuestion(essayQuestion);
        } catch (ExceptionMessage exceptionMessage) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg(exceptionMessage.getMsg());
            return failed;
        }
        return ResponseMessage.success();
    }
}
