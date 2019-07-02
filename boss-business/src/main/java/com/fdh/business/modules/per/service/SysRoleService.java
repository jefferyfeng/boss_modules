package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.entity.SysRole;

import java.util.List;

/**
 *  SysRoleService  角色表接口
 *
 *  @author fdh
 */
public interface SysRoleService {
    /**
     * 新增SysRole
     * @param sysRole
     */
    void add(SysRole sysRole);

    /**
     * 根据主键 删除SysRole (物理删除)
     * @param id
     */
    void delete(Long id);

    /**
     * 根据主键 删除SysRole (逻辑删除)
     * @param id
     */
    void remove(Long id);

    /**
     * 修改SysRole
     * @param sysRole
     */
    void modify(SysRole sysRole);

    /**
     * 根据主键查询SysRole
     * @param id
     * @return sysRole
     */
    SysRole queryOne(Long id);

    /**
     * 根据主键查询SysRole
     * @return sysRoles
     */
    List<SysRole> queryAll();

    /**
     * 根据字段查询（如需分页请setPageBean）
     * @param sysRole
     * @return sysRoles
     */
    List<SysRole> queryByFieldsAndPage(SysRole sysRole);

    /**
     * 批量删除SysRoles
     * @param ids
     */
    void batchRemove(Long[] ids);

    /**
     * 批量修改状态
     * @param ids 修改的ids
     * @param status 修改的状态
     */
    void batchModifyStatus(Long[] ids, Integer status);
}