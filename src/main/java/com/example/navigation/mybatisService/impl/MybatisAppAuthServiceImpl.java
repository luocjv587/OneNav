package com.example.navigation.mybatisService.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.navigation.mapper.AppAuthMapper;
import com.example.navigation.model.domain.AppAuthDO;
import com.example.navigation.mybatisService.MybatisAppAuthService;
import org.springframework.stereotype.Service;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.mybatisService
 * <p>
 * DateTime: 2021-11-22 12:13 下午
 *
 * @author luocj
 */
@Service
public class MybatisAppAuthServiceImpl extends ServiceImpl<AppAuthMapper, AppAuthDO> implements MybatisAppAuthService {
}
