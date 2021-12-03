package com.example.navigation.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
@TableName("app_auth")
public class AppAuthDO implements Serializable {
    @TableField(fill = FieldFill.INSERT)
    public Date createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    public Date updatedAt;
    public Long createdBy;
    public Long updatedBy;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String appKey;
    private String appSecret;


}
