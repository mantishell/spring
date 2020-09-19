package com.mantishell.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object rtn = null;
                Float money = (Float)args[0];
                if("saleProduct".equals(method.getName())){
                    rtn = method.invoke(producer, money * 0,6f);
                }
                return rtn;
            }
        });
        cglibProducer.saleProduct(12000f);
    }
}
