package com.fdh.business.modules.sysuser.service;

import com.fdh.business.modules.per.exception.UserException;
import com.fdh.business.modules.sysuser.dao.SysUserDao;
import com.fdh.business.modules.sysuser.entity.SysUser;
import com.fdh.common.constants.Constants;
import com.fdh.common.util.ServletUtil;
import com.fdh.common.util.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *  SysUserServiceImpl  用户信息表实现类
 *
 *  @author fdh
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,isolation = Isolation.READ_UNCOMMITTED, readOnly = true)
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 新增SysUser
     *
     * @param sysUser
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public void add(SysUser sysUser) {
        Date date = new Date();
        sysUser.setCreateDate(date);
        sysUser.setUpdateDate(date);
        sysUser.setIsValid(1);
        sysUserDao.insert(sysUser);
    }

    /**
     * 根据主键 删除SysUser (物理删除)
     *
     * @param id
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public void delete(Long id) {
        sysUserDao.delete(id);
    }

    /**
     * 根据主键 删除SysUser (逻辑删除)
     *
     * @param id
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public void remove(Long id) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setIsValid(0);
        sysUser.setUpdateDate(new Date());
        sysUserDao.update(sysUser);
    }

    /**
     * 修改SysUser
     *
     * @param sysUser
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public void modify(SysUser sysUser) {
        sysUser.setUpdateDate(new Date());
        sysUserDao.update(sysUser);
    }

    /**
     * 根据主键查询SysUser
     *
     * @param id
     * @return sysUser
     */
    @Override
    public SysUser queryOne(Long id) {
        return sysUserDao.queryOne(id);
    }

    /**
     * 根据主键查询SysUser
     *
     * @return sysUsers
     */
    @Override
    public List<SysUser> queryAll() {
        return sysUserDao.queryAll();
    }

    /**
     * 根据字段查询（如需分页请setPageBean）
     *
     * @param sysUser
     * @return sysUsers
     */
    @Override
    public List<SysUser> queryByFieldsAndPage(SysUser sysUser) {
        return sysUserDao.queryByFieldsAndPage(sysUser);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public void batchRemove(Long[] ids) {
        sysUserDao.batchRemove(ids);
    }

    /**
     * 批量修改状态
     *
     * @param ids    修改的ids
     * @param status 修改的状态
     */
    @Override
    public void batchModifyStatus(Long[] ids, Integer status) {
        sysUserDao.batchModifyStatus(ids, status);
    }

    /**
     * 用户登陆
     *
     * @param sysUser
     * @return
     */
    @Override
    public SysUser login (SysUser sysUser){
        String validateCode = (String) ServletUtil.getRequest().getAttribute(Constants.VERIFY_CODE);
        String sessionCode = (String) ServletUtil.getSession().getAttribute(Constants.VERIFY_CODE);
        if(StringUtil.isEmpty(validateCode)){
            throw new UserException("验证码为空");
        }
        if(!validateCode.equals(sessionCode)){
            throw new UserException("验证码错误");
        }
        if(StringUtil.isEmpty(sysUser.getUsername())){
            throw new UserException("用户名为空");
        }
        List<SysUser> users = sysUserDao.queryByUsername(sysUser.getUsername());
        if(StringUtil.isEmpty(users)){
            throw new UserException("用户名不存在");
        }
        SysUser user = users.get(0);
        String medPwd = DigestUtils.md5Hex(sysUser.getPassword() + user.getSalt());
        if(!user.getPassword().equals(medPwd)){
            throw new UserException("密码错误");
        }
        return user;
    }

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    @Override
    public SysUser queryByUsername(String username) {
        List<SysUser> users = sysUserDao.queryByUsername(username);
        if(StringUtil.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }

    /**
     * 根据手机号查询用户
     *
     * @param phone
     * @return
     */
    @Override
    public SysUser queryByPhone(String phone) {
        List<SysUser> users = sysUserDao.queryByPhone(phone);
        if(StringUtil.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }

    /**
     * 根据邮箱查询用户
     *
     * @param email
     * @return
     */
    @Override
    public SysUser queryByEmail(String email) {
        List<SysUser> users = sysUserDao.queryByEmail(email);
        if(StringUtil.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }
}