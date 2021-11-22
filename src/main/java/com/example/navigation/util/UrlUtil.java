package com.example.navigation.util;

import java.net.URL;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.util
 * <p>
 * DateTime: 2021-11-22 6:32 下午
 *
 * @author luocj
 */
public class UrlUtil {
    public static String getDomainName(String url) {
        String host = "";
        try {
            URL Url = new URL(url);
            host = Url.getProtocol() +"://"+ Url.getHost();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return host;
    }
}
