package com.example.fsmmdatabasemanager.utils;

public class AjaxResult {
    private String msg;

    public AjaxResult(){
        this.msg = "";
    }

    public AjaxResult(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
