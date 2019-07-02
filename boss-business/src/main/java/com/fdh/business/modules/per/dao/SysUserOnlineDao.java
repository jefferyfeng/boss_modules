package com.fdh.business.modules.per.dao;

import com.fdh.business.modules.per.entity.SysUserOnline;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  SysUserOnlineDao  在线用户记录接口
 *
 *  @author fdh
 */
public interface SysUserOnlineDao {
    /**
     * 新增SysUserOnline
     * @param sysUserOnline
     */
    void insert(SysUserOnline sysUserOnline);

    /**
     * 根据主键 删除SysUserOnline
     * @param id
     */
    void delete(Long id);

    /**
     * 修改SysUserOnline
     * @param sysUserOnline
     */
    void update(SysUserOnline sysUserOnline);

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

    /**
     * 查询过期会话集合
     *
     * @param lastAccessTime 过期时间
     * @return 会话集合
     */
    List<SysUserOnline> selectOnlineByExpired(String lastAccessTime);

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