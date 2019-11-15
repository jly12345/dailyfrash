package com.work.daily.dailyfrash.vo;

/**
 * @Auther: lingyun.jiang
 * @Date: 2019/11/15 16:26
 * @Description:
 */
public class ContextUser {

    private String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private String username;
    private String avatar;
}
