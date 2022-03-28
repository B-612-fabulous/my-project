package com.zj.order.model;


public class OrderDetailBo {
    private String id;//主键ID
    private String orderId;//主键ID
    private String title;//标题
    private String price;//价格
    private String fmImg;//封面地址
    private String preferentialRules;//秒杀规则
    private String commodityDesc;//描述
    private String createPeople;//创建人
    private boolean isSeckill;//是否秒杀
    private String createDate;//创建时间
    private int cartNumber;
    private String vegetablesId;
    private int isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPreferentialRules() {
        return preferentialRules;
    }

    public void setPreferentialRules(String preferentialRules) {
        this.preferentialRules = preferentialRules;
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

    public boolean isSeckill() {
        return isSeckill;
    }

    public void setSeckill(boolean seckill) {
        isSeckill = seckill;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public String getVegetablesId() {
        return vegetablesId;
    }

    public void setVegetablesId(String vegetablesId) {
        this.vegetablesId = vegetablesId;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
