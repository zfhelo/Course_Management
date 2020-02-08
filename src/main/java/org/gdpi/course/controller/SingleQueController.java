package org.gdpi.course.controller;

import org.gdpi.course.pojo.SingleQuestion;
import org.gdpi.course.service.SingleQueService;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequestMapping("/single")
@Controller
public class SingleQueController {

    @Autowired
    SingleQueService singleQueService;

    /**
     * 添加单选题到题库
     * @param singleQuestion
     * @param id
     * @return
     */
    @PostMapping(path = "/add", params = {"choise1","choise2","choise3","choise4","answer","content","grade"})
    @ResponseBody
    public ResponseMessage add(SingleQuestion singleQuestion,
                               @SessionAttribute("CURRENT_COURSE") Integer id) {
        singleQuestion.setCid(id);
        try {
            singleQueService.saveQuestion(singleQuestion);
        } catch (ExceptionMessage exceptionMessage) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg(exceptionMessage.getMsg());
            return failed;
        }
        return ResponseMessage.success();
    }
}
