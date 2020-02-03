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
    private Date time;

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

    @Override
    public String toString() {
        return "ExamPaperModel{" +
                "id=" + id +
                ", tid=" + tid +
                ", cid=" + cid +
                ", title='" + title + '\'' +
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
