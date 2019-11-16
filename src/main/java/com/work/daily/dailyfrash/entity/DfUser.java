package com.work.daily.dailyfrash.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@Data
@EqualsAndHashCode(callSuper = false)
public class DfUser implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String password;

    private LocalDateTime lastLogin;

    private String userName;

    private String firstName;

    private String lastName;

    private String avatar;

    private String email;

    private Boolean isActive;

    private LocalDateTime dateJoined;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean isDelete;

}
