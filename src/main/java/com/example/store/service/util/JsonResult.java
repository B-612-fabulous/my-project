package com.example.store.service.util;

import java.io.Serializable;

public class JsonResult<E> implements Serializable {
    private Integer state;

    private  String messageg;

    private E date;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }
    public JsonResult(Throwable e) {
        this.messageg =e.getMessage();
    }

    public JsonResult(Integer state, E date) {
        this.state = state;
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessageg() {
        return messageg;
    }

    public void setMessageg(String messageg) {
        this.messageg = messageg;
    }

    public E getDate() {
        return date;
    }

    public void setDate(E date) {
        this.date = date;
    }
}
