package com.work.daily.dailyfrash.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.work.daily.dailyfrash.entity.DfUser;
import com.work.daily.dailyfrash.mapper.DfUserMapper;
import com.work.daily.dailyfrash.service.DfUserService;
import com.work.daily.dailyfrash.utils.JwtUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lingyun.jiang
 * @since 2019-11-15
 */
@Service
public class DfUserServiceImpl extends ServiceImpl<DfUserMapper, DfUser> implements DfUserService {

    @Override
    public String generateJwtToken(String username) {
        return JwtUtil.createToken(username);
    }

}
