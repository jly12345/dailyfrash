package com.work.daily.dailyfrash.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: lingyun.jiang
 * @Date: 2019/11/15 16:26
 * @Description:
 */
@Data
public class ContextUser implements Serializable {
    private static final long serialVersionUID = -6527806519559722455L;
    private String userid;
    private String userName;
    private String avatar;
}
