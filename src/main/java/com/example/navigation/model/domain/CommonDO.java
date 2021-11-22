package com.example.navigation.model.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.model.domain
 * <p>
 * DateTime: 2021-11-22 12:39 下午
 *
 * @author luocj
 */
public class CommonDO implements Serializable {

    @TableField(fill = FieldFill.INSERT)
    public LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    public LocalDateTime updatedAt;

    public Long createdBy;

    public Long updatedBy;

}
