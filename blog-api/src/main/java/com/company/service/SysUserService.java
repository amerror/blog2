package com.company.service;

import com.company.dao.pojo.SysUser;
import com.company.vo.Result;
import com.company.vo.UserVo;

/**
 * @author zytwl
 */
public interface SysUserService {
    /**
     *通过作者id获取到作者信息
     * @param id
     * @return
     * @author wanglin
     */
    SysUser findUserById(Long id);

    /**
     * 用账号密码查找响应用户
     * @param account
 * @param password
     * @return
     * @author wanglin
     */
    SysUser findUser(String account, String password);

    /**
     *通过token找用户
     * @param token
     * @return
     * @author wanglin
     */
    Result findUserByToken(String token);

    /**
     * 通过账号查找
     * @param account
     * @return
     * @author wanglin
     */
    SysUser findUserByAccount(String account);

    /**
     * 保存
     * @param sysUser
     * @return
     * @author wanglin
     */
    void save(SysUser sysUser);

    /**
     * 1
     * @param id
     * @return
     * @author wanglin
     */
    UserVo findUserVoById(Long id);
}
