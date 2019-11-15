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
public class DjangoMigrations implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String app;

    private String name;

    private LocalDateTime applied;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getApplied() {
        return applied;
    }

    public void setApplied(LocalDateTime applied) {
        this.applied = applied;
    }

    @Override
    public String toString() {
        return "DjangoMigrations{" +
        "id=" + id +
        ", app=" + app +
        ", name=" + name +
        ", applied=" + applied +
        "}";
    }
}
