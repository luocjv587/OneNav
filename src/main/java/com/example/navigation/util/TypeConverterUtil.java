package com.example.navigation.util;

import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.util
 * <p>
 * DateTime: 2021-11-22 12:10 下午
 *
 * @author luocj
 */
public class TypeConverterUtil {
    protected static <TARGET, SOURCE> void convert(SOURCE from, TARGET to, @Nullable String... ignoreProperties) {
        BeanUtils.copyProperties(from, to);
    }

    public static <TARGET, SOURCE> TARGET convert(SOURCE from, Class<TARGET> clazz, @Nullable String... ignoreProperties) {

        if (from == null) {
            return null;
        }
        TARGET to = null;
        try {
            to = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        convert(from, to, ignoreProperties);

        return to;
    }

    public static <TARGET, SOURCE> List<TARGET> convert(List<SOURCE> fromList, Class<TARGET> clazz, @Nullable String... ignoreProperties) {
        if (CollectionUtils.isEmpty(fromList)) {
            return new ArrayList<>();
        }

        List<TARGET> toList = new ArrayList<>();

        for (SOURCE from : fromList) {
            toList.add(convert(from, clazz, ignoreProperties));
        }

        return toList;
    }

}
