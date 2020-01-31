package org.gdpi.course.pojo;

import java.util.Date;

/**
 * 填空题实体类
 */
public class GapFilling {
    private Integer id;
    // 课程id
    private Integer cid;
    private String content;
    private String answer;
    // 分值
    private Integer grade;
    private Date time;

    @Override
    public String toString() {
        return "GapFilling{" +
                "id=" + id +
                ", cid=" + cid +
                ", content='" + content + '\'' +
                ", answer='" + answer + '\'' +
                ", grade=" + grade +
                ", time=" + time +
                '}';
    }

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
}
