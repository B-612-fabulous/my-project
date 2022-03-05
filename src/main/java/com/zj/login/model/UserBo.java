package com.zj.login.model;

import java.util.Objects;

public class UserBo {
    private int id;
    private String userName;
    private String passWord;
    private String phone;
    private String pic;
    private String address;
    private String trueName;

    public UserBo() {
    }

    public UserBo(int id, String userName, String passWord, String phone, String pic, String address) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.pic = pic;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @Override
    public String toString() {
        return "UserBo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                ", pic='" + pic + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBo userBo = (UserBo) o;
        return id == userBo.id &&
                Objects.equals(userName, userBo.userName) &&
                Objects.equals(passWord, userBo.passWord) &&
                Objects.equals(phone, userBo.phone) &&
                Objects.equals(pic, userBo.pic) &&
                Objects.equals(address, userBo.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, passWord, phone, pic, address);
    }
}

