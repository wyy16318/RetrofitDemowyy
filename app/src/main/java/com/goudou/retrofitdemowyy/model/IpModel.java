package com.goudou.retrofitdemowyy.model;


/**
 * Created by Administrator on 2016/9/8 0008.
 */
public class IpModel {
    private int code;
    private IpData data;

    @Override
    public String toString() {
        return "IpModel{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }

    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return this.code;
    }
    public void setData(IpData data) {
        this.data = data;
    }
    public IpData getData() {
        return this.data;
    }
}
