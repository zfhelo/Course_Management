package org.gdpi.course.controller;

import org.gdpi.course.pojo.GapFilling;
import org.gdpi.course.service.GapFillingService;
import org.gdpi.course.utils.ExceptionMessage;
import org.gdpi.course.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequestMapping("/gap")
@Controller
public class GapFillingController {

    @Autowired
    private GapFillingService gapFillingService;

    /**
     * 添加填空题到题库
     * @param gapFilling
     * @param id
     * @return
     */
    @PostMapping(path = "/add", params = {"content","answer","grade"})
    @ResponseBody
    public ResponseMessage add(GapFilling gapFilling,
                               @SessionAttribute("CURRENT_COURSE") Integer id) {
        gapFilling.setCid(id);
        try {
            gapFillingService.saveQuestion(gapFilling);
        } catch (ExceptionMessage exceptionMessage) {
            ResponseMessage failed = ResponseMessage.failed();
            failed.setMsg(exceptionMessage.getMsg());
            return failed;
        }
        return ResponseMessage.success();
    }
}
