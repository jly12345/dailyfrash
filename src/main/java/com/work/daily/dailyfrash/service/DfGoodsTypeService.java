package com.work.daily.dailyfrash.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.work.daily.dailyfrash.entity.DfGoodsType;
import com.work.daily.dailyfrash.vo.GoodsTypeVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lingyun.jiang
 * @since 2019-11-15
 */
public interface DfGoodsTypeService extends IService<DfGoodsType> {
    List<GoodsTypeVo> queryGoodsIndex(Map<String,String> map);

}
