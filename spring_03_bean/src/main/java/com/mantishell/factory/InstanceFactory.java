package com.mantishell.factory;

import com.mantishell.service.IAccountService;
import com.mantishell.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类
 * 此工厂创建对象，必须先有工厂实例对象，再调用方法
 */
public class InstanceFactory {
    public IAccountService createAccountService(){
        return new AccountServiceImpl();
    }
}
