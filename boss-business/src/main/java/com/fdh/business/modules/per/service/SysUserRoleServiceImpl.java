package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.dao.SysUserRoleDao;
import com.fdh.business.modules.per.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 *  SysUserRoleServiceImpl  用户角色表实现类
 *
 *  @author fdh
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,isolation = Isolation.READ_UNCOMMITTED, readOnly = true)
public class SysUserRoleServiceImpl implements SysUserRoleService{
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 新增SysUserRole
     * @param sysUserRole
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void add(SysUserRole sysUserRole){
        Date date = new Date();
        sysUserRole.setCreateDate(date);
        sysUserRole.setUpdateDate(date);
        sysUserRole.setIsValid(1);
        sysUserRoleDao.insert(sysUserRole);
    }

    /**
     * 根据主键 删除SysUserRole (物理删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void delete(Long id){
        sysUserRoleDao.delete(id);
    }

    /**
     * 根据主键 删除SysUserRole (逻辑删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void remove(Long id){
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setId(id);
        sysUserRole.setIsValid(0);
        sysUserRole.setUpdateDate(new Date());
        sysUserRoleDao.update(sysUserRole);
    }

    /**
     * 修改SysUserRole
     * @param sysUserRole
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void modify(SysUserRole sysUserRole){
        sysUserRole.setUpdateDate(new Date());
        sysUserRoleDao.update(sysUserRole);
    }

    /**
     * 根据主键查询SysUserRole
     * @param id
     * @return sysUserRole
     */
    @Override
    public SysUserRole queryOne(Long id){
        return sysUserRoleDao.queryOne(id);
    }

    /**
     * 根据主键查询SysUserRole
     * @return sysUserRoles
     */
    @Override
    public List<SysUserRole> queryAll(){
        return sysUserRoleDao.queryAll();
    }

    /**
     * 根据字段查询（如需分页请setPageBean）
     * @param sysUserRole
     * @return sysUserRoles
     */
    @Override
    public List<SysUserRole> queryByFieldsAndPage(SysUserRole sysUserRole){
        return sysUserRoleDao.queryByFieldsAndPage(sysUserRole);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void batchRemove(Long[] ids) {
        sysUserRoleDao.batchRemove(ids);
    }

    /**
     * 根据用户id查询角色
     * @param userId 用户id
     * @return rolesArr 角色id的数组
     */
    @Override
    public Set<String> listRolesByUserId(Long userId) {
        return new HashSet<String>(Arrays.asList(sysUserRoleDao.listRolesByUserId(userId)));
    }
}