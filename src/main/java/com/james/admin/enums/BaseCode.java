package com.james.admin.enums;

public enum BaseCode {

    SUCCESS(100, "调用成功",true),
    FAIL(-101, "调用失败",false),

    LOGIN_ERROR(-1001,"用户名或密码错误",false),

    UPLOAD_IMG_FAIL(-2001,"图片上传失败",false),
    GET_IMG_FAIL(-2002,"获取图片列表失败",false),

    UPLOAD_VIDEO_FAIL(-3001,"视频上传失败",false),
    GET_VIDEO_FAIL(-3002,"获取视频列表失败",false),
    ;

    private int code;
    private String msg;
    private boolean success;

    BaseCode(int code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
