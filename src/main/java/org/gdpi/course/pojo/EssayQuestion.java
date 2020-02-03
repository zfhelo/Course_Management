package org.gdpi.course.pojo;

import java.util.Date;

/**
 * 解答题实体类
 */
public class EssayQuestion extends Question{

    // 课程id
    private Integer cid;
    private String content;

    private Date time;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "EssayQuestion{" +
                "id=" + getId() +
                ", cid=" + cid +
                ", content='" + content + '\'' +
                ", grade=" + getGrade() +
                ", time=" + time +
                '}';
    }
}
