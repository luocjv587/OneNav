package com.example.navigation.model.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.model.query
 * <p>
 * DateTime: 2021-11-22 12:41 下午
 *
 * @author luocj
 */
@Data
@Builder
public class LoginQuery {

    @ApiModelProperty(name = "username", value = "0", required = true)
    private String username;

    @ApiModelProperty(name = "password", value = "0", required = true)
    private String password;

    @ApiModelProperty(name = "name", value = "", required = true)
    private String name;
}
