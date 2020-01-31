package org.gdpi.course.pojo;

import java.util.Date;

/**
 * 单选题实体类
 */
public class SingleQuestion {
    private Integer id;
    // 课程id
    private Integer cid;
    private String content;
    private String choise1;
    private String choise2;
    private String choise3;
    private String choise4;
    // 分值
    private String answer;
    private Integer grade;
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.content = content;
    }

    public String getChoise1() {
        return choise1;
    }

    public void setChoise1(String choise1) {
        this.choise1 = choise1;
    }

    public String getChoise2() {
        return choise2;
    }

    public void setChoise2(String choise2) {
        this.choise2 = choise2;
    }

    public String getChoise3() {
        return choise3;
    }

    public void setChoise3(String choise3) {
        this.choise3 = choise3;
    }

    public String getChoise4() {
        return choise4;
    }

    public void setChoise4(String choise4) {
        this.choise4 = choise4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SingleQuestion{" +
                "id=" + id +
                ", cid=" + cid +
                ", content='" + content + '\'' +
                ", choise1='" + choise1 + '\'' +
                ", choise2='" + choise2 + '\'' +
                ", choise3='" + choise3 + '\'' +
                ", choise4='" + choise4 + '\'' +
                ", answer='" + answer + '\'' +
                ", grade=" + grade +
                ", time=" + time +
                '}';
    }
}
