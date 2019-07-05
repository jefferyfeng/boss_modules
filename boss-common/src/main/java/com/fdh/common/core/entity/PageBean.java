package com.fdh.common.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 分页实体
 * @date: 2019/6/3 13:07
 * @author: fdh
 */
@Data
public class PageBean implements Serializable {
    /**
     * 定义数据库 分页操作的起始索引
     * MySQL index = 0
     * Oracle index = 1
     */
    private static final Integer DB_INDEX_START = 0;
    /**
     * 默认页码
     */
    private static final Integer DEFAULT_PAGE = 1;
    /**
     * 默认页面容量
     */
    private static final Integer DEFAULT_PAGESIZE = 10;
    /**
     * 当前页
     */
    private Integer currentPage;
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 页面容量
     */
    private Integer pageSize;

    /**
     * 起始条
     */
    private Integer begin;
    /**
     * 结束条
     */
    private Integer end;
    /**
     * 最大页码
     */
    private Integer maxPage;
    /**
     * 当前页取得条数
     */
    private Integer pageCount;

    /**
     * 通过传入总条数计算各个参数值
     */
    public void setAll(Integer total){
        this.total = total;
        //处理无效页码 和 无效页面容量
        currentPage = ( (currentPage == null || currentPage <= 0) ? DEFAULT_PAGE : currentPage ) ;
        pageSize = ( (pageSize == null || pageSize <= 0) ? DEFAULT_PAGESIZE : pageSize ) ;

        //计算每个结果
        maxPage = total % pageSize == 0 ? total / pageSize : total / pageSize +1;
        begin = (currentPage - 1) * pageSize + DB_INDEX_START;
        end = currentPage.equals(maxPage)  ? total - 1 + DB_INDEX_START : currentPage * pageSize -1 + DB_INDEX_START;
        pageCount = end - begin + 1;
    }
}