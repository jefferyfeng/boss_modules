package com.fdh.business.modules.sysuser.dao;

import com.fdh.business.modules.sysuser.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysUserDao  用户信息表接口
 *
 * @date: 2019/6/4 10:56
 * @author: fdh
 */
public interface SysUserDao {
    /**
     * 新增SysUser
     *
     * @param sysUser
     */
    void insert(SysUser sysUser);

    /**
     * 根据主键 删除SysUser
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 修改SysUser
     *
     * @param sysUser
     */
    void update(SysUser sysUser);

    /**
     * 根据主键查询SysUser
     *
     * @param id
     * @return sysUser
     */
    SysUser queryOne(Long id);

    /**
     * 根据主键查询SysUser
     *
     * @return sysUsers
     */
    List<SysUser> queryAll();

    /**
     * 根据字段查询（如需分页请setPageBean）
     *
     * @param sysUser
     * @return sysUsers
     */
    List<SysUser> queryByFieldsAndPage(SysUser sysUser);

    /**
     * 批量删除（逻辑删除）
     *
     * @param ids 操作的ids
     */
    void batchRemove(@Param("ids") Long[] ids);

    /**
     * 批量修改状态
     *
     * @param ids
     * @param status
     */
    void batchModifyStatus(@Param("ids") Long[] ids, @Param("status") Integer status);

    /**
     * 根据用户名查询SysUser
     *
     * @param username
     * @return
     */
    SysUser queryByUsername(@Param("username") String username);

    /**
     * 根据手机号查询SysUser
     *
     * @param phone
     * @return
     */
    SysUser queryByPhone(String phone);

    /**
     * 根据邮箱查询SysUser
     *
     * @param email
     * @return
     */
    SysUser queryByEmail(@Param("email") String email);
}