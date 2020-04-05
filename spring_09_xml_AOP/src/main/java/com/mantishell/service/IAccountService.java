package com.mantishell.service;

/**
 * 模拟账户的业务接口
 */
public interface IAccountService {

    void saveAccount();

    void updateAccount(int i);

    int deleteAccount();
}
