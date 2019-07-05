package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.entity.SysMenu;
import com.fdh.business.modules.sysuser.entity.SysUser;
import com.fdh.common.core.entity.LayuiNav;

import java.util.List;

/**
 * SysMenuService  菜单表接口
 *
 * @author fdh
 */
public interface SysMenuService {
    /**
     * 新增SysMenu
     *
     * @param sysMenu
     */
    void add(SysMenu sysMenu);

    /**
     * 根据主键 删除SysMenu (物理删除)
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据主键 删除SysMenu (逻辑删除)
     *
     * @param id
     */
    void remove(Long id);

    /**
     * 修改SysMenu
     *
     * @param sysMenu
     */
    void modify(SysMenu sysMenu);

    /**
     * 根据主键查询SysMenu
     *
     * @param id
     * @return sysMenu
     */
    SysMenu queryOne(Long id);

    /**
     * 根据主键查询SysMenu
     *
     * @return sysMenus
     */
    List<SysMenu> queryAll();

    /**
     * 根据字段查询（如需分页请setPageBean）
     *
     * @param sysMenu
     * @return sysMenus
     */
    List<SysMenu> queryByFieldsAndPage(SysMenu sysMenu);

    /**
     * 批量删除SysMenus
     *
     * @param ids
     */
    void batchRemove(Long[] ids);

    /**
     * 获取顶部菜单
     *
     * @return
     */
    List<LayuiNav> listNavs(SysUser sysUser);

    /**
     * 超级管理员顶部菜单
     *
     * @return
     */
    List<LayuiNav> listNavsAdmin();

    /**
     * 获取左侧菜单
     *
     * @param user
     */
    List<LayuiNav> listMenusNavs(SysUser user, Long parentId);
}