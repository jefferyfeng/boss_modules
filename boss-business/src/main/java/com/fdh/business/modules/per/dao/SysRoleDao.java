package com.fdh.business.modules.per.dao;

import com.fdh.business.modules.per.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysRoleDao  角色表接口
 *
 * @author fdh
 */
public interface SysRoleDao {
    /**
     * 新增SysRole
     *
     * @param sysRole
     */
    void insert(SysRole sysRole);

    /**
     * 根据主键 删除SysRole
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 修改SysRole
     *
     * @param sysRole
     */
    void update(SysRole sysRole);

    /**
     * 根据主键查询SysRole
     *
     * @param id
     * @return sysRole
     */
    SysRole queryOne(Long id);

    /**
     * 根据主键查询SysRole
     *
     * @return sysRoles
     */
    List<SysRole> queryAll();

    /**
     * 根据字段查询（如需分页请setPageBean）
     *
     * @param sysRole
     * @return sysRoles
     */
    List<SysRole> queryByFieldsAndPage(SysRole sysRole);

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
}