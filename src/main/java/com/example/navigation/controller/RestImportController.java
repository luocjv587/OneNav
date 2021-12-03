package com.example.navigation.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.navigation.biz.BookmarkAndFolderService;
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

    @GetMapping("/api/addBookmark")
    public void chromeAddBookmark(String url, String title) {
        if (ObjectUtil.isNull(title)) {
            title = "No Title " + LocalDateTime.now().toLocalDate();
        }
        StpUtil.login(1);
        bookmarkAndFolderService.addBookmark(url, title);
    }
}
