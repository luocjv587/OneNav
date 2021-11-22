package com.example.navigation.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.navigation.mapper.BookmarkMapper;
import com.example.navigation.model.domain.BookmarkDO;
import com.example.navigation.model.query.BookmarkQuery;
import com.example.navigation.model.vo.BookmarkVO;
import com.example.navigation.model.vo.PageInfoVO;
import com.example.navigation.service.BookmarkService;
import com.example.navigation.util.GeneratorUtil;
import com.example.navigation.util.TypeConverterUtil;
import com.example.navigation.util.UrlUtil;
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
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkMapper bookmarkMapper;

    @Override
    public PageInfoVO<BookmarkVO> getPageList(BookmarkQuery query) {
        QueryWrapper<BookmarkDO> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotEmpty(query.getParentId())) {
            queryWrapper.eq("folder_id", query.getParentId());
        }
        IPage<BookmarkDO> page = bookmarkMapper.selectPage(query.buildPage(), queryWrapper);
        List<BookmarkVO> bookmarkVOList = TypeConverterUtil.convert(page.getRecords(), BookmarkVO.class);
        for (BookmarkVO bookmarkVO : bookmarkVOList) {
            String domainName = UrlUtil.getDomainName(bookmarkVO.getUrl());
            bookmarkVO.setIcon(domainName + "/favicon.ico");
        }
        return PageInfoVO.<BookmarkVO>builder()
                .items(bookmarkVOList)
                .total(page.getTotal())
                .build();
    }

    @Override
    public void create(String name, Long parentId, String url) {
        BookmarkDO build = BookmarkDO.builder()
                .name(name)
                .folderId(parentId)
                .url(url)
                .code(GeneratorUtil.getRandomString(8))
                .createdBy(StpUtil.getLoginIdAsLong())
                .updatedBy(StpUtil.getLoginIdAsLong())
                .build();
        bookmarkMapper.insert(build);
    }

    @Override
    public void delete(Long id) {
        bookmarkMapper.deleteById(id);
    }
}
