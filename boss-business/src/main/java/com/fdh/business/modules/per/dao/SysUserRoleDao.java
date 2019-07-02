package com.fdh.business.modules.per.dao;

import com.fdh.business.modules.per.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysUserRoleDao  用户角色表接口
 *
 * @author fdh
 */
public interface SysUserRoleDao {
    /**
     * 新增SysUserRole
     *
     * @param sysUserRole
     */
    void insert(SysUserRole sysUserRole);

    /**
     * 根据主键 删除SysUserRole
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 修改SysUserRole
     *
     * @param sysUserRole
     */
    void update(SysUserRole sysUserRole);

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
     * 批量删除（逻辑删除）
     *
     * @param ids 操作的ids
     */
    void batchRemove(@Param("ids") Long[] ids);

    /**
     * 根据用户id获取角色ids
     *
     * @param userId 用户id
     * @return 角色id的数组
     */
    String[] listRolesByUserId(Long userId);
}