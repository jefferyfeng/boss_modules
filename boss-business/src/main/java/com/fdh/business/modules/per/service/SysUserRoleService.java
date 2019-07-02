package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.entity.SysUserRole;

import java.util.List;
import java.util.Set;

/**
 *  SysUserRoleService  用户角色表接口
 *
 *  @author fdh
 */
public interface SysUserRoleService {
    /**
     * 新增SysUserRole
     *
     * @param sysUserRole
     */
    void add(SysUserRole sysUserRole);

    /**
     * 根据主键 删除SysUserRole (物理删除)
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据主键 删除SysUserRole (逻辑删除)
     *
     * @param id
     */
    void remove(Long id);

    /**
     * 修改SysUserRole
     *
     * @param sysUserRole
     */
    void modify(SysUserRole sysUserRole);

    /**
     * 根据主键查询SysUserRole
     *
     * @param id
     * @return sysUserRole
     */
    SysUserRole queryOne(Long id);

    /**
     * 根据主键查询SysUserRole
     *
     * @return sysUserRoles
     */
    List<SysUserRole> queryAll();

    /**
     * 根据字段查询（如需分页请setPageBean）
     *
     * @param sysUserRole
     * @return sysUserRoles
     */
    List<SysUserRole> queryByFieldsAndPage(SysUserRole sysUserRole);

    /**
     * 批量删除SysUserRoles
     *
     * @param ids
     */
    void batchRemove(Long[] ids);


    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return rolesArr 角色id的数组
     */
    Set<String> listRolesByUserId(Long userId);
}