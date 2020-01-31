package org.gdpi.course.pojo;

import java.util.Date;

/**
 * 解答题实体类
 */
public class EssayQuestion {
    private Integer id;
    // 课程id
    private Integer cid;
    private String content;
    // 分值
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
        return "EssayQuestion{" +
                "id=" + id +
                ", cid=" + cid +
                ", content='" + content + '\'' +
                ", grade=" + grade +
                ", time=" + time +
                '}';
    }
}
