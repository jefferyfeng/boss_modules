package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.entity.SysRoleMenu;
import com.fdh.business.modules.sysuser.entity.SysUser;
import com.fdh.common.core.entity.LayuiNav;

import java.util.List;
import java.util.Set;

/**
 * SysRoleMenuService  角色菜单表接口
 *
 * @author fdh
 */
public interface SysRoleMenuService {
    /**
     * 新增SysRoleMenu
     *
     * @param sysRoleMenu
     */
    void add(SysRoleMenu sysRoleMenu);

    /**
     * 根据主键 删除SysRoleMenu (物理删除)
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据主键 删除SysRoleMenu (逻辑删除)
     *
     * @param id
     */
    void remove(Long id);

    /**
     * 修改SysRoleMenu
     *
     * @param sysRoleMenu
     */
    void modify(SysRoleMenu sysRoleMenu);

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
     * 批量删除SysRoleMenus
     *
     * @param ids
     */
    void batchRemove(Long[] ids);

    /**
     * 根据用户id获取菜单
     *
     * @param roles
     * @return menus
     */
    Set<String> listMenusByUserId(Set<String> roles);

    /**
     * 根据用户获取顶部导航菜单
     *
     * @param sysUser
     * @return
     */
    List<LayuiNav> listNavsByUser(SysUser sysUser);

    /**
     * 根据角色获取权限
     *
     * @param roles 角色
     * @return permissions 权限
     */
    Set<String> listPermissionsByRoles(Set<String> roles);
}