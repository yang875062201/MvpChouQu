package com.example.mvpchouqu.bean;

/**
 * @author xts
 *         Created by asus on 2019/9/23.
 */

public class Bean {

    /**
     * code : 200
     * ret : success
     * data : icpz
     */

    private int code;
    private String ret;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "code=" + code +
                ", ret='" + ret + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
