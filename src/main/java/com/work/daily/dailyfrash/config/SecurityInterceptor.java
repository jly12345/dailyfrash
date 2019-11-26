package com.work.daily.dailyfrash.config;

import com.work.daily.dailyfrash.utils.ShiroUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String url = request.getRequestURI();

        String[] patterns = new String[]{"/css/**","/libs/**","/js/**","/images/**","/html/**","/error"};
        boolean isMatch=false;
        PathMatcher pathMatcherToUse = new AntPathMatcher();
        for(String pattern:patterns){
             isMatch = pathMatcherToUse.match(pattern, url);
             if(isMatch){
                break;
             }
        }

        if(!isMatch){
            log.info("access time: {}, uri: {},method:{}, user: {}" , LocalDateTime.now(), url,request.getMethod(), ShiroUtil.getCurrentUser());
        }
        return true;
    }
}