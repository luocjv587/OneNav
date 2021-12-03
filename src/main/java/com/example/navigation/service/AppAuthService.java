package com.example.navigation.service;

import com.example.navigation.model.domain.AppAuthDO;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.service.impl
 * <p>
 * DateTime: 2021-12-03 4:52 下午
 *
 * @author luocj
 */
public interface AppAuthService {

    void create();

    AppAuthDO exists(String appKey, String appSecret);
}
