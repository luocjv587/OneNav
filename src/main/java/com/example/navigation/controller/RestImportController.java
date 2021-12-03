package com.example.navigation.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.navigation.biz.BookmarkAndFolderService;
import com.example.navigation.model.domain.AppAuthDO;
import com.example.navigation.service.AppAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.controller
 * <p>
 * DateTime: 2021-12-03 2:07 下午
 *
 * @author luocj
 */
@RestController
@RequiredArgsConstructor
public class RestImportController {
    private final BookmarkAndFolderService bookmarkAndFolderService;
    private final AppAuthService appAuthService;

    @GetMapping("/api/addBookmark")
    public Integer chromeAddBookmark(String url, String title, String key, String secret) {
        if (ObjectUtil.isNull(title)) {
            title = "No Title " + LocalDateTime.now().toLocalDate();
        }
        AppAuthDO exists = appAuthService.exists(key, secret);
        if (ObjectUtil.isNull(exists)) {
            return 0;
        }
        StpUtil.login(exists.getUserId());
        bookmarkAndFolderService.addBookmark(url, title);
        return 1;
    }
}
