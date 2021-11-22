package com.example.navigation.model.vo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.navigation.constant.CommonConstant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Strings;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;


@Data
public class Pagination<T> {

    @ApiModelProperty(value = "当前语言", notes = "当前语言")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String languageTag = "zh-cn";

    @ApiModelProperty(value = "页码", notes = "页码")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Integer pageNum = 1;

    @ApiModelProperty(value = "每页条数", notes = "每页条数")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Integer pageSize = Integer.MAX_VALUE;

    @ApiModelProperty(value = "名称", notes = "名称")
    private String name;

    @ApiModelProperty(value = "状态", notes = "状态")
    private String status;

    @ApiModelProperty(value = "开始时间", notes = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    @ApiModelProperty(value = "结束时间", notes = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;


    /**
     * 排序规则
     * 使用方法
     * get请求: url?sort=id;1&sort=create_time;2 按顺序排列 (默认为1,正序可不传)
     * 结果:    ORDER BY id ASC,create_time DESC
     */
    @ApiModelProperty(value = "排序 sortBy=id;1&sortBy=create_time;2 按顺序排列 (默认为1,正序可不传)", notes = "sort=id;1&sort=create_time;2 按顺序排列 (默认为1,正序可不传)")
    private String sortBy = "id;2";

    public QueryWrapper<T> buildQueryWrapper() {
        QueryWrapper<T> productTagDOQueryWrapper = new QueryWrapper<>();
        //判断没有则值为NULL,不影响没有这个字段的表
        if (!StringUtils.isEmpty(name)) {
            productTagDOQueryWrapper.like(CommonConstant.NAME, name);
        }
        if (!StringUtils.isEmpty(status)) {
            productTagDOQueryWrapper.eq(CommonConstant.STATUS, status);
        }
        if (beginTime != null && endTime != null) {
            productTagDOQueryWrapper.between(CommonConstant.CREATED_AT_COLUMN, beginTime, endTime);
        }
        productTagDOQueryWrapper.orderByDesc(CommonConstant.CREATED_AT_COLUMN);
        return productTagDOQueryWrapper;
    }

    public <T extends Pagination> LambdaQueryWrapper<T> buildLambdaQueryWrapper() {
        LambdaQueryWrapper<T> productTagDOQueryWrapper = new LambdaQueryWrapper<>();
        //判断没有则值为NULL,不影响没有这个字段的表
        if (!StringUtils.isEmpty(name)) {
            productTagDOQueryWrapper.like(T::getName, name);
        }
        if (!StringUtils.isEmpty(status)) {
            productTagDOQueryWrapper.eq(T::getStatus, status);
        }
        return productTagDOQueryWrapper;
    }

    public IPage<T> buildPage() {
        return new Page<T>().setSize(this.pageSize).setCurrent(this.pageNum);
    }


    /**
     * 注入过滤方法
     *
     * @param str 待过滤字符串
     * @return 过滤后的查询参数
     */
    private String TransactSQLInjection(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return CommonConstant.STRING_EMPTY;
        }
        return str.replaceAll(CommonConstant.PATTERN_INJECTION, CommonConstant.STRING_EMPTY);
    }

    public String getLimit() {
        if (getPageSize() > 0 & getPageNum() > 0) {
            return CommonConstant.LIMIT_PREFIX + ((getPageNum() * getPageSize()) - getPageSize()) + CommonConstant.STRING_COMMA + getPageSize();
        }
        return CommonConstant.STRING_EMPTY;
    }

}
