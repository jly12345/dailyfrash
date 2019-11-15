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
public class DjangoAdminLog implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private LocalDateTime actionTime;

    private String objectId;

    private String objectRepr;

    private Integer actionFlag;

    private String changeMessage;

    private Integer contentTypeId;

    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectRepr() {
        return objectRepr;
    }

    public void setObjectRepr(String objectRepr) {
        this.objectRepr = objectRepr;
    }

    public Integer getActionFlag() {
        return actionFlag;
    }

    public void setActionFlag(Integer actionFlag) {
        this.actionFlag = actionFlag;
    }

    public String getChangeMessage() {
        return changeMessage;
    }

    public void setChangeMessage(String changeMessage) {
        this.changeMessage = changeMessage;
    }

    public Integer getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(Integer contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DjangoAdminLog{" +
        "id=" + id +
        ", actionTime=" + actionTime +
        ", objectId=" + objectId +
        ", objectRepr=" + objectRepr +
        ", actionFlag=" + actionFlag +
        ", changeMessage=" + changeMessage +
        ", contentTypeId=" + contentTypeId +
        ", userId=" + userId +
        "}";
    }
}
