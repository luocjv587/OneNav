package com.example.navigation.service;

import com.example.navigation.model.domain.FolderDO;
import com.example.navigation.model.query.FolderQuery;
import com.example.navigation.model.vo.FolderVO;
import com.example.navigation.model.vo.PageInfoVO;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.service
 * <p>
 * DateTime: 2021-11-22 11:47 上午
 *
 * @author luocj
 */
public interface FolderService {

    PageInfoVO<FolderVO> getPageList(FolderQuery query);

    FolderVO getDetail(Long id);

    FolderDO create(String name, Long parentId);

    void delete(Long id);
}
