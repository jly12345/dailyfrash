package com.work.daily.dailyfrash.vo;

import com.work.daily.dailyfrash.entity.DfGoodsSku;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: lingyun.jiang
 * @Date: 2019/11/21 17:36
 * @Description:
 */
@Data
public class GoodsTypeVo implements Serializable {

    private static final long serialVersionUID = -6204609884131289029L;
    private Integer id;

    private String name;

    private String logo;

    private String image;

    private List<DfGoodsSku> goods;
}
