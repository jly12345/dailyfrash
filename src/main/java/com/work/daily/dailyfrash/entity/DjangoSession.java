package com.work.daily.dailyfrash.entity;

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
public class DjangoSession implements Serializable {

    private static final long serialVersionUID=1L;

    private String sessionKey;

    private String sessionData;

    private LocalDateTime expireDate;


    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionData() {
        return sessionData;
    }

    public void setSessionData(String sessionData) {
        this.sessionData = sessionData;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "DjangoSession{" +
        "sessionKey=" + sessionKey +
        ", sessionData=" + sessionData +
        ", expireDate=" + expireDate +
        "}";
    }
}
