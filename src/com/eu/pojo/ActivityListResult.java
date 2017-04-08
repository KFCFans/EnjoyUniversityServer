package com.eu.pojo;

import java.util.List;

/**
 * Created by lip on 17/4/8.
 */
public class ActivityListResult {

    // 200 成功，400 失败， 500 异常
    private Integer status;

    // ok／错误信息
    private String msg;

    // 传递的数据 登陆成功返回 token，验证返回true／false，短信验证返回验证码
    private List<Activity> data;

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public List<Activity> getData() {
        return data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(List<Activity> data) {
        this.data = data;
    }

    public ActivityListResult(Integer status, String msg, List<Activity> data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
