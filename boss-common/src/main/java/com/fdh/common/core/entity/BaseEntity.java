package com.fdh.common.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity基础类
 * 本系统为维护用户操作时间和数据的有效性，采用逻辑删除
 *
 *      isValid         标识数据是否逻辑有效（删除）      0.无效  1.有效
 *      createDate      标识数据的创建时间
 *      createUser      标识数据的创建者
 *      updateDate      标识数据的修改时间
 *      updateUser      标识数据的更新者
 *      remark          备用字段
 *      pageBean        为分页参数用于分页
 *
 * @date: 2019/6/3 11:42
 * @author: fdh
 */
public class BaseEntity implements Serializable {

    /** 逻辑有效 0.无效 1.有效 */
    private Integer isValid;

    /** 创建时间 */
    private Date createDate;

    /** 创建者 */
    private Long createUser;

    /** 更新时间 */
    private Date updateDate;

    /** 更新者 */
    private Long updateUser;

    /** 备注 */
    private String remark;

    /** 分页参数 */
    @JsonIgnore
    private PageBean pageBean;

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }
}
