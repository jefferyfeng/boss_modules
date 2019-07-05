package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.dao.SysRoleMenuDao;
import com.fdh.business.modules.per.entity.SysMenu;
import com.fdh.business.modules.per.entity.SysRoleMenu;
import com.fdh.business.modules.sysuser.entity.SysUser;
import com.fdh.common.constants.Constants;
import com.fdh.common.core.entity.LayuiNav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * SysRoleMenuServiceImpl  角色菜单表实现类
 *
 * @author fdh
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,isolation = Isolation.READ_UNCOMMITTED, readOnly = true)
public class SysRoleMenuServiceImpl implements SysRoleMenuService{
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 新增SysRoleMenu
     * @param sysRoleMenu
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void add(SysRoleMenu sysRoleMenu){
        Date date = new Date();
        sysRoleMenu.setCreateDate(date);
        sysRoleMenu.setUpdateDate(date);
        sysRoleMenu.setIsValid(1);
        sysRoleMenuDao.insert(sysRoleMenu);
    }

    /**
     * 根据主键 删除SysRoleMenu (物理删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void delete(Long id){
        sysRoleMenuDao.delete(id);
    }

    /**
     * 根据主键 删除SysRoleMenu (逻辑删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void remove(Long id){
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        sysRoleMenu.setId(id);
        sysRoleMenu.setIsValid(0);
        sysRoleMenu.setUpdateDate(new Date());
        sysRoleMenuDao.update(sysRoleMenu);
    }

    /**
     * 修改SysRoleMenu
     * @param sysRoleMenu
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void modify(SysRoleMenu sysRoleMenu){
        sysRoleMenu.setUpdateDate(new Date());
        sysRoleMenuDao.update(sysRoleMenu);
    }

    /**
     * 根据主键查询SysRoleMenu
     * @param id
     * @return sysRoleMenu
     */
    @Override
    public SysRoleMenu queryOne(Long id){
        return sysRoleMenuDao.queryOne(id);
    }

    /**
     * 根据主键查询SysRoleMenu
     * @return sysRoleMenus
     */
    @Override
    public List<SysRoleMenu> queryAll(){
        return sysRoleMenuDao.queryAll();
    }

    /**
     * 根据字段查询（如需分页请setPageBean）
     * @param sysRoleMenu
     * @return sysRoleMenus
     */
    @Override
    public List<SysRoleMenu> queryByFieldsAndPage(SysRoleMenu sysRoleMenu){
        return sysRoleMenuDao.queryByFieldsAndPage(sysRoleMenu);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void batchRemove(Long[] ids) {
        sysRoleMenuDao.batchRemove(ids);
    }

    /**
     * 根据用户id获取菜单
     *
     * @param roles
     * @return menus
     */
    @Override
    public Set<String> listMenusByUserId(Set<String> roles) {
        // TODO
        return new HashSet<String>();
    }

    /**
     * 根据用户获取顶部导航菜单
     *
     * @param sysUser
     * @return
     */
    @Override
    public List<LayuiNav> listNavsByUser(SysUser sysUser) {
        List<LayuiNav> navs = null;
        //超级管理员拥有以切菜单权限
        if(Constants.IS_ADMIN.YES.getValue().equals(sysUser.getIsAdmin())){
            navs = sysMenuService.listNavsAdmin();
        }else{

        }
        return navs;
    }

    /**
     * 根据角色获取权限
     *
     * @param roles
     * @return menus
     */
    @Override
    public Set<String> listPermissionsByRoles(Set<String> roles){
        List<SysMenu> menus = sysRoleMenuDao.listMenusByRoles(roles);
        Set<String> persmissions = new HashSet<>();
        for (SysMenu menu : menus) {
            persmissions.add(menu.getPermission());
        }
        return persmissions;
    }

}