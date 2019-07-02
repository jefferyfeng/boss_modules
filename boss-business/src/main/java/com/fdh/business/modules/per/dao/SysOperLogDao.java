package com.fdh.business.modules.per.dao;

import com.fdh.business.modules.per.entity.SysOperLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  SysOperLogDao  操作日志记录接口
 *
 *  @author fdh
 */
public interface SysOperLogDao {
    /**
     * 新增SysOperLog
     * @param sysOperLog
     */
    void insert(SysOperLog sysOperLog);

    /**
     * 根据主键 删除SysOperLog
     * @param id
     */
    void delete(Long id);

    /**
     * 修改SysOperLog
     * @param sysOperLog
     */
    void update(SysOperLog sysOperLog);

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
     * 批量删除（逻辑删除）
     * @param ids 操作的ids
     */
    void batchRemove(@Param("ids") Long[] ids);

    /**
     * 批量修改状态
     * @param ids
     * @param status
     */
    void batchModifyStatus(@Param("ids") Long[] ids, @Param("status") Integer status);
}