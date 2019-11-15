package com.work.daily.dailyfrash.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class DfUser implements Serializable {

    private static final long serialVersionUID = 358629282525271235L;

    private String userid;
    private String userName;
    private String firstName;
    private String lastName;
    private String avatar;
    private Boolean isActive;
    private LocalDateTime dateJoined;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean isDelete;
    private String password;
    private LocalDateTime lastLogin;
    private String email;
}
