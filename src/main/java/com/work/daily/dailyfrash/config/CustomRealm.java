package com.work.daily.dailyfrash.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.daily.dailyfrash.entity.DfUser;
import com.work.daily.dailyfrash.service.DfUserService;
import com.work.daily.dailyfrash.utils.PasswordUtils;
import com.work.daily.dailyfrash.utils.SpringUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {
    private static Logger log = LoggerFactory.getLogger(CustomRealm.class);

    private DfUserService accountService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("-------权限认证方法--------");

        return null;
    }

    /**
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("-------身份认证方法--------");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        try {
            token.setPassword(PasswordUtils.encode(new String(token.getPassword())).toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //查询
        QueryWrapper<DfUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);

        if (accountService == null) {
            accountService = SpringUtil.getBean(DfUserService.class);
        }
        List<DfUser> accounts = accountService.list(queryWrapper);
        if (!accounts.isEmpty() && accounts.size()==1) {
            return new SimpleAuthenticationInfo(accounts.get(0), accounts.get(0).getPassword(), getName());
        }
        return null;
    }
}
