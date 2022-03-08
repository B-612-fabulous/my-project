package com.zj.idlezone.model;

import java.util.Objects;

public class IdleZoneBo {
    private static final long serialVersionUID = 1L;
    private String id;//主键ID
    private String price;//价格
    private String fmImg;//封面地址
    private String pic;//用户头像地址

    private String commodityDesc;//描述
    private String createPeople;//创建人
    private String createDate;//创建时间

    public IdleZoneBo(String id, String price, String fmImg, String pic, String commodityDesc, String createPeople, String createDate, int isDelete) {
        this.id = id;
        this.price = price;
        this.fmImg = fmImg;
        this.pic = pic;
        this.commodityDesc = commodityDesc;
        this.createPeople = createPeople;
        this.createDate = createDate;
        this.isDelete = isDelete;
    }

    public IdleZoneBo() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getFmImg() {
        return fmImg;
    }

    public void setFmImg(String fmImg) {
        this.fmImg = fmImg;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCommodityDesc() {
        return commodityDesc;
    }

    public void setCommodityDesc(String commodityDesc) {
        this.commodityDesc = commodityDesc;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdleZoneBo that = (IdleZoneBo) o;
        return isDelete == that.isDelete &&
                Objects.equals(id, that.id) &&
                Objects.equals(price, that.price) &&
                Objects.equals(fmImg, that.fmImg) &&
                Objects.equals(pic, that.pic) &&
                Objects.equals(commodityDesc, that.commodityDesc) &&
                Objects.equals(createPeople, that.createPeople) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, fmImg, pic, commodityDesc, createPeople, createDate, isDelete);
    }

    @Override
    public String toString() {
        return "IdleZoneBo{" +
                "id='" + id + '\'' +
                ", price='" + price + '\'' +
                ", fmImg='" + fmImg + '\'' +
                ", pic='" + pic + '\'' +
                ", commodityDesc='" + commodityDesc + '\'' +
                ", createPeople='" + createPeople + '\'' +
                ", createDate='" + createDate + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    private int isDelete;//是否删除 1删除 0未删除

}
