package com.mantishell.ui;

import com.mantishell.factory.BeanFactory;
import com.mantishell.service.IAccountService;
import com.mantishell.service.impl.AccountServiceImpl;

public class Client {

    public static void main(String[] args) {
        //IAccountService as = new AccountServiceImpl();
        for (int i = 0;i < 5; i++){
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
        }
    }
}
