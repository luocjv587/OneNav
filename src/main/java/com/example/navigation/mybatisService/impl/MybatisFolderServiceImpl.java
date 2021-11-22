package com.example.navigation.mybatisService.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.navigation.mapper.BookmarkMapper;
import com.example.navigation.mapper.FolderMapper;
import com.example.navigation.model.domain.BookmarkDO;
import com.example.navigation.model.domain.FolderDO;
import com.example.navigation.mybatisService.MybatisBookmarkService;
import com.example.navigation.mybatisService.MybatisFolderService;
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
public class MybatisFolderServiceImpl extends ServiceImpl<FolderMapper, FolderDO> implements MybatisFolderService {
}
