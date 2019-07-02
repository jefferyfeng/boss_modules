package com.fdh.business.modules.per.service;

import com.fdh.business.modules.per.dao.SysUserOnlineDao;
import com.fdh.business.modules.per.entity.SysUserOnline;
import com.fdh.common.util.date.DateUtils;
import com.fdh.common.util.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *  SysUserOnlineServiceImpl  在线用户记录实现类
 *
 *  @author fdh
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,isolation = Isolation.READ_UNCOMMITTED, readOnly = true)
public class SysUserOnlineServiceImpl implements SysUserOnlineService{
    @Autowired
    private SysUserOnlineDao sysUserOnlineDao;

    /**
     * 新增SysUserOnline
     * @param sysUserOnline
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void add(SysUserOnline sysUserOnline){
        Date date = new Date();
        sysUserOnline.setCreateDate(date);
        sysUserOnline.setUpdateDate(date);
        sysUserOnline.setIsValid(1);
        sysUserOnlineDao.insert(sysUserOnline);
    }

    /**
     * 根据主键 删除SysUserOnline (物理删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void delete(Long id){
        sysUserOnlineDao.delete(id);
    }

    /**
     * 根据主键 删除SysUserOnline (逻辑删除)
     * @param id
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void remove(Long id){
        SysUserOnline sysUserOnline = new SysUserOnline();
        sysUserOnline.setId(id);
        sysUserOnline.setIsValid(0);
        sysUserOnline.setUpdateDate(new Date());
        sysUserOnlineDao.update(sysUserOnline);
    }

    /**
     * 修改SysUserOnline
     * @param sysUserOnline
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void modify(SysUserOnline sysUserOnline){
        sysUserOnline.setUpdateDate(new Date());
        sysUserOnlineDao.update(sysUserOnline);
    }

    /**
     * 根据主键查询SysUserOnline
     * @param id
     * @return sysUserOnline
     */
    @Override
    public SysUserOnline queryOne(Long id){
        return sysUserOnlineDao.queryOne(id);
    }

    /**
     * 根据主键查询SysUserOnline
     * @return sysUserOnlines
     */
    @Override
    public List<SysUserOnline> queryAll(){
        return sysUserOnlineDao.queryAll();
    }

    /**
     * 根据字段查询（如需分页请setPageBean）
     * @param sysUserOnline
     * @return sysUserOnlines
     */
    @Override
    public List<SysUserOnline> queryByFieldsAndPage(SysUserOnline sysUserOnline){
        return sysUserOnlineDao.queryByFieldsAndPage(sysUserOnline);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void batchRemove(Long[] ids) {
        sysUserOnlineDao.batchRemove(ids);
    }

    /**
     * 批量修改状态
     * @param ids 修改的ids
     * @param status 修改的状态
     */
    @Override
    public void batchModifyStatus(Long[] ids, Integer status) {
        sysUserOnlineDao.batchModifyStatus(ids,status);
    }

    /**
     * 查询会话集合
     *
     * @param expiredDate 失效日期
     */
    @Override
    public List<SysUserOnline> selectOnlineByExpired(Date expiredDate) {
        String lastAccessTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, expiredDate);
        return sysUserOnlineDao.selectOnlineByExpired(lastAccessTime);
    }

    /**
     * 通过会话序号删除信息
     *
     * @param sessions 会话ID集合
     * @return 在线用户信息
     */
    @Override
    public void batchDeleteOnline(List<String> sessions) {
        SysUserOnlineService sysUserOnlineService = SpringUtils.getBean(SysUserOnlineService.class);
        for (String sessionId : sessions) {
            SysUserOnline userOnline = sysUserOnlineService.selectOnlineBySessionId(sessionId);
            if (null != userOnline) {
                sysUserOnlineService.remove(userOnline.getId());
            }
        }
    }

    /**
     * 根据绘画id查询用户状态信息
     *
     * @param sessionId
     * @return
     */
    @Override
    public SysUserOnline selectOnlineBySessionId(String sessionId) {
        return sysUserOnlineDao.selectOnlineBySessionId(sessionId);
    }

    /**
     * 通过会话序号删除信息
     *
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    @Override
    public void deleteOnlineBySessionId(String sessionId) {
        SysUserOnlineService sysUserOnlineService = SpringUtils.getBean(SysUserOnlineService.class);
        SysUserOnline userOnline = sysUserOnlineService.selectOnlineBySessionId(sessionId);
        if (null != userOnline) {
            sysUserOnlineDao.deleteOnlineBySessionId(sessionId);
        }
    }
}