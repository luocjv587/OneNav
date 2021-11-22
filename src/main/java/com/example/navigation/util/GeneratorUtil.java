package com.example.navigation.util;

import cn.hutool.core.util.RandomUtil;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.util
 * <p>
 * DateTime: 2021-11-22 5:42 下午
 *
 * @author luocj
 */
public class GeneratorUtil {
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return RandomUtil.randomString(str,length);
    }
}
