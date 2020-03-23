package com.mantishell.service.impl;

import com.mantishell.dao.IAccountDao;
import com.mantishell.dao.impl.AccountDaoImpl;
import com.mantishell.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();
    public void saveAccount() {
        accountDao.saveAccount();

    }
}
