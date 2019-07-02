package com.fdh.common.util;

/**
 * @description:  开发工具类
 * @date: 2019/6/3 14:48
 * @author: fdh
 */
public class StringUtil{
    /**
     * @description: 是否为空字符串
     * @date: 2019/6/3 14:49
     * @author: fdh
     * @param: [input] [校验字符串]
     * @return: boolean [true: 空 false: 非空]
     */
    public static boolean isEmpty(String input) {
        return input == null || "".equals(input.trim());
    }

    /**
     * @description: 是否非空字符串
     * @date: 2019/6/3 14:50
     * @author: fdh
     * @param: [input] [校验字符串]
     * @return: boolean [true: 非空 false: 空]
     */
    public static boolean isNotEmpty(String input) {
        return input != null && !"".equals(input.trim());
    }

    /**
     * 是否包含字符串
     *
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs) {
        if (null != str && null != strs) {
            for (String s : strs) {
                if (str.equalsIgnoreCase(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @description:  去除前后空格
     * @date: 2019/6/4 13:14
     * @author: fdh
     * @param: [str]
     * @return: java.lang.String
     */
    public static String trim(String str) {
        return (str == null ? "" : str.trim());
    }

    /**
     * @description:  获取分割符的字符串
     * @date: 2019/6/6 14:49
     * @author: fdh
     * @param: [msg]
     * @return: java.lang.String
     */
    public static String getBlock(Object msg) {
        if (msg == null)
        {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}
