
package com.shadow.foretaste.dao;

import com.shadow.foretaste.entity.UserInfo;

/**
 *
 * @author sunny
 */
public interface UserInfoDao {
    
    /**
     * 根据Id查询用户信息
     * @param id
     * @return 
     */
    UserInfo getUserInfoById(int id);
    /**
     * 插入一条语句
     * @param userInfo
     * @return 
     */
    UserInfo insertUser(UserInfo userInfo);
    /**
     * 根据i的获取手机号
     * @param id
     * @return 
     */
    String getPhoneNum(int id);
    /**
     * 获取用户信息和账户信息
     * @param id
     * @return 
     */
    UserInfo getInfoAndAccount(int id);
}
