package com.example.navigation.config;

import com.example.navigation.interceptor.LoginHandlerInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.config
 * <p>
 * DateTime: 2021-11-22 4:43 下午
 *
 * @author luocj
 */
@Configuration
public class WebConfigure extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    @SuppressWarnings("unused")
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截的请求，并排除几个不拦截的请求
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login", "/", "/register");
    }

}
