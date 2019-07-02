package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.entity.SysOperLog;

import java.util.List;

/**
 *  SysOperLogService  操作日志记录接口
 *
 *  @author fdh
 */
public interface SysOperLogService {
    /**
     * 新增SysOperLog
     * @param sysOperLog
     */
    void add(SysOperLog sysOperLog);

    /**
     * 根据主键 删除SysOperLog (物理删除)
     * @param id
     */
    void delete(Long id);

    /**
     * 根据主键 删除SysOperLog (逻辑删除)
     * @param id
     */
    void remove(Long id);

    /**
     * 修改SysOperLog
     * @param sysOperLog
     */
    void modify(SysOperLog sysOperLog);

    /**
     * 根据主键查询SysOperLog
     * @param id
     * @return sysOperLog
     */
    SysOperLog queryOne(Long id);

    /**
     * 根据主键查询SysOperLog
     * @return sysOperLogs
     */
    List<SysOperLog> queryAll();

    /**
     * 根据字段查询（如需分页请setPageBean）
     * @param sysOperLog
     * @return sysOperLogs
     */
    List<SysOperLog> queryByFieldsAndPage(SysOperLog sysOperLog);

    /**
     * 批量删除SysOperLogs
     * @param ids
     */
    void batchRemove(Long[] ids);

    /**
     * 批量修改状态
     * @param ids 修改的ids
     * @param status 修改的状态
     */
    void batchModifyStatus(Long[] ids, Integer status);

}