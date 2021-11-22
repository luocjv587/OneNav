package com.example.navigation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.navigation.mapper.UserMapper;
import com.example.navigation.model.domain.UserDO;
import com.example.navigation.model.query.UserQuery;
import com.example.navigation.model.vo.PageInfoVO;
import com.example.navigation.model.vo.UserVO;
import com.example.navigation.service.UserService;
import com.example.navigation.util.TypeConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.service.impl
 * <p>
 * DateTime: 2021-11-22 11:48 上午
 *
 * @author luocj
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public PageInfoVO<UserVO> getPageList(UserQuery query) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        IPage<UserDO> page = userMapper.selectPage(query.buildPage(), queryWrapper);
        List<UserVO> userVOList = TypeConverterUtil.convert(page.getRecords(), UserVO.class);
        return PageInfoVO.<UserVO>builder()
                .items(userVOList)
                .total(page.getTotal())
                .build();
    }
}
