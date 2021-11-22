package com.example.navigation.config;

import cn.dev33.satoken.jwt.StpLogicJwtForStyle;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.config
 * <p>
 * DateTime: 2021-11-22 2:15 下午
 *
 * @author luocj
 */
@Configuration
public class SaTokenConfigure {
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForStyle();
    }
}
