package org.gdpi.course.pojo;

/**
 * 题目的父类
 */
public class Question {
    private Integer id;
    // 分值
    private Integer grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
