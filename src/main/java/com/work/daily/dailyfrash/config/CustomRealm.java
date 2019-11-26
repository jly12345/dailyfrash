package com.work.daily.dailyfrash.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.daily.dailyfrash.entity.DfUser;
import com.work.daily.dailyfrash.service.DfUserService;
import com.work.daily.dailyfrash.utils.JWTToken;
import com.work.daily.dailyfrash.utils.JwtUtil;
import com.work.daily.dailyfrash.vo.ContextUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    public CustomRealm(DfUserService userService){
        this.accountService = userService;
        this.setCredentialsMatcher(new JWTCredentialsMatcher());
    }
    private static Logger log = LoggerFactory.getLogger(CustomRealm.class);

    private DfUserService accountService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("-------权限认证方法--------");

        return null;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("-------身份认证方法--------");
        JWTToken jwtToken = (JWTToken) authenticationToken;
        String token = jwtToken.getToken();
//      token.setPassword(PasswordUtils.encode(new String(token.getPassword())).toCharArray());
        String username = JwtUtil.getUsername(token);

        if (username == null) {
            throw new AuthenticationException("token无效");
        }

        QueryWrapper<DfUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);


        List<DfUser> accounts = accountService.list(queryWrapper);

        if (!accounts.isEmpty() && accounts.size()==1) {
            if (JwtUtil.isTokenExpired(token)) {
                throw new AuthenticationException("token过期，请重新登录");
            }
            ContextUser user = new ContextUser();
            user.setAvatar(accounts.get(0).getAvatar());
            user.setUserid(accounts.get(0).getId().toString());
            user.setUserName(accounts.get(0).getUserName());
            return new SimpleAuthenticationInfo(user, accounts.get(0).getPassword(), getName());
        }

        return null;
    }
}
