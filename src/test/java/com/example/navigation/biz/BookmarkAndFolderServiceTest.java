package com.example.navigation.biz;

import com.example.navigation.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.biz
 * <p>
 * DateTime: 2021-11-24 4:18 下午
 *
 * @author luocj
 */
@SpringBootTest
class BookmarkAndFolderServiceTest {
    @Autowired
    private BookmarkAndFolderService bookmarkAndFolderService;
    @Test
    void googleImport() throws IOException {
//        String s = FileUtils.readFile("/Users/luocj/Downloads/bookmarks_2021_11_23.html");
//        bookmarkAndFolderService.googleImport(s);
    }
}