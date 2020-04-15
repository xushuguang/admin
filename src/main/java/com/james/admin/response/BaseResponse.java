package com.james.admin.response;

import com.james.admin.enums.BaseCode;

import java.io.Serializable;

public class BaseResponse implements Serializable {


    private static final long serialVersionUID = 3538865837504110447L;
    private boolean success;
    private int code;
    private String msg;
    private String data;

    public BaseResponse(String data) {
        this.code = BaseCode.SUCCESS.getCode();
        this.data = data;
        this.msg = BaseCode.SUCCESS.getMsg();
        this.success = BaseCode.SUCCESS.getSuccess();
    }

    public BaseResponse(int code,String msg) {
        this.code = code;
        this.msg = msg;
        this.success = BaseCode.FAIL.getSuccess();
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
