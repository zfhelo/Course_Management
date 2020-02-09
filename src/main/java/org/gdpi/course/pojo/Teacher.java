package org.gdpi.course.pojo;

import java.util.List;

/**
 * 教师实体类
 */
public class Teacher extends User {

    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                super.toString() +
                "courses=" + courses +
                '}';
    }
}
