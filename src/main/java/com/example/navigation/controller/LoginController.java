package com.example.navigation.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.navigation.biz.AuthService;
import com.example.navigation.biz.BookmarkAndFolderService;
import com.example.navigation.model.query.BookmarkQuery;
import com.example.navigation.model.query.FolderQuery;
import com.example.navigation.model.query.LoginQuery;
import com.example.navigation.model.vo.BookmarkVO;
import com.example.navigation.model.vo.FolderVO;
import com.example.navigation.model.vo.PageInfoVO;
import com.example.navigation.model.vo.UserVO;
import com.example.navigation.service.BookmarkService;
import com.example.navigation.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.controller
 * <p>
 * DateTime: 2021-11-22 1:02 下午
 *
 * @author luocj
 */
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final AuthService authService;
    private final FolderService folderService;
    private final BookmarkService bookmarkService;
    private final BookmarkAndFolderService bookmarkAndFolderService;


    @GetMapping("/")
    public String login(Model model)//对应函数
    {
        if (StpUtil.isLogin()) {
            return "index";
        }
        return "login";
    }

    @PostMapping("/register")
    public String register(LoginQuery loginQuery, Model model)//对应函数
    {
        try {
            authService.register(loginQuery.getUsername(), loginQuery.getPassword(),loginQuery.getName());
            return bookmarkAndFolderService.getDefault(model,null);
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "login";
        }
    }

    @PostMapping("/login")
    public String login(LoginQuery loginQuery, Model model) {
        try {
            UserVO login = authService.login(loginQuery.getUsername(), loginQuery.getPassword());
            return bookmarkAndFolderService.getDefault(model,null);
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "login";
        }
    }

    @RequestMapping("/search/{parentId}")
    public String search(Model model, @PathVariable Long parentId) {
        FolderVO detail = folderService.getDetail(parentId);
        if (ObjectUtil.isEmpty(detail)) {
            detail = FolderVO.builder().name("Root").build();
        }
        FolderQuery folderQuery = new FolderQuery();
        BookmarkQuery bookmarkQuery = new BookmarkQuery();
        folderQuery.setParentId(parentId);
        bookmarkQuery.setParentId(parentId);
        PageInfoVO<FolderVO> folderServicePageList = folderService.getPageList(folderQuery);
        PageInfoVO<BookmarkVO> bookmarkServicePageList = bookmarkService.getPageList(bookmarkQuery);
        model.addAttribute("current", detail.getName());
        model.addAttribute("currentFolderId", detail.getId());
        model.addAttribute("user", authService.getDetail(StpUtil.getLoginIdAsLong()));
        model.addAttribute("folders", folderServicePageList);
        model.addAttribute("bookmarks", bookmarkServicePageList);
        return "index";
    }

    @PostMapping("/logout")
    public String logout(Model model) {
        StpUtil.logout();
        return "login";
    }
}
