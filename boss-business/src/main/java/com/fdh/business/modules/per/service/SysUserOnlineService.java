package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.entity.SysUserOnline;

import java.util.Date;
import java.util.List;

/**
 *  SysUserOnlineService  在线用户记录接口
 *
 *  @author fdh
 */
public interface SysUserOnlineService {
    /**
     * 新增SysUserOnline
     * @param sysUserOnline
     */
    void add(SysUserOnline sysUserOnline);

    /**
     * 根据主键 删除SysUserOnline (物理删除)
     * @param id
     */
    void delete(Long id);

    /**
     * 根据主键 删除SysUserOnline (逻辑删除)
     * @param id
     */
    void remove(Long id);

    /**
     * 修改SysUserOnline
     * @param sysUserOnline
     */
    void modify(SysUserOnline sysUserOnline);

    /**
     * 根据主键查询SysUserOnline
     * @param id
     * @return sysUserOnline
     */
    SysUserOnline queryOne(Long id);

    /**
     * 根据主键查询SysUserOnline
     * @return sysUserOnlines
     */
    List<SysUserOnline> queryAll();

    /**
     * 根据字段查询（如需分页请setPageBean）
     * @param sysUserOnline
     * @return sysUserOnlines
     */
    List<SysUserOnline> queryByFieldsAndPage(SysUserOnline sysUserOnline);

    /**
     * 批量删除SysUserOnlines
     * @param ids
     */
    void batchRemove(Long[] ids);

    /**
     * 批量修改状态
     * @param ids 修改的ids
     * @param status 修改的状态
     */
    void batchModifyStatus(Long[] ids, Integer status);

    /**
     * 查询会话集合
     *
     * @param expiredDate 有效期
     * @return 会话集合
     */
    List<SysUserOnline> selectOnlineByExpired(Date expiredDate);

    /**
     * 通过会话序号删除信息
     *
     * @param sessions 会话ID集合
     * @return 在线用户信息
     */
    void batchDeleteOnline(List<String> sessions);

    /**
     * 根据会话id查询用户状态信息
     *
     * @param sessionId
     * @return
     */
    SysUserOnline selectOnlineBySessionId(String sessionId);

    /**
     * 通过会话序号删除信息
     *
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    void deleteOnlineBySessionId(String sessionId);
}