package com.work.daily.dailyfrash.web.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.daily.dailyfrash.entity.DfUser;
import com.work.daily.dailyfrash.service.DfUserService;
import com.work.daily.dailyfrash.utils.JWTToken;
import com.work.daily.dailyfrash.utils.PasswordUtils;
import com.work.daily.dailyfrash.vo.Msg;
import com.work.daily.dailyfrash.vo.RegUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: lingyun.jiang
 * @Date: 2019/11/18 15:22
 * @Description:
 */
@RestController
public class AccountController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DfUserService userService;

    @PostMapping("/login")
    public Msg login(String username, String password) throws Exception {
        QueryWrapper<DfUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);
        List<DfUser> users = userService.list(queryWrapper);

        if(CollectionUtils.isEmpty(users)){
            return Msg.fail().add("user_error","用户不存在");
        }

        DfUser user = users.get(0);

        if(!PasswordUtils.encode(password).equals(user.getPassword())){
            return Msg.fail().add("pwd_error","密码错误");
        }

        Subject subject = SecurityUtils.getSubject();
        String newToken = userService.generateJwtToken(username);
        try {
            JWTToken token = new JWTToken(newToken);
            subject.login(token);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }

        return Msg.success().add("token",newToken);
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
