package org.gdpi.course.pojo;

import java.util.Date;

public class Comment {
    private Integer id;
    private Integer iid;
    private String content;
    private String nickname;
    private String path;
    private Date time;
    private String localeTime;
    private User user;

    public String getLocaleTime() {
        return localeTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        localeTime = time.toLocaleString();
        this.time = time;
    }
}
