package com.example.navigation.controller;

import com.example.navigation.biz.BookmarkAndFolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.controller
 * <p>
 * DateTime: 2021-11-24 6:25 下午
 *
 * @author luocj
 */
@Controller
@RequiredArgsConstructor
public class ImportController {
    private final BookmarkAndFolderService bookmarkAndFolderService;

    @PostMapping("/import/chrome")
    public String importChrome(Model model, @RequestParam MultipartFile file) {
        try {
            String s = new String(file.getInputStream().readAllBytes());
            bookmarkAndFolderService.googleImport(s);
        } catch (Exception e) {

        }
        return bookmarkAndFolderService.getDefault(model, null);
    }
}
