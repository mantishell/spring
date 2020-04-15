package com.mantishell.jdbctemplate;

import com.mantishell.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/db4");
        ds.setUsername("root");
        ds.setPassword("123456");

        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert into account(name,money)values('张三',1000)");
        //保存
        //jt.update("insert into account(name,money)values(?,?)", "李四", 100);
        //更新
        //jt.update("update account set money=money-? where id=?",3,100);
        //删除
        //jt.update("delete from account where id=?",3);
        //查询所有
        //List<Account> accounts = jt.query("select * from account where money>?", new AccountRowMapper(), 500f);
        //查询所有简化版,不用写RowMapper的实现类
        //List<Account> accounts = jt.query("select * from account where money>?", new BeanPropertyRowMapper<Account>(Account.class),500f);
        //for (Account account : accounts) {
        //    System.out.println(account);
        //}
        //查询一个
        List<Account> accounts = jt.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));

        //查询返回一行一列（使用聚合函数，但不加group by子句）
        Long count = jt.queryForObject("select count(*) from account where money > ?",Long.class,1000f);
        System.out.println(count);
    }
}

class AccountRowMapper implements RowMapper<Account>{
    //把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}