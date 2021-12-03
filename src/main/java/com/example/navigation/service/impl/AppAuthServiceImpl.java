package com.example.navigation.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.navigation.model.domain.AppAuthDO;
import com.example.navigation.mybatisService.MybatisAppAuthService;
import com.example.navigation.service.AppAuthService;
import com.example.navigation.util.GeneratorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.service.impl
 * <p>
 * DateTime: 2021-12-03 4:52 下午
 *
 * @author luocj
 */
@Service
@RequiredArgsConstructor
public class AppAuthServiceImpl implements AppAuthService {
    private final MybatisAppAuthService mybatisAppAuthService;

    @Override
    public void create() {
        mybatisAppAuthService.save(AppAuthDO.builder()
                .appKey(GeneratorUtil.getRandomString(20))
                .appSecret(GeneratorUtil.getRandomString(40))
                .userId(StpUtil.getLoginIdAsLong())
                .createdBy(StpUtil.getLoginIdAsLong())
                .updatedBy(StpUtil.getLoginIdAsLong())
                .build());
    }

    @Override
    public AppAuthDO exists(String appKey, String appSecret) {
        LambdaQueryWrapper<AppAuthDO> eq = new LambdaQueryWrapper<AppAuthDO>().eq(AppAuthDO::getAppKey, appKey).eq(AppAuthDO::getAppSecret, appSecret);
        return mybatisAppAuthService.getOne(eq);
    }
}
