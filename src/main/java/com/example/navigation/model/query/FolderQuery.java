package com.example.navigation.model.query;

import com.example.navigation.model.vo.PaginationVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mybatis-plus-generator
 * @create 2021-06-29
 * @desc
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FolderQuery extends PaginationVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long parentId;

}
