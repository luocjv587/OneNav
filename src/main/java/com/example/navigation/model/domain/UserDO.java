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
@TableName("user")
public class UserDO implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户编号
     */
    private String code;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 是否启用
     */
    private Boolean isEnable;

    @TableField(fill = FieldFill.INSERT)
    public Date createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    public Date updatedAt;

    public Long createdBy;

    public Long updatedBy;

}
