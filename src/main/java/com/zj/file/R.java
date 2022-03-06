package com.zj.file;

import java.io.Serializable;

public class R implements Serializable {

    private String code;
    private String msg;
    private Object data;

    public static R ok(){
        return init(Constant.DR_OK, Constant.DR_OK_MSG, null);
    }
    public static R warning(){
        return init(Constant.DR_WARNING, Constant.DR_WARNING_MSG, null);
    }

    public static R ok(Object data){
        return init(Constant.DR_OK, Constant.DR_OK_MSG, data);
    }

    public static R error(){
        return init(Constant.DR_ERROR, Constant.DR_ERROR_MSG, null);
    }

    private static R init(String code, String msg, Object data){
        R result =  new R();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
