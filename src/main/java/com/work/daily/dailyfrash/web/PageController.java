package com.work.daily.dailyfrash.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.daily.dailyfrash.entity.DfIndexBanner;
import com.work.daily.dailyfrash.entity.DfIndexPromotion;
import com.work.daily.dailyfrash.service.DfGoodsTypeService;
import com.work.daily.dailyfrash.service.DfIndexBannerService;
import com.work.daily.dailyfrash.service.DfIndexPromotionService;
import com.work.daily.dailyfrash.utils.ShiroUtil;
import com.work.daily.dailyfrash.vo.ContextUser;
import com.work.daily.dailyfrash.vo.GoodsTypeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Think
 * @Date: 2019/11/16 17:26
 * @Description:
 */
@Controller
public class PageController {

    private Logger log = LoggerFactory.getLogger(PageController.class);
    
    @Autowired
    private DfGoodsTypeService goodsTypeService;

    @Autowired
    private DfIndexBannerService indexBannerService;

    @Autowired
    private DfIndexPromotionService promotionService;


    @GetMapping("/")
    public ModelAndView index(HttpSession session){
        ContextUser currentUser = ShiroUtil.getCurrentUser();
        session.setAttribute("user",currentUser);

        List<GoodsTypeVo> goodsTypeVos = goodsTypeService.queryGoodsIndex(new HashMap<>());

        QueryWrapper<DfIndexBanner> queryBanner= new QueryWrapper<>();
        queryBanner.eq("is_delete", 0).orderByAsc("`index`").last("limit 4");
        List<DfIndexBanner> banners = indexBannerService.list(queryBanner);

        QueryWrapper<DfIndexPromotion> queryProm= new QueryWrapper<>();
        queryProm.eq("is_delete", 0).orderByAsc("`index`").last("limit 2");
        List<DfIndexPromotion> promotions = promotionService.list(queryProm);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("types",goodsTypeVos);
        modelAndView.addObject("user",currentUser);
        modelAndView.addObject("banners",banners);
        modelAndView.addObject("promotions",promotions);
        return modelAndView;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/reg")
    public String register(){
        return "register";
    }

    @GetMapping("/userInfo")
    public String userInfo(HttpSession session){
        ContextUser currentUser = ShiroUtil.getCurrentUser();
        session.setAttribute("user",currentUser);
        return "user_center_info";
    }

    @GetMapping("/cart")
    public String cart(HttpSession session){
        ContextUser currentUser = ShiroUtil.getCurrentUser();
        session.setAttribute("user",currentUser);
        return "cart";
    }

    @GetMapping("/userCenterOrder")
    public String userCenterOrder(HttpSession session){
        ContextUser currentUser = ShiroUtil.getCurrentUser();
        session.setAttribute("user",currentUser);
        return "user_center_order";
    }




    @GetMapping("/pro/{id}")
    public String goodsDetail(HttpSession session, @PathVariable("id") String id){
        ContextUser currentUser = ShiroUtil.getCurrentUser();
        session.setAttribute("user",currentUser);
        log.info(id);
        return "detail";
    }

    @GetMapping("/pro/cate/{id}")
    public ModelAndView goodsList(HttpSession session,@PathVariable("id") String typeId){
        ContextUser currentUser = ShiroUtil.getCurrentUser();
        session.setAttribute("user",currentUser);
        Map<String, String> map = new HashMap<>();
        map.put("type_id",typeId);
        List<GoodsTypeVo> goods = goodsTypeService.queryGoodsIndex(map);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }



}
