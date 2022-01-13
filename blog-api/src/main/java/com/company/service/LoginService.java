package com.company.service;

import com.company.dao.pojo.SysUser;
import com.company.vo.Result;
import com.company.vo.params.LoginParam;

/**
 * @author zytwl
 */

public interface LoginService {
    /**
     * 登录
     * @param loginParam
     * @return
     * @author wanglin
     */
    Result login(LoginParam loginParam);

    /**
     * 检验Token是否存在
     * @param token
     * @return
     * @author wanglin
     */
    SysUser checkToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     * @author wanglin
     */
    Result logout(String token);

    /**
     * 注册
     * @param loginParam
     * @return
     * @author wanglin
     */
    Result register(LoginParam loginParam);
}
