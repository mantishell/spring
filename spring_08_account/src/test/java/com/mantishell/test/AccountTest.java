package com.mantishell.test;

import com.mantishell.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountTest {
    @Autowired
//    @Qualifier("proxyAccountService")
    private IAccountService as;

    @Test
    public void testTransfer(){
        as.transfer("小王","小张",100f);
    }
}
