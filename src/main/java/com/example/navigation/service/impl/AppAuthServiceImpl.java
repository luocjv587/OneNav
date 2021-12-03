package com.example.navigation.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.navigation.mapper.AppAuthMapper;
import com.example.navigation.model.domain.AppAuthDO;
import com.example.navigation.model.query.AppAuthQuery;
import com.example.navigation.model.vo.AppAuthVO;
import com.example.navigation.model.vo.PageInfoVO;
import com.example.navigation.mybatisService.MybatisAppAuthService;
import com.example.navigation.service.AppAuthService;
import com.example.navigation.util.GeneratorUtil;
import com.example.navigation.util.TypeConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private final AppAuthMapper appAuthMapper;

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

    @Override
    public PageInfoVO<AppAuthVO> getPageList(AppAuthQuery query) {
        QueryWrapper<AppAuthDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("created_by", StpUtil.getLoginIdAsLong());
        IPage<AppAuthDO> page = appAuthMapper.selectPage(query.buildPage(), queryWrapper);
        List<AppAuthVO> list = TypeConverterUtil.convert(page.getRecords(), AppAuthVO.class);
        return PageInfoVO.<AppAuthVO>builder()
                .items(list)
                .total(page.getTotal())
                .build();
    }
}
