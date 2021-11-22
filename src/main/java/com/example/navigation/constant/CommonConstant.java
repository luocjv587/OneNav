package com.example.navigation.constant;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.constant
 * <p>
 * DateTime: 2021-11-22 11:51 上午
 *
 * @author luocj
 */
public class CommonConstant {
    public static final String REST_V1 = "/api/v1";

    public static final String CREATED_AT_HUMP = "createdAt";
    public static final String CREATED_AT_COLUMN = "created_at";
    public static final String UPDATED_BY_HUMP = "updatedBy";
    public static final String UPDATED_BY_COLUMN = "updated_by";
    public static final String UPDATED_AT_HUMP = "updatedAt";
    public static final String UPDATED_AT_COLUMN = "updated_at";


    /**
     * LIMIT 前缀
     */
    public static final String LIMIT_PREFIX = "LIMIT ";

    /**
     * 排序字符串前缀
     */
    public static final String SORT_PREFIX = "ORDER BY ";

    /**
     * 升序字符串
     */
    public static final String SORT_ASC = "ASC";

    /**
     * 降序字符串
     */
    public static final String SORT_DESC = "DESC";

    /**
     * 降序字符串映射值
     */
    public static final String SORT_DESC_MAPPING = "2";

    /**
     * 空格字符串
     */
    public static final String STRING_SPACE = " ";

    /**
     * 空字符串
     */
    public static final String STRING_EMPTY = "";

    /**
     * 逗号字符串
     */
    public static final String STRING_COMMA = ",";

    /**
     * 中间线字符串
     */
    public static final String STRING_MIDDLE = ";";

    /**
     * 注入过滤规则
     */
    public static final String PATTERN_INJECTION = ".*([\"';]+|(--)+).*";

    /**
     * 通用数据 - 实体名：HUMP   COLUMN：字段名
     * 1.避免写错 比如：createdBy 写成 createBy
     * 2.避免魔法值
     * 3.数据库通用字段统一更改，JAVA代码里只用改此处
     */

    public final static String NAME = "name";

    public final static String TYPE = "type";

    public final static String STATUS = "status";
}
