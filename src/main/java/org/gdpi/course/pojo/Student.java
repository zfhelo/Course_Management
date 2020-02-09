package org.gdpi.course.pojo;

import java.util.List;

/**
 * 学生实体类
 */
public class Student extends User{

    // 学生选课 一对多关系
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "courses=" + courses +
                '}';
    }
}
