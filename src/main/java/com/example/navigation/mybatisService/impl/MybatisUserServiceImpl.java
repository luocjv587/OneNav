package com.example.navigation.mybatisService.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.navigation.mapper.UserMapper;
import com.example.navigation.model.domain.UserDO;
import com.example.navigation.mybatisService.MybatisUserService;
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
public class MybatisUserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements MybatisUserService {
}
