package com.fdh.business.modules.per.dao;

import com.fdh.business.modules.per.entity.SysMenu;
import com.fdh.business.modules.per.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * SysRoleMenuDao  角色菜单表接口
 *
 * @author fdh
 */
public interface SysRoleMenuDao {
    /**
     * 新增SysRoleMenu
     *
     * @param sysRoleMenu
     */
    void insert(SysRoleMenu sysRoleMenu);

    /**
     * 根据主键 删除SysRoleMenu
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 修改SysRoleMenu
     *
     * @param sysRoleMenu
     */
    void update(SysRoleMenu sysRoleMenu);

    /**
     * 根据主键查询SysRoleMenu
     *
     * @param id
     * @return sysRoleMenu
     */
    SysRoleMenu queryOne(Long id);

    /**
     * 根据主键查询SysRoleMenu
     *
     * @return sysRoleMenus
     */
    List<SysRoleMenu> queryAll();

    /**
     * 根据字段查询（如需分页请setPageBean）
     *
     * @param sysRoleMenu
     * @return sysRoleMenus
     */
    List<SysRoleMenu> queryByFieldsAndPage(SysRoleMenu sysRoleMenu);

    /**
     * 批量删除（逻辑删除）
     *
     * @param ids 操作的ids
     */
    void batchRemove(@Param("ids") Long[] ids);

    /**
     * 根据用户id查询菜单
     *
     * @param roles
     * @return
     */
    List<SysMenu> listMenusByRoles(@Param("roles") Set<String> roles);
}