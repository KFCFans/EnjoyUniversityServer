package com.eu.pojo;

import java.util.List;

/**
 * Created by lip on 17/4/19.
 */
public class CommunityContactsListResult {

    // 200 成功，400 失败， 500 异常
    private Integer status;

    // ok／错误信息
    private String msg;

    // 传递的数据
    private List<CommunityContacts> data;

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

    public List<CommunityContacts> getData() {
        return data;
    }

    public void setData(List<CommunityContacts> data) {
        this.data = data;
    }

    public CommunityContactsListResult(Integer status, String msg, List<CommunityContacts> data) {

        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
