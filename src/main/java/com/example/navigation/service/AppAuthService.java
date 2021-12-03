package com.example.navigation.service;

import com.example.navigation.model.domain.AppAuthDO;
import com.example.navigation.model.query.AppAuthQuery;
import com.example.navigation.model.query.FolderQuery;
import com.example.navigation.model.vo.AppAuthVO;
import com.example.navigation.model.vo.FolderVO;
import com.example.navigation.model.vo.PageInfoVO;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.service.impl
 * <p>
 * DateTime: 2021-12-03 4:52 下午
 *
 * @author luocj
 */
public interface AppAuthService {

    void create();

    AppAuthDO exists(String appKey, String appSecret);

    PageInfoVO<AppAuthVO> getPageList(AppAuthQuery query);
}
