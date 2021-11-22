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
public class FolderVO {
    private Long id;

    /**
     * 文件夹名称
     */
    private String name;

    /**
     * 文件夹编号
     */
    private String code;

    /**
     * 上层文件夹ID
     */
    private Long parentId;

}
