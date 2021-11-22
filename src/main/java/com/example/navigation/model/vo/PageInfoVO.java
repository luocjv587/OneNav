package com.example.navigation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author  lm.sun
 * @create  2021/1/27 2:04 下午
 * @desc 分页
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfoVO<T> {

	private Long total;

	private List<T> items;
}
