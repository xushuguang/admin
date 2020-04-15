package com.james.admin.domain;

import java.io.Serializable;
import java.util.Date;

public class Videos implements Serializable {
    private static final long serialVersionUID = -3963678152316690722L;

    private Long id;

    private String vdName;

    private String vdUrl;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;

    private Long operator;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVdName() {
        return vdName;
    }

    public void setVdName(String vdName) {
        this.vdName = vdName;
    }

    public String getVdUrl() {
        return vdUrl;
    }

    public void setVdUrl(String vdUrl) {
        this.vdUrl = vdUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
