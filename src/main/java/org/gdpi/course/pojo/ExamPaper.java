package org.gdpi.course.pojo;

import java.util.Date;
import java.util.List;

public class ExamPaper {
    private Integer id;
    private Integer sid;
    private Integer mid;
    private Float grade;
    private Integer status;
    private Date time;

    List<SingleQuestion> singleQuestions;
    List<GapFilling> gapFillings;
    List<EssayQuestion> essayQuestions;
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ExamPaper{" +
                "id=" + id +
                ", sid=" + sid +
                ", mid=" + mid +
                ", grade=" + grade +
                ", status=" + status +
                ", time=" + time +
                ", singleQuestions=" + singleQuestions +
                ", gapFillings=" + gapFillings +
                ", essayQuestions=" + essayQuestions +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<SingleQuestion> getSingleQuestions() {
        return singleQuestions;
    }

    public void setSingleQuestions(List<SingleQuestion> singleQuestions) {
        this.singleQuestions = singleQuestions;
    }

    public List<GapFilling> getGapFillings() {
        return gapFillings;
    }

    public void setGapFillings(List<GapFilling> gapFillings) {
        this.gapFillings = gapFillings;
    }

    public List<EssayQuestion> getEssayQuestions() {
        return essayQuestions;
    }

    public void setEssayQuestions(List<EssayQuestion> essayQuestions) {
        this.essayQuestions = essayQuestions;
    }
}
