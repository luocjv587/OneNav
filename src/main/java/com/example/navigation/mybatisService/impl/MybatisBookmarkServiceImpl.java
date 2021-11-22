package com.example.navigation.mybatisService.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.navigation.mapper.BookmarkMapper;
import com.example.navigation.model.domain.BookmarkDO;
import com.example.navigation.mybatisService.MybatisBookmarkService;
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
public class MybatisBookmarkServiceImpl extends ServiceImpl<BookmarkMapper, BookmarkDO> implements MybatisBookmarkService {
}
