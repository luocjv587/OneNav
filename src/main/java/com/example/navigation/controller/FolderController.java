package com.example.navigation.controller;

import com.example.navigation.biz.AuthService;
import com.example.navigation.biz.BookmarkAndFolderService;
import com.example.navigation.service.BookmarkService;
import com.example.navigation.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.controller
 * <p>
 * DateTime: 2021-11-22 5:38 下午
 *
 * @author luocj
 */
@Controller
@RequiredArgsConstructor
public class FolderController {
    private final AuthService authService;
    private final FolderService folderService;
    private final BookmarkService bookmarkService;
    private final BookmarkAndFolderService bookmarkAndFolderService;

    @PostMapping("/folder/create")//页面的url地址
    public String create(Model model, String name, Long parentId)//对应函数
    {
        folderService.create(name, parentId);
        return bookmarkAndFolderService.getDefault(model,parentId);

    }

    @PostMapping("/folder/delete/{id}")//页面的url地址
    public String create(Model model, @PathVariable Long id)//对应函数
    {
        folderService.delete(id);
        return bookmarkAndFolderService.getDefault(model,null);
    }
}
