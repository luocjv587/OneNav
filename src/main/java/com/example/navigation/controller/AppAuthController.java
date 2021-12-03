package com.example.navigation.controller;

import com.example.navigation.model.query.AppAuthQuery;
import com.example.navigation.model.vo.AppAuthVO;
import com.example.navigation.model.vo.PageInfoVO;
import com.example.navigation.service.AppAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.controller
 * <p>
 * DateTime: 2021-12-03 5:59 下午
 *
 * @author luocj
 */
@Controller
@RequiredArgsConstructor
public class AppAuthController {

    private final AppAuthService appAuthService;

    @PostMapping("/appAuth/create")//页面的url地址
    public String create(Model model)//对应函数
    {
        appAuthService.create();
        return getAppAuthDefault(model);
    }

    @GetMapping("/appAuth/index")//页面的url地址
    public String index(Model model)//对应函数
    {
        return getAppAuthDefault(model);
    }

    private String getAppAuthDefault(Model model) {
        PageInfoVO<AppAuthVO> list = appAuthService.getPageList(new AppAuthQuery());
        model.addAttribute("auths", list);
        return "appAuth";
    }
}
