package com.work.daily.dailyfrash.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lingyun.jiang
 * @since 2019-11-15
 */
public class DfAddress implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean isDelete;

    private String receiver;

    private String addr;

    private String zipCode;

    private String phone;

    private Boolean isDefault;

    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DfAddress{" +
        "id=" + id +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        ", receiver=" + receiver +
        ", addr=" + addr +
        ", zipCode=" + zipCode +
        ", phone=" + phone +
        ", isDefault=" + isDefault +
        ", userId=" + userId +
        "}";
    }
}
