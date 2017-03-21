package com.eu.pojo;

/**
 * Created by lip on 17/3/21.
 */
public class VerificationCode {

    private String code;

    private String states;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public VerificationCode(String code, String states) {
        this.code = code;
        this.states = states;
    }
}
