package com.work.daily.dailyfrash.service.impl;

import com.work.daily.dailyfrash.entity.DfGoodsType;
import com.work.daily.dailyfrash.mapper.DfGoodsTypeMapper;
import com.work.daily.dailyfrash.service.DfGoodsTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.work.daily.dailyfrash.vo.GoodsTypeVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lingyun.jiang
 * @since 2019-11-15
 */
@Service
public class DfGoodsTypeServiceImpl extends ServiceImpl<DfGoodsTypeMapper, DfGoodsType> implements DfGoodsTypeService {

    @Override
    public List<GoodsTypeVo> queryGoodsIndex(Map<String,String> map){
        return baseMapper.queryGoodsIndex(map);
    }
}
