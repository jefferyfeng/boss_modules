package com.fdh.common.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fdh.common.core.entity.page.PageBean;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Entity基础类
 * 本系统为维护用户操作时间和数据的有效性，采用逻辑删除
 *
 *      delFlag         标识数据是否逻辑有效（删除）      0.无效  1.有效
 *      createTime      标识数据的创建时间
 *      createBy        标识数据的创建者
 *      updateTime      标识数据的修改时间
 *      updateBy        标识数据的更新者
 *      remark          备用字段
 *      pageBean        为分页参数用于分页
 *
 * @date: 2019/6/3 11:42
 * @author: fdh
 */
@Getter
@Setter
public class BaseEntity implements Serializable {

    /** 逻辑有效 0.无效 1.有效 */
    private Integer delFlag;

    /** 创建时间 */
    private Date createTime;

    /** 创建者 */
    private String createBy;

    /** 更新时间 */
    private Date updateTime;

    /** 更新者 */
    private String updateBy;

    /** 备注 */
    private String remark;

    /** 请求参数 */
    private Map<String,Object> params;

    /** 分页参数 */
    @JsonIgnore
    private PageBean pageBean;
}
