package com.work.daily.dailyfrash.service;

import com.work.daily.dailyfrash.entity.DfUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.work.daily.dailyfrash.vo.ContextUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lingyun.jiang
 * @since 2019-11-15
 */
public interface DfUserService extends IService<DfUser> {

    String generateJwtToken(String username);

}
