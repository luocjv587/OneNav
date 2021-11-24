package com.example.navigation.biz.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.navigation.biz.AuthService;
import com.example.navigation.model.domain.UserDO;
import com.example.navigation.model.exception.BusinessException;
import com.example.navigation.model.vo.UserVO;
import com.example.navigation.mybatisService.MybatisUserService;
import com.example.navigation.util.GeneratorUtil;
import com.example.navigation.util.TypeConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.biz
 * <p>
 * DateTime: 2021-11-22 12:34 下午
 *
 * @author luocj
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MybatisUserService mybatisUserService;

    @Override
    public UserVO login(String username, String password) {
        UserDO userDO = mybatisUserService.getOne(new QueryWrapper<UserDO>().eq("username", username).eq("password", password));
        if (Objects.isNull(userDO)) {
            throw new BusinessException("账号或密码错误");
        }

        StpUtil.login(userDO.getId());
        UserVO userVO = TypeConverterUtil.convert(userDO, UserVO.class);
        userVO.setJwtToken(StpUtil.getTokenValue());
        return userVO;
    }

    @Override
    public UserVO register(String username, String password, String name) {
        UserDO userDO = mybatisUserService.getOne(new QueryWrapper<UserDO>().eq("username", username));
        if (!Objects.isNull(userDO)) {
            throw new BusinessException("账号已存在");
        }
        UserDO createUserDO = UserDO.builder()
                .code(GeneratorUtil.getRandomString(6))
                .username(username)
                .password(password)
                .name(name)
                .createdBy(0L)
                .updatedBy(0L)
                .build();
        mybatisUserService.save(createUserDO);
        StpUtil.login(createUserDO.getId());
        UserVO userVO = TypeConverterUtil.convert(createUserDO, UserVO.class);
        userVO.setJwtToken(StpUtil.getTokenValue());
        return userVO;
    }

    @Override
    public UserVO getDetail(Long id) {
        return TypeConverterUtil.convert(mybatisUserService.getById(id), UserVO.class);
    }
}
