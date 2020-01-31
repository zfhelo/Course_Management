package org.gdpi.course.utils;

public class ExceptionMessage extends Exception {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ExceptionMessage(String msg) {
        super(msg);
        this.msg = msg;
    }
}
