package com.fdh.common.util;

import java.util.Collection;

/**
 * @description:  集合工具类
 * @date: 2019/6/24 15:34
 * @author: fdh
 */
public class CollectionUtils {
    /**
     * @description: 是否为空集合
     * @date: 2019/6/3 14:51
     * @author: fdh
     * @param: [collection] [校验集合]
     * @return: boolean [true: 空 false: 非空]
     */
    public static boolean isEmpty(Collection collection) {
        return ((collection == null) || collection.isEmpty());
    }

    /**
     * @description: 判断是否非空集合
     * @date: 2019/6/3 14:51
     * @author: fdh
     * @param: [collection] [校验集合]
     * @return: boolean [true: 非空 false: 空]
     */
    public static boolean isNotEmpty(Collection collection) {
        return ((collection != null) && !(collection.isEmpty()));
    }

    /**
     * @description: 是否为空数组
     * @date: 2019/6/3 14:52
     * @author: fdh
     * @param: [array] [校验数组]
     * @return: boolean [true: 空 false: 非空]
     */
    public static boolean isEmpty(Object[] array) {
        return ((array == null) || array.length == 0);
    }

    /**
     * @description: 是否非空数组
     * @date: 2019/6/3 14:52
     * @author: fdh
     * @param: [array] [校验数组]
     * @return: boolean [true: 非空 false: 空]
     */
    public static boolean isNotEmpty(Object[] arrays) {
        return ((arrays != null) && arrays.length > 0);
    }
}
