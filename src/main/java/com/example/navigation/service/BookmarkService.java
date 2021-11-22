package com.example.navigation.service;

import com.example.navigation.model.domain.BookmarkDO;
import com.example.navigation.model.query.BookmarkQuery;
import com.example.navigation.model.vo.BookmarkVO;
import com.example.navigation.model.vo.PageInfoVO;
import com.example.navigation.model.vo.PaginationVO;

import java.util.List;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.service
 * <p>
 * DateTime: 2021-11-22 11:47 上午
 *
 * @author luocj
 */
public interface BookmarkService {

    PageInfoVO<BookmarkVO> getPageList(BookmarkQuery query);

    void create(String name, Long parentId,String url);

    void delete(Long id);
}
