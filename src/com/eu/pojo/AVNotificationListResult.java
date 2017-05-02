package com.eu.pojo;

import java.util.List;

/**
 * Created by lip on 17/5/2.
 */
public class AVNotificationListResult {
    // 200 成功，400 失败， 500 异常
    private Integer status;

    // ok／错误信息
    private String msg;

    // 传递的数据 登陆成功返回 token，验证返回true／false，短信验证返回验证码
    private List<Activitynotification> data;

    public AVNotificationListResult(Integer status, String msg, List<Activitynotification> data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

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

    public List<Activitynotification> getData() {
        return data;
    }

    public void setData(List<Activitynotification> data) {
        this.data = data;
    }
}
