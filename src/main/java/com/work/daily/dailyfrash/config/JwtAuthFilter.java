package com.work.daily.dailyfrash.config;

import com.work.daily.dailyfrash.service.DfUserService;
import com.work.daily.dailyfrash.utils.JWTToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: lingyun.jiang
 * @Date: 2019/11/22 15:57
 * @Description:
 */
public class JwtAuthFilter extends FormAuthenticationFilter {

    private final Logger log = LoggerFactory.getLogger(JwtAuthFilter.class);

    private DfUserService accoutService;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (null != getSubject(request, response)
                && getSubject(request, response).isAuthenticated()) {
            return true;//已经认证过直接放行
        }
        return false;//转到拒绝访问处理逻辑
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if(isJwtSubmission(request)){
            AuthenticationToken token = createToken(request, response);
            try {
                Subject subject = getSubject(request, response);
                subject.login(token);
                return true;
            } catch (AuthenticationException e) {
                log.error(e.getMessage(),e);
                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED,e.getMessage());
            }
        }
        return false;
    }



    public JwtAuthFilter(DfUserService userService){
        this.accoutService = userService;
        this.setLoginUrl("/login");
        this.setSuccessUrl("/");
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        AuthenticationToken token = createToken(request, response);
        if (token == null) {
            String msg = "createToken method implementation returned null. A valid non-null AuthenticationToken " +
                    "must be created in order to execute a login attempt.";
            throw new IllegalStateException(msg);
        }
        try {
            Subject subject = getSubject(request, response);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(DEFAULT_JWT_PARAM);
        return new JWTToken(token);

    }

    public static final String DEFAULT_JWT_PARAM = "x-auth-token";

    protected boolean isJwtSubmission(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(DEFAULT_JWT_PARAM);
        return (request instanceof HttpServletRequest)
                && StringUtils.isNotBlank(token);
    }

}
