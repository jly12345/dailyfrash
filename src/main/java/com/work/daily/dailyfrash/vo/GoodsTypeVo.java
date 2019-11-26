package com.work.daily.dailyfrash.vo;

import com.work.daily.dailyfrash.entity.DfGoodsSku;
import lombok.Data;

import java.util.List;

/**
 * @Auther: lingyun.jiang
 * @Date: 2019/11/21 17:36
 * @Description:
 */
@Data
public class GoodsTypeVo {
    private Integer id;

    private String name;

    private String logo;

    private String image;

    private List<DfGoodsSku> goods;
}
