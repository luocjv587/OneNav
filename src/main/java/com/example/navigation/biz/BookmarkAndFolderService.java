package com.example.navigation.biz;

import org.springframework.ui.Model;

import java.io.IOException;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.biz
 * <p>
 * DateTime: 2021-11-22 12:34 下午
 *
 * @author luocj
 */
public interface BookmarkAndFolderService {
    String getDefault(Model model,Long parentId);

    void googleImport(String s) throws IOException;

    void addBookmark(String url,String title);
}
