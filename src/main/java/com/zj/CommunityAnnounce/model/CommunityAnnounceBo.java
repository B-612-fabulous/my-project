package com.zj.CommunityAnnounce.model;


import java.util.Objects;

public class CommunityAnnounceBo {
    private String id;//主键ID
    private String title;//标题
    private String announcement;//内容
    private String createDate;//创建时间

    public CommunityAnnounceBo() {

    }

    public CommunityAnnounceBo(String id, String title, String announcement, String createDate) {
        this.id = id;
        this.title = title;
        this.announcement = announcement;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommunityAnnounceBo that = (CommunityAnnounceBo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(announcement, that.announcement) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, announcement, createDate);
    }

    @Override
    public String toString() {
        return "CommunityAnnounceBo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", announcement='" + announcement + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
