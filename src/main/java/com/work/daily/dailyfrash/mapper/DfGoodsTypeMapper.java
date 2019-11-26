package com.work.daily.dailyfrash.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.work.daily.dailyfrash.entity.DfGoodsType;
import com.work.daily.dailyfrash.vo.GoodsTypeVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lingyun.jiang
 * @since 2019-11-15
 */
public interface DfGoodsTypeMapper extends BaseMapper<DfGoodsType> {

     List<GoodsTypeVo> queryGoodsIndex(Map<String,String> map);

}
