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
public class DfIndexTypeGoods implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean isDelete;

    private Integer displayType;

    private Integer index;

    private Integer skuId;

    private Integer typeId;


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

    public Integer getDisplayType() {
        return displayType;
    }

    public void setDisplayType(Integer displayType) {
        this.displayType = displayType;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "DfIndexTypeGoods{" +
        "id=" + id +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        ", displayType=" + displayType +
        ", index=" + index +
        ", skuId=" + skuId +
        ", typeId=" + typeId +
        "}";
    }
}
