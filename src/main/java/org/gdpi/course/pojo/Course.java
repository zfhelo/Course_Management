package org.gdpi.course.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * course表实体类
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Course implements Serializable {
    private Integer id;
    private Integer tid;
    private String name;
    private String number;
    private String image;
    private Date time;
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", tid=" + tid +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", image='" + image + '\'' +
                ", time=" + time +
                ", teacher=" + teacher +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Course)) {
            throw new ClassCastException();
        }
       if (this.getNumber().equals(((Course) obj).getNumber())){
           return true;
       } else {
           return false;
       }
    }
}
