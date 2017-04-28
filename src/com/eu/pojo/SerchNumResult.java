package com.eu.pojo;

/**
 * Created by lip on 17/4/24.
 */
public class SerchNumResult {

    // 200 成功，400 失败， 500 异常
    private Integer status;

    // ok／错误信息
    private String msg;

    // 传递的数据
    private SearchNum data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SearchNum getData() {
        return data;
    }

    public void setData(SearchNum data) {
        this.data = data;
    }

    public SerchNumResult(Integer status, String msg, SearchNum data) {

        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
