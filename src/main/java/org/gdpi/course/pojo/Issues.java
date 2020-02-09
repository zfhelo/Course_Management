package org.gdpi.course.pojo;

import java.util.Date;

public class Issues {
    private Integer id;
    private Integer cid;
    private String nickname;
    private String title;
    private String content;
    private String path;
    private Date time;
    private String localeTime;

    public String getLocaleTime() {
        return localeTime;
    }

    private User user;

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Issues{" +
                "id=" + id +
                ", cid=" + cid +
                ", nickname='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", path='" + path + '\'' +
                ", time=" + time +
                ", user=" + user +
                '}';
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        localeTime = time.toLocaleString();
        this.time = time;
    }
}
