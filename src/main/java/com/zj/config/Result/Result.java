package com.zj.config.Result;


public class Result {
    private static final long serialVersionUID = 1L;
    //响应码
    private int code;//响应码
    private String msg;//提示信息
    private String state;//请求状态
    private Object data;//返回数据集合

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
