package com.work.daily.dailyfrash.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lingyun.jiang
 * @since 2019-11-15
 */
public class DjangoContentType implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String appLabel;

    private String model;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppLabel() {
        return appLabel;
    }

    public void setAppLabel(String appLabel) {
        this.appLabel = appLabel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "DjangoContentType{" +
        "id=" + id +
        ", appLabel=" + appLabel +
        ", model=" + model +
        "}";
    }
}
