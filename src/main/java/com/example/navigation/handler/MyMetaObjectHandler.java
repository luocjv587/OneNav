package com.example.navigation.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.navigation.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author lm.sun
 * @create 2021/2/19 4:14 下午
 * @desc mybatis-plus 自定义元数据填充Handler
 **/
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入自动填充字段
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName(CommonConstant.CREATED_AT_HUMP, LocalDateTime.now(), metaObject);
        this.setFieldValByName(CommonConstant.UPDATED_AT_HUMP, LocalDateTime.now(), metaObject);
    }

    /**
     * 更新字段填充字段
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName(CommonConstant.UPDATED_AT_HUMP, LocalDateTime.now(), metaObject);
    }
}