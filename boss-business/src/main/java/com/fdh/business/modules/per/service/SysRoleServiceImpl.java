package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.dao.SysRoleDao;
import com.fdh.business.modules.per.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *  SysRoleServiceImpl  角色表实现类
 *
 *  @author fdh
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,isolation = Isolation.READ_UNCOMMITTED, readOnly = true)
public class SysRoleServiceImpl implements SysRoleService{
    @Autowired
    private SysRoleDao sysRoleDao;

    /**
     * 新增SysRole
     * @param sysRole
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void add(SysRole sysRole){
        Date date = new Date();
        sysRole.setCreateDate(date);
        sysRole.setUpdateDate(date);
        sysRole.setIsValid(1);
        sysRoleDao.insert(sysRole);
    }

    /**
     * 根据主键 删除SysRole (物理删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void delete(Long id){
        sysRoleDao.delete(id);
    }

    /**
     * 根据主键 删除SysRole (逻辑删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void remove(Long id){
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setIsValid(0);
        sysRole.setUpdateDate(new Date());
        sysRoleDao.update(sysRole);
    }

    /**
     * 修改SysRole
     * @param sysRole
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void modify(SysRole sysRole){
        sysRole.setUpdateDate(new Date());
        sysRoleDao.update(sysRole);
    }

    /**
     * 根据主键查询SysRole
     * @param id
     * @return sysRole
     */
    @Override
    public SysRole queryOne(Long id){
        return sysRoleDao.queryOne(id);
    }

    /**
     * 根据主键查询SysRole
     * @return sysRoles
     */
    @Override
    public List<SysRole> queryAll(){
        return sysRoleDao.queryAll();
    }

    /**
     * 根据字段查询（如需分页请setPageBean）
     * @param sysRole
     * @return sysRoles
     */
    @Override
    public List<SysRole> queryByFieldsAndPage(SysRole sysRole){
        return sysRoleDao.queryByFieldsAndPage(sysRole);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void batchRemove(Long[] ids) {
        sysRoleDao.batchRemove(ids);
    }

    /**
     * 批量修改状态
     * @param ids 修改的ids
     * @param status 修改的状态
     */
    @Override
    public void batchModifyStatus(Long[] ids, Integer status) {
        sysRoleDao.batchModifyStatus(ids,status);
    }
}