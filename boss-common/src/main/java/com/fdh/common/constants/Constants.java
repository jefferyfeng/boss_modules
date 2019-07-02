package com.fdh.common.constants;

/**
 * @description: 常量
 * @date: 2019/6/3 14:44
 * @author: fdh
 */
public class Constants {
    public static final String CAPTCHA_CODE = "captcha";
    public static final String SESSIOIN_USER = "user";
    public static final String DEFAULT_USER_PWD = "123456";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * @description:  是否有效
     * @date: 2019/6/4 14:01
     * @author: fdh
     */
    public static enum IS_VALID {
        NO(0, "无效"), YES(1, "有效");

        private Integer value;
        private String description;

        IS_VALID(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

        public Integer getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }
    }

    /**
     * @description:  是否有效
     * @date: 2019/6/4 14:01
     * @author: fdh
     */
    public static enum STATUS {
        NO(0, "禁用"), YES(1, "启用");

        private Integer value;
        private String description;

        STATUS(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

        public Integer getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }
    }
    /**
     * @description:  是否是顶级管理员
     * @date: 2019/6/4 14:01
     * @author: fdh
     */
    public static enum IS_ADMIN{
        NO(0), YES(1);
        private Integer value;

        IS_ADMIN(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    /**
     * @description:   操作状态
     * @date: 2019/6/4 14:01
     * @author: fdh
     */
    public static enum OPERATE_STATUS{
        FAIL(0,"失败"), SUCCESS(1,"成功");
        private Integer value;
        private String description;

        OPERATE_STATUS(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

        public Integer getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }
    }


    /**
     * @description:   操作类型
     * @date: 2019/6/4 14:01
     * @author: fdh
     */
    public static enum OPERATE_TYPE{
        LOGIN(0,"登陆"), LOGOUT(1,"退出");
        private Integer value;
        private String description;

        OPERATE_TYPE(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

        public Integer getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }
    }

}
