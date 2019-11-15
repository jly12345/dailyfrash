package com.work.daily.dailyfrash.entity;

import java.math.BigDecimal;
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
public class DfOrderInfo implements Serializable {

    private static final long serialVersionUID=1L;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean isDelete;

    private String orderId;

    private Integer payMethod;

    private Integer totalCount;

    private BigDecimal totalPrice;

    private BigDecimal transitPrice;

    private Integer orderStatus;

    private String tranNo;

    private Integer userId;


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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTransitPrice() {
        return transitPrice;
    }

    public void setTransitPrice(BigDecimal transitPrice) {
        this.transitPrice = transitPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTranNo() {
        return tranNo;
    }

    public void setTranNo(String tranNo) {
        this.tranNo = tranNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DfOrderInfo{" +
        "createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        ", orderId=" + orderId +
        ", payMethod=" + payMethod +
        ", totalCount=" + totalCount +
        ", totalPrice=" + totalPrice +
        ", transitPrice=" + transitPrice +
        ", orderStatus=" + orderStatus +
        ", tranNo=" + tranNo +
        ", userId=" + userId +
        "}";
    }
}
