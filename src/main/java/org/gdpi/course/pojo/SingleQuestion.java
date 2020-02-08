package org.gdpi.course.pojo;

import java.util.Date;

/**
 * 单选题实体类
 */
public class SingleQuestion extends Question {
    // 课程id
    private Integer cid;
    private String content;
    private String choise1;
    private String choise2;
    private String choise3;
    private String choise4;
    // 分值
    private String answer;
    private Date time;

    private String userAnswer;

    public String getUserAnswer() {
        return userAnswer;
    }

    @Override
    public String toString() {
        return "SingleQuestion{" +
                "cid=" + cid +
                ", content='" + content + '\'' +
                ", choise1='" + choise1 + '\'' +
                ", choise2='" + choise2 + '\'' +
                ", choise3='" + choise3 + '\'' +
                ", choise4='" + choise4 + '\'' +
                ", answer='" + answer + '\'' +
                ", time=" + time +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content.trim();
    }

    public String getChoise1() {
        return choise1;
    }

    public void setChoise1(String choise1) {
        this.choise1 = choise1.trim();
    }

    public String getChoise2() {
        return choise2;
    }

    public void setChoise2(String choise2) {
        this.choise2 = choise2.trim();
    }

    public String getChoise3() {
        return choise3;
    }

    public void setChoise3(String choise3) {
        this.choise3 = choise3.trim();
    }

    public String getChoise4() {
        return choise4;
    }

    public void setChoise4(String choise4) {
        this.choise4 = choise4.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer.trim();
    }
}
