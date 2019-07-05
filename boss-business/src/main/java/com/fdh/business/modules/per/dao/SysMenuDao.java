package com.fdh.business.modules.per.dao;

import com.fdh.business.modules.per.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysMenuDao  菜单表接口
 *
 * @author fdh
 */
public interface SysMenuDao {
    /**
     * 新增SysMenu
     *
     * @param sysMenu
     */
    void insert(SysMenu sysMenu);

    /**
     * 根据主键 删除SysMenu
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 修改SysMenu
     *
     * @param sysMenu
     */
    void update(SysMenu sysMenu);

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
     * 批量删除（逻辑删除）
     *
     * @param ids 操作的ids
     */
    void batchRemove(@Param("ids") Long[] ids);

    /**
     * 获取超级管理员顶部导航菜单
     *
     * @return
     */
    List<SysMenu> listMenuAdmin();

    /**
     * 获取管理员顶部菜单
     *
     * @return
     */
    List<SysMenu> queryAdminTopMenus();

    /**
     * 根据用户id获取顶部菜单
     *
     * @return
     */
    List<SysMenu> queryTopMenusByUser(Long userId);
}