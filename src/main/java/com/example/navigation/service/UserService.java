package com.example.navigation.service;

import com.example.navigation.model.query.FolderQuery;
import com.example.navigation.model.query.UserQuery;
import com.example.navigation.model.vo.FolderVO;
import com.example.navigation.model.vo.PageInfoVO;
import com.example.navigation.model.vo.UserVO;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.service
 * <p>
 * DateTime: 2021-11-22 11:47 上午
 *
 * @author luocj
 */
public interface UserService {

    PageInfoVO<UserVO> getPageList(UserQuery query);
}
