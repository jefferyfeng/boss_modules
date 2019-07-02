package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.dao.SysMenuDao;
import com.fdh.business.modules.per.entity.SysMenu;
import com.fdh.common.core.entity.LayuiNav;
import com.fdh.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  SysMenuServiceImpl  菜单表实现类
 *
 *  @author fdh
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,rollbackFor = Exception.class,isolation = Isolation.READ_UNCOMMITTED, readOnly = true)
public class SysMenuServiceImpl implements SysMenuService{
    @Autowired
    private SysMenuDao sysMenuDao;

    /**
     * 新增SysMenu
     * @param sysMenu
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void add(SysMenu sysMenu){
        Date date = new Date();
        sysMenu.setCreateDate(date);
        sysMenu.setUpdateDate(date);
        sysMenu.setIsValid(1);
        sysMenuDao.insert(sysMenu);
    }

    /**
     * 根据主键 删除SysMenu (物理删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void delete(Long id){
        sysMenuDao.delete(id);
    }

    /**
     * 根据主键 删除SysMenu (逻辑删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void remove(Long id){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(id);
        sysMenu.setIsValid(0);
        sysMenu.setUpdateDate(new Date());
        sysMenuDao.update(sysMenu);
    }

    /**
     * 修改SysMenu
     * @param sysMenu
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void modify(SysMenu sysMenu){
        sysMenu.setUpdateDate(new Date());
        sysMenuDao.update(sysMenu);
    }

    /**
     * 根据主键查询SysMenu
     * @param id
     * @return sysMenu
     */
    @Override
    public SysMenu queryOne(Long id){
        return sysMenuDao.queryOne(id);
    }

    /**
     * 根据主键查询SysMenu
     * @return sysMenus
     */
    @Override
    public List<SysMenu> queryAll(){
        return sysMenuDao.queryAll();
    }

    /**
     * 根据字段查询（如需分页请setPageBean）
     * @param sysMenu
     * @return sysMenus
     */
    @Override
    public List<SysMenu> queryByFieldsAndPage(SysMenu sysMenu){
        return sysMenuDao.queryByFieldsAndPage(sysMenu);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void batchRemove(Long[] ids) {
        sysMenuDao.batchRemove(ids);
    }

    /**
     * 超级管理员顶部菜单
     *
     * @return
     */
    @Override
    public List<LayuiNav> listNavsAdmin() {
        List<SysMenu> menus = sysMenuDao.listMenuAdmin();
        List<LayuiNav> layuiNavs = getLayuiNavsAdmin(menus);
        return layuiNavs;
    }

    /**
     * 配置为layui的权限菜单
     *
     * @param menus 数据库查询的菜单
     * @return layuiNavList LayuiNav对象集合的权限菜单
     */
    private List<LayuiNav> getLayuiNavsAdmin(List<SysMenu> menus){
        if(StringUtil.isEmpty(menus)) {
            return null;
        }
        List<LayuiNav> layuiNavs = new ArrayList<>();
        for (SysMenu sysMenu : menus) {
            LayuiNav layuiNav = new LayuiNav();
            //菜单id
            layuiNav.setId(sysMenu.getId());
            //菜单名称
            layuiNav.setTitle(sysMenu.getMenuName());
            //菜单图标
            layuiNav.setIcon(sysMenu.getMenuIcon());
            //菜单url
            layuiNav.setHref(sysMenu.getMenuUrl());
            //菜单选中 默认不选中
            layuiNavs.add(layuiNav);
        }
        return layuiNavs;
    }


    /**
     * 配置为layui的权限菜单
     *
     * @param permissionVos 数据库查询的菜单
     * @param permissions 用户所拥有的权限id
     * @return layuiNavList LayuiNav对象集合的权限菜单
     */
    /*private List<LayuiNav> getLayuiNavs(List<SysMenu> menus, List<Long> permissions){
        if(MyUtil.isEmpty(permissionVos)) return null;
        List<LayuiNav> layuiNavs = new ArrayList<>();
        for (SysPermissionVo permissionVo : permissionVos) {
            if(!permissions.contains(permissionVo.getId())){
                continue;
            }
            LayuiNav layuiNav = new LayuiNav();
            //菜单id
            layuiNav.setId(permissionVo.getId());
            //菜单名称
            layuiNav.setTitle(permissionVo.getPermissionName());
            //菜单图标
            layuiNav.setIcon(permissionVo.getPermissionIcon());
            //菜单url
            layuiNav.setHref(permissionVo.getPermissionUrl());
            //菜单选中 默认不选中
            layuiNav.setSpread(false);
            if(MyUtil.isNotEmpty(permissionVo.getChildren())){
                layuiNav.setChildren(getLayuiNavs(permissionVo.getChildren(),permissions));
            }
            layuiNavs.add(layuiNav);
        }
        return layuiNavs;
    }*/

}