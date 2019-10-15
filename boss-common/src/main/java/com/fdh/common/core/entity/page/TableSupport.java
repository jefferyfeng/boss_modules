package com.fdh.common.core.entity.page;

import com.fdh.common.constants.PageConstants;
import com.fdh.common.util.ServletUtils;
import com.fdh.common.util.text.Convert;

/**
 * @description:  表格数据处理
 * @date: 2019/10/14 16:21
 * @author: fdh
 */
public class TableSupport {

    /**
     * @description: 封装分页实体
     * @date: 2019/10/14 16:22
     * @author: fdh
     * @param: []
     * @return: com.fdh.common.core.entity.page.PageBean
     */
    public static PageBean getPageBean() {
        PageBean pageBean = new PageBean();
        pageBean.setPageNum(Convert.toInt(ServletUtils.getRequest().getParameter(PageConstants.PAGE_NUM)));
        pageBean.setPageSize(Convert.toInt(ServletUtils.getRequest().getParameter(PageConstants.PAGE_SIZE)));
        pageBean.setOrderByColumn(ServletUtils.getRequest().getParameter(PageConstants.ORDER_BY_COLUMN));
        pageBean.setIsAsc(ServletUtils.getRequest().getParameter(PageConstants.IS_ASC));
        return pageBean;
    }

    public static PageBean buildPageRequest() {
        return getPageBean();
    }
}
