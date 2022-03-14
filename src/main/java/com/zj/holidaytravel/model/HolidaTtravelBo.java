package com.zj.holidaytravel.model;

import java.util.Objects;

public class HolidaTtravelBo {
    private String id;//主键ID
    private String price;//价格
    private String title;//封面地址
    private String phone;//用户头像地址
    private String commodityDesc;//用户头像地址
    private String address;//描述
    private String createPeople;//创建人
    private String createDate;//创建时间
    private int isDelete;//是否删除 1删除 0未删除
    private String dotime;

    public HolidaTtravelBo() {
    }

    public HolidaTtravelBo(String id, String price, String title, String phone, String commodityDesc, String address, String createPeople, String createDate, int isDelete, String dotime) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.phone = phone;
        this.commodityDesc = commodityDesc;
        this.address = address;
        this.createPeople = createPeople;
        this.createDate = createDate;
        this.isDelete = isDelete;
        this.dotime = dotime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCommodityDesc() {
        return commodityDesc;
    }

    public void setCommodityDesc(String commodityDesc) {
        this.commodityDesc = commodityDesc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatePeople() {
        return createPeople;
    }

    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getDotime() {
        return dotime;
    }

    public void setDotime(String dotime) {
        this.dotime = dotime;
    }

    @Override
    public String toString() {
        return "HolidaTtravelBo{" +
                "id='" + id + '\'' +
                ", price='" + price + '\'' +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                ", commodityDesc='" + commodityDesc + '\'' +
                ", address='" + address + '\'' +
                ", createPeople='" + createPeople + '\'' +
                ", createDate='" + createDate + '\'' +
                ", isDelete=" + isDelete +
                ", dotime='" + dotime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HolidaTtravelBo that = (HolidaTtravelBo) o;
        return isDelete == that.isDelete &&
                Objects.equals(id, that.id) &&
                Objects.equals(price, that.price) &&
                Objects.equals(title, that.title) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(commodityDesc, that.commodityDesc) &&
                Objects.equals(address, that.address) &&
                Objects.equals(createPeople, that.createPeople) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(dotime, that.dotime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, title, phone, commodityDesc, address, createPeople, createDate, isDelete, dotime);
    }
}
