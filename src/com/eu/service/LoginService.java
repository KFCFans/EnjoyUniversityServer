package com.eu.service;

import com.eu.pojo.VerificationCode;
import com.taobao.api.ApiException;

/**
 * Created by lip on 17/3/21.
 */
public interface LoginService {


    public VerificationCode verifyPhoneNumber(String phone) throws ApiException;

}
