package org.gdpi.course.pojo;

import java.util.Date;

public class TeacherResources {
    private Integer id;
    private Integer cid;
    private Integer tid;
    private String title;
    private String path;
    private Date time;
    private Integer size;

    private Teacher user;

    @Override
    public String toString() {
        return "TeacherResources{" +
                "id=" + id +
                ", cid=" + cid +
                ", tid=" + tid +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", time=" + time +
                ", size=" + size +
                ", user=" + user +
                '}';
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

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

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Teacher getUser() {
        return user;
    }

    public void setUser(Teacher user) {
        this.user = user;
    }
}
