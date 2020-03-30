package com.mantishell.dao;

import com.mantishell.domain.Account;
/**
 * 持久层接口
 */
public interface IAccountDao {

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return 如果有唯一的一个结果就返回，如果没有结果就返回null
     *          如果结果集超过一个就抛异常
     */
    Account findAccountByName(String accountName);
}
