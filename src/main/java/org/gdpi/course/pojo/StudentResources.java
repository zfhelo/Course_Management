package org.gdpi.course.pojo;

import java.util.Date;

public class StudentResources {
    private Integer id;
    private Integer cid;
    private Integer sid;
    private String title;
    private String path;
    private Date time;
    private Integer size;
    // 字符串时间
    private String localeTime;

    public String getNickname() {
        return user == null?"":user.getNickname();
    }

    private String nickname;

    private Student user;

    @Override
    public String toString() {
        return "TeacherResources{" +
                "id=" + id +
                ", cid=" + cid +
                ", sid=" + sid +
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

    public String getLocaleTime() {
        return localeTime;
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

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer tid) {
        this.sid = tid;
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
        this.localeTime = time.toLocaleString();
    }

    public Student getUser() {
        return user;
    }

    public void setUser(Student user) {
        this.user = user;
    }
}
