package com.fdh.business.modules.sysuser.service;

import com.fdh.business.modules.sysuser.entity.SysUser;

import java.util.List;

/**
 *  SysUserService  用户信息表接口
 *
 *  @author fdh
 */
public interface SysUserService {
    /**
     * 新增SysUser
     * @param sysUser
     */
    void add(SysUser sysUser);

    /**
     * 根据主键 删除SysUser (物理删除)
     * @param id
     */
    void delete(Long id);

    /**
     * 根据主键 删除SysUser (逻辑删除)
     * @param id
     */
    void remove(Long id);

    /**
     * 修改SysUser
     * @param sysUser
     */
    void modify(SysUser sysUser);

    /**
     * 根据主键查询SysUser
     * @param id
     * @return sysUser
     */
    SysUser queryOne(Long id);

    /**
     * 根据主键查询SysUser
     * @return sysUsers
     */
    List<SysUser> queryAll();

    /**
     * 根据字段查询（如需分页请setPageBean）
     * @param sysUser
     * @return sysUsers
     */
    List<SysUser> queryByFieldsAndPage(SysUser sysUser);

    /**
     * 批量删除SysUsers
     * @param ids
     */
    void batchRemove(Long[] ids);

    /**
     * 批量修改状态
     * @param ids 修改的ids
     * @param status 修改的状态
     */
    void batchModifyStatus(Long[] ids, Integer status);

    /**
     * 用户登陆
     *
     * @param sysUser
     * @return
     */
    SysUser login(SysUser sysUser);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    SysUser queryByUsername(String username);

    /**
     * 根据手机号查询用户
     *
     * @param phone
     * @return
     */
    SysUser queryByPhone(String phone);

    /**
     * 根据邮箱查询用户
     *
     * @param email
     * @return
     */
    SysUser queryByEmail(String email);
}