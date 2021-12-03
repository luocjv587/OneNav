package com.example.navigation.biz.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.example.navigation.biz.AuthService;
import com.example.navigation.biz.BookmarkAndFolderService;
import com.example.navigation.model.domain.FolderDO;
import com.example.navigation.model.query.BookmarkQuery;
import com.example.navigation.model.query.FolderQuery;
import com.example.navigation.model.vo.BookmarkVO;
import com.example.navigation.model.vo.FolderVO;
import com.example.navigation.model.vo.PageInfoVO;
import com.example.navigation.service.BookmarkService;
import com.example.navigation.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
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
@Service
@RequiredArgsConstructor
public class BookmarkAndFolderServiceImpl implements BookmarkAndFolderService {
    private final AuthService authService;
    private final FolderService folderService;
    private final BookmarkService bookmarkService;

    @Override
    public String getDefault(Model model, Long parentId) {
        if (parentId == null) {
            parentId = 0L;
        }
        PageInfoVO<FolderVO> folderServicePageList = folderService.getPageList(FolderQuery.builder().parentId(parentId).build());
        PageInfoVO<BookmarkVO> bookmarkServicePageList = bookmarkService.getPageList(BookmarkQuery.builder().parentId(parentId).build());
        model.addAttribute("current", parentId);
        model.addAttribute("currentFolderId", parentId);
        model.addAttribute("user", authService.getDetail(StpUtil.getLoginIdAsLong()));
        model.addAttribute("folders", folderServicePageList);
        model.addAttribute("bookmarks", bookmarkServicePageList);
        return "index";
    }

    /**
     * google书签导入
     */
    @Override
    public void googleImport(String s) throws IOException {
        Document doc = Jsoup.parse(s);
        Elements allTitle = doc.getElementsByTag("h3");
        for (int i = 0; i < allTitle.size(); i++) {
            Element title = allTitle.get(i);
            Elements urlElements = title.nextElementSibling().getElementsByTag("a");
            FolderDO folderDO = folderService.create(title.text(), 0L);
            for (Element urlElement : urlElements) {
                bookmarkService.create(urlElement.text(), folderDO.getId(), urlElement.attributes().get("href"));
            }
        }

    }

    @Override
    public void addBookmark(String url, String title) {
        bookmarkService.create(title, 0L, url);
    }
}
