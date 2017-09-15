/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadow.foretaste.dao;

import com.shadow.foretaste.entity.Account;

/**
 *
 * @author sunny
 */
public interface AccountDao {
    /**
     * 插入账户信息
     * @param account
     * @return 
     */
    Account insertAccount(Account account);
}
