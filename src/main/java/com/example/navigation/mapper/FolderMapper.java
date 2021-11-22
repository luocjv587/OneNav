package com.example.navigation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.navigation.model.domain.BookmarkDO;
import com.example.navigation.model.domain.FolderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author
 * @create 2021-06-29
 * @desc
 */
@Mapper
public interface FolderMapper extends BaseMapper<FolderDO> {

}
