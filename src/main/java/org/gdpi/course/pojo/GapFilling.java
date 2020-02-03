package org.gdpi.course.pojo;

import java.util.Date;

/**
 * 填空题实体类
 */
public class GapFilling extends Question{
    // 课程id
    private Integer cid;
    private String content;
    private String answer;


    private Date time;

    @Override
    public String toString() {
        return "GapFilling{" +
                "id=" + getId() +
                ", cid=" + cid +
                ", content='" + content + '\'' +
                ", answer='" + answer + '\'' +
                ", grade=" + getGrade() +
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
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
