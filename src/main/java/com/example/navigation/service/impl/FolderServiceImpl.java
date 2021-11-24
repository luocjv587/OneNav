package com.example.navigation.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.navigation.mapper.BookmarkMapper;
import com.example.navigation.mapper.FolderMapper;
import com.example.navigation.model.domain.FolderDO;
import com.example.navigation.model.query.FolderQuery;
import com.example.navigation.model.vo.FolderVO;
import com.example.navigation.model.vo.PageInfoVO;
import com.example.navigation.service.FolderService;
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
 * DateTime: 2021-11-22 11:48 上午
 *
 * @author luocj
 */
@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderMapper folderMapper;
    private final BookmarkMapper bookmarkMapper;

    @Override
    public PageInfoVO<FolderVO> getPageList(FolderQuery query) {
        QueryWrapper<FolderDO> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotEmpty(query.getParentId())) {
            queryWrapper.eq("parent_id", query.getParentId());
        } else {
            queryWrapper.eq("parent_id", 0);
        }
        queryWrapper.eq("created_by", StpUtil.getLoginIdAsLong());
        IPage<FolderDO> page = folderMapper.selectPage(query.buildPage(), queryWrapper);
        List<FolderVO> folderVOList = TypeConverterUtil.convert(page.getRecords(), FolderVO.class);
        return PageInfoVO.<FolderVO>builder()
                .items(folderVOList)
                .total(page.getTotal())
                .build();
    }

    @Override
    public FolderVO getDetail(Long id) {
        return TypeConverterUtil.convert(folderMapper.selectById(id), FolderVO.class);
    }

    @Override
    public FolderDO create(String name, Long parentId) {
        FolderDO build = FolderDO.builder()
                .name(name)
                .parentId(parentId)
                .code(GeneratorUtil.getRandomString(8))
                .createdBy(StpUtil.getLoginIdAsLong())
                .updatedBy(StpUtil.getLoginIdAsLong())
                .build();
        folderMapper.insert(build);
        return build;
    }

    @Override
    public void delete(Long id) {
        folderMapper.deleteById(id);
    }
}
