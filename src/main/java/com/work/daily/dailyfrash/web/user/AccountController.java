package com.work.daily.dailyfrash.web.user;

import com.work.daily.dailyfrash.entity.DfUser;
import com.work.daily.dailyfrash.service.DfUserService;
import com.work.daily.dailyfrash.utils.PasswordUtils;
import com.work.daily.dailyfrash.vo.RegUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @Auther: lingyun.jiang
 * @Date: 2019/11/18 15:22
 * @Description:
 */
@Controller
public class AccountController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DfUserService userService;

    @PostMapping("/login")
    public String login(HttpServletRequest request){
        request.getSession().removeAttribute("login_msg");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg="" ;
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "account";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "pwd";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                msg = "code";
            } else {
                msg = "other";
            }
            request.getSession().setAttribute("login_msg",msg);
        }
        // 此方法不处理登录成功,由shiro进行处理
        log.info("---------------"+msg);

        return "redirect:/login";
    }

    @PostMapping("/reg")
    public String register(RegUser regUser){

        log.info(regUser.toString());
        DfUser user = new DfUser();
        user.setUserName(regUser.getUserName());
        user.setEmail(regUser.getEmail());
        user.setCreateTime(LocalDateTime.now());
        try {
            user.setPassword(PasswordUtils.encode(regUser.getPwd()));
            userService.save(user);

            UsernamePasswordToken token = new UsernamePasswordToken();
            token.setUsername(user.getUserName());
            token.setPassword(user.getPassword().toCharArray());
            SecurityUtils.getSubject().login(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
