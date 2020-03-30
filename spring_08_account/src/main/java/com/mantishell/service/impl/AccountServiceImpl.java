package com.mantishell.service.impl;

import com.mantishell.dao.IAccountDao;
import com.mantishell.domain.Account;
import com.mantishell.service.IAccountService;
import com.mantishell.utils.TransactionManager;

/**
 * 事务控制应该都是在业务层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao){
        this.accountDao = accountDao;
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void transfer(String sourceName, String destName, Float money) {
        /*Account source = accountDao.findAccountByName(sourceName);
        Account dest = accountDao.findAccountByName(destName);
        source.setMoney(source.getMoney()-money);
        dest.setMoney(dest.getMoney()+money);
        accountDao.updateAccount(source);
        int a = 10/0;
        accountDao.updateAccount(dest);*/

        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            //2.1根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2根据名称查询转入账户
            Account dest = accountDao.findAccountByName(destName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4转入账户加钱
            dest.setMoney(dest.getMoney()+money);
            //2.5更新转出账户
            accountDao.updateAccount(source);

            int i=1/0;

            //2.6更新转入账户
            accountDao.updateAccount(dest);
            //3.提交事务
            txManager.commit();

        }catch (Exception e){
            //4.回滚操作
            txManager.rollback();
            e.printStackTrace();
        }finally {
            //5.释放连接
            txManager.release();
        }
    }
}
