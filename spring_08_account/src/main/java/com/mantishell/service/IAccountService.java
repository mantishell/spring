package com.mantishell.service;

import com.mantishell.domain.Account;

/**
 * 业务层接口
 */
public interface IAccountService {
    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 转账
     * @param sourceName        转出账户名称
     * @param destName          转入账户名称
     * @param money             转账金额
     */
    void transfer(String sourceName,String destName,Float money);
}
