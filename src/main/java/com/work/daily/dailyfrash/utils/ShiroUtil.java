package com.work.daily.dailyfrash.utils;

import com.work.daily.dailyfrash.entity.DfUser;
import com.work.daily.dailyfrash.service.DfUserService;
import com.work.daily.dailyfrash.vo.ContextUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroUtil {
    private static Logger logger = LoggerFactory.getLogger(ShiroUtil.class);
    /**
     * 从shiro中拿用户ID
     * */
    public static String getUserId(){
        Subject subject = SecurityUtils.getSubject();
        String userId = null;
        if(subject.isAuthenticated()) {
            ContextUser userAccount = (ContextUser) subject.getPrincipal();
            userId = userAccount.getUserid();
        }
        logger.info("current user：{}",userId);
        return userId;
    }

    /**
     * 获取当前用户信息
     * */
    public static ContextUser getCurrentUser(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            if(subject.getSession().getAttribute("user") ==null){
                DfUser cuser = (DfUser) subject.getPrincipal();
                DfUser user = SpringUtil.getBean(DfUserService.class).getById(cuser.getId());
                ContextUser contextUser = new ContextUser();
                contextUser.setUserName(user.getUserName());
                contextUser.setUserid(user.getId().toString());
                contextUser.setAvatar(user.getAvatar());
                subject.getSession().setAttribute("user",contextUser);
                return contextUser;
            }else {
                return (ContextUser)subject.getSession().getAttribute("user");
            }
        }
        return null;

    }
}
