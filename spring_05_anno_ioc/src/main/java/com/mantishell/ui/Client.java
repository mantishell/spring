package com.mantishell.ui;

import com.mantishell.dao.IAccountDao;
import com.mantishell.service.IAccountService;
import com.mantishell.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService as = (IAccountService) ac.getBean("accountService");
        //IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        //System.out.println(as);
        //System.out.println(adao);
        as.saveAccount();
    }
}
