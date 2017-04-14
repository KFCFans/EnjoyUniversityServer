package com.eu.pojo;

import java.util.List;

/**
 * Created by lip on 17/4/14.
 */
public class ParticipatorListResult {

    // 200 成功，400 失败， 500 异常
    private Integer status;

    // ok／错误信息
    private String msg;

    // 传递的数据
    private List<Participateactivity> data;

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

    public List<Participateactivity> getData() {
        return data;
    }

    public void setData(List<Participateactivity> data) {
        this.data = data;
    }

    public ParticipatorListResult(Integer status, String msg, List<Participateactivity> data) {

        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
