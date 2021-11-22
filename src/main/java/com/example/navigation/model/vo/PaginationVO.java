package com.example.navigation.model.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.navigation.constant.CommonConstant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author  lm.sun
 * @create  2021/1/27 2:04 下午
 * @desc 分页组件
 **/
@Data
public class PaginationVO<T> extends Pagination {

	@ApiModelProperty(value = "筛选", notes = "筛选")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String q;

	@ApiModelProperty(value = "页码", notes = "页码")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private Integer pageNo = 1;

	@ApiModelProperty(value = "每页条数", notes = "每页条数")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private Integer pageSize = 1000;

	@Override
	public IPage<T> buildPage(){
		return new Page<T>().setSize(this.pageSize).setCurrent(this.pageNo);
	}

	@Override
	public String getLimit() {
		if (super.getPageSize() > 0 & super.getPageNum() > 0) {
			return CommonConstant.LIMIT_PREFIX + ((this.pageNo * this.getPageSize()) - this.getPageSize()) + CommonConstant.STRING_COMMA + this.getPageSize();
		}
		return CommonConstant.STRING_EMPTY;
	}
}
