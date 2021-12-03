package com.example.navigation.model.vo;

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
public class AppAuthVO implements Serializable {
    public Date createdAt;
    public Date updatedAt;
    public Long createdBy;
    public Long updatedBy;
    private Long id;
    private Long userId;
    private String appKey;
    private String appSecret;


}
