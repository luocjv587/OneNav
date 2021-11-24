package com.example.navigation.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
@TableName("bookmark")
public class BookmarkDO implements Serializable {
    @TableId(type = IdType.AUTO)
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

    /**
     * 文件夹名称
     */
    private Long folderId;

    @TableField(fill = FieldFill.INSERT)
    public Date createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    public Date updatedAt;

    public Long createdBy;

    public Long updatedBy;


}
