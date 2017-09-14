
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
}
