package com.mantishell.dao.impl;

import com.mantishell.dao.IAccountDao;
import com.mantishell.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    public void setRunner(QueryRunner runner){
        this.runner = runner;
    }
    public List<Account> findAllAccount() {
        try{
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public Account findAccountById(Integer accountId) {
        try{
            return runner.query("select * from account where id = ? ",new BeanHandler<Account>(Account.class),accountId);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void saveAccount(Account account) {
        try{
            runner.update("insert into account(name, money) values(?,?)", account.getName(), account.getMoney());
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void updateAccount(Account account) {
        try{
            runner.update("update account set name=?,money=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            runner.update("delete from account where id=?",accountId);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
