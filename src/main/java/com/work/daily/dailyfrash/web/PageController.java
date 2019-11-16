package com.work.daily.dailyfrash.web;

import com.work.daily.dailyfrash.utils.ShiroUtil;
import com.work.daily.dailyfrash.vo.ContextUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: Think
 * @Date: 2019/11/16 17:26
 * @Description:
 */
@Controller
public class PageController {

    @GetMapping("/")
    public String index(HttpSession session){
        ContextUser currentUser = ShiroUtil.getCurrentUser();
        session.setAttribute("user",currentUser);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/reg")
    public String register(){
        return "register";
    }

}
