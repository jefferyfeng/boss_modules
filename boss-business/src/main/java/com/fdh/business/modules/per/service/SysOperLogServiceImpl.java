package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.dao.SysOperLogDao;
import com.fdh.business.modules.per.entity.SysOperLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *  SysOperLogServiceImpl  操作日志记录实现类
 *
 *  @author fdh
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,isolation = Isolation.READ_UNCOMMITTED, readOnly = true)
public class SysOperLogServiceImpl implements SysOperLogService{
    @Autowired
    private SysOperLogDao sysOperLogDao;

    /**
     * 新增SysOperLog
     * @param sysOperLog
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void add(SysOperLog sysOperLog){
        Date date = new Date();
        sysOperLog.setCreateDate(date);
        sysOperLog.setUpdateDate(date);
        sysOperLog.setIsValid(1);
        sysOperLogDao.insert(sysOperLog);
    }

    /**
     * 根据主键 删除SysOperLog (物理删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void delete(Long id){
        sysOperLogDao.delete(id);
    }

    /**
     * 根据主键 删除SysOperLog (逻辑删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void remove(Long id){
        SysOperLog sysOperLog = new SysOperLog();
        sysOperLog.setId(id);
        sysOperLog.setIsValid(0);
        sysOperLog.setUpdateDate(new Date());
        sysOperLogDao.update(sysOperLog);
    }

    /**
     * 修改SysOperLog
     * @param sysOperLog
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void modify(SysOperLog sysOperLog){
        sysOperLog.setUpdateDate(new Date());
        sysOperLogDao.update(sysOperLog);
    }

    /**
     * 根据主键查询SysOperLog
     * @param id
     * @return sysOperLog
     */
    @Override
    public SysOperLog queryOne(Long id){
        return sysOperLogDao.queryOne(id);
    }

    /**
     * 根据主键查询SysOperLog
     * @return sysOperLogs
     */
    @Override
    public List<SysOperLog> queryAll(){
        return sysOperLogDao.queryAll();
    }

    /**
     * 根据字段查询（如需分页请setPageBean）
     * @param sysOperLog
     * @return sysOperLogs
     */
    @Override
    public List<SysOperLog> queryByFieldsAndPage(SysOperLog sysOperLog){
        return sysOperLogDao.queryByFieldsAndPage(sysOperLog);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void batchRemove(Long[] ids) {
        sysOperLogDao.batchRemove(ids);
    }

    /**
     * 批量修改状态
     * @param ids 修改的ids
     * @param status 修改的状态
     */
    @Override
    public void batchModifyStatus(Long[] ids, Integer status) {
        sysOperLogDao.batchModifyStatus(ids,status);
    }

}