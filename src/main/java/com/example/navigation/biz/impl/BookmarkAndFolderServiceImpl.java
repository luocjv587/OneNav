package com.example.navigation.biz.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.example.navigation.biz.AuthService;
import com.example.navigation.biz.BookmarkAndFolderService;
import com.example.navigation.model.query.BookmarkQuery;
import com.example.navigation.model.query.FolderQuery;
import com.example.navigation.model.vo.BookmarkVO;
import com.example.navigation.model.vo.FolderVO;
import com.example.navigation.model.vo.PageInfoVO;
import com.example.navigation.service.BookmarkService;
import com.example.navigation.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
public class BookmarkAndFolderServiceImpl implements BookmarkAndFolderService {
    private final AuthService authService;
    private final FolderService folderService;
    private final BookmarkService bookmarkService;

    @Override
    public String getDefault(Model model) {
        PageInfoVO<FolderVO> folderServicePageList = folderService.getPageList(new FolderQuery());
        PageInfoVO<BookmarkVO> bookmarkServicePageList = bookmarkService.getPageList(new BookmarkQuery());
        model.addAttribute("current", "0");
        model.addAttribute("user", authService.getDetail(StpUtil.getLoginIdAsLong()));
        model.addAttribute("folders", folderServicePageList);
        model.addAttribute("bookmarks", bookmarkServicePageList);
        return "index";
    }
}
