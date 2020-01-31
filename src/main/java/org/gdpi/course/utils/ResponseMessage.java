package org.gdpi.course.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于封装相应数据
 */
public class ResponseMessage  {
    // 响应状态码
    private Integer code;
    // 状态码描述
    private String msg;

    public static int codeError = 401;
    private static int success = 200;
    private static int failed = 400;

    private Map<String, Object> data = new HashMap<>();

    public ResponseMessage putAttribute(String key, Object value) {
        data.put(key, value);
        return this;
    }


    public static ResponseMessage success() {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(200);
        responseMessage.setMsg("成功");
        return responseMessage;
    }

    public static ResponseMessage failed() {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(400);
        responseMessage.setMsg("失败");
        return responseMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
