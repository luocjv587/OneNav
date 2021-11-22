package com.example.navigation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.model
 * <p>
 * DateTime: 2021-11-22 11:45 上午
 *
 * @author luocj
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkVO {
    private Long id;

    /**
     * 书签名称
     */
    private String name;

    /**
     * 书签编号
     */
    private String code;

    /**
     * 书签地址
     */
    private String url;

    private String icon;

    /**
     * 文件夹名称
     */
    private Long folderId;
}
