package com.example.navigation.biz;

import com.example.navigation.model.vo.UserVO;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.biz
 * <p>
 * DateTime: 2021-11-22 12:47 下午
 *
 * @author luocj
 */
public interface AuthService {
    UserVO login(String username, String password);

    UserVO getDetail(Long id);
}
