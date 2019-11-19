package com.work.daily.dailyfrash.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: lingyun.jiang
 * @Date: 2019/11/15 16:26
 * @Description:
 */
@Data
public class RegUser implements Serializable {

    private static final long serialVersionUID = -2511676839453350794L;
    private String userName;
    private String pwd;
    private String email;
}
