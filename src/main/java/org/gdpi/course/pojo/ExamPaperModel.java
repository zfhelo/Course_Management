package org.gdpi.course.pojo;

import java.util.Date;

/**
 * 试卷模板
 */
public class ExamPaperModel {
    private Integer id;
    private Integer tid;
    private Integer cid;
    private String title;
    private Integer enable;
    private Integer hide;
    private Date time;
    // 提交人数
    private Integer commit;
    // 为提交人数
    private Integer member;

    public Integer getCommit() {
        return commit;
    }

    public void setCommit(Integer commit) {
        this.commit = commit;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    // 选择题 数量 总分
    private Integer singleNum;
    private Integer singleGrade;

    // 填空题
    private Integer gapNum;
    private Integer gapGrade;

    // 大题
    private Integer essayNum;
    private Integer essayGrade;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(Integer singleNum) {
        this.singleNum = singleNum;
    }

    public Integer getSingleGrade() {
        return singleGrade;
    }

    public void setSingleGrade(Integer singleGrade) {
        this.singleGrade = singleGrade;
    }

    public Integer getGapNum() {
        return gapNum;
    }

    public void setGapNum(Integer gapNum) {
        this.gapNum = gapNum;
    }

    public Integer getGapGrade() {
        return gapGrade;
    }

    public void setGapGrade(Integer gapGrade) {
        this.gapGrade = gapGrade;
    }

    public Integer getEssayNum() {
        return essayNum;
    }

    public void setEssayNum(Integer essayNum) {
        this.essayNum = essayNum;
    }

    public Integer getEssayGrade() {
        return essayGrade;
    }

    public void setEssayGrade(Integer essayGrade) {
        this.essayGrade = essayGrade;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
    }

    @Override
    public String toString() {
        return "ExamPaperModel{" +
                "id=" + id +
                ", tid=" + tid +
                ", cid=" + cid +
                ", title='" + title + '\'' +
                ", enable=" + enable +
                ", hide=" + hide +
                ", time=" + time +
                ", singleNum=" + singleNum +
                ", singleGrade=" + singleGrade +
                ", gapNum=" + gapNum +
                ", gapGrade=" + gapGrade +
                ", essayNum=" + essayNum +
                ", essayGrade=" + essayGrade +
                '}';
    }
}
