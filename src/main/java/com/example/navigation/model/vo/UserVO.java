package com.example.navigation.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class UserVO implements Serializable {
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

    private String jwtToken;

}
