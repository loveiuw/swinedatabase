package com.example.fsmmdatabasemanager.utils;

public class AjaxResult {
    private String msg;
    private enum ALL_STATE{success, error}
    private ALL_STATE state;

    public String getMsg() {return msg; }

    public void setState(String res){
        state = ALL_STATE.valueOf(res);
    }

    public String getState(){
        return state.toString();
    }
}
