package com.example.navigation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.navigation.model.domain.FolderDO;
import com.example.navigation.model.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author
 * @create 2021-06-29
 * @desc
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

}
