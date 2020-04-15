package com.mantishell.dao;

import com.mantishell.domain.Account;

public interface IAccountDao {
    Account findAccountById(Integer accountId);
    Account findAccountByName(String accountName);
    void updateAccount(Account account);
}
