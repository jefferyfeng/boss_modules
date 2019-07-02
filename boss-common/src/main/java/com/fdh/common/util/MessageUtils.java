package com.fdh.common.util;

import com.fdh.common.util.spring.SpringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @description:  获取i18n资源文件
 * @date: 2019/6/10 11:45
 * @author: fdh
 */
public class MessageUtils {
    public static String message(String code, Object... args) {
        /**
         * @description:  根据消息键和参数 获取消息 委托给spring messageSource
         * @date: 2019/6/10 11:44
         * @author: fdh
         * @param: [code, args] [消息键, 参数]
         * @return: java.lang.String [获取国际化翻译值]
         */
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
