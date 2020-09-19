package com.mantishell.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
        /**
         * 动态代理：
         * 特点：字节码随用随创建，随用随加载
         * 作用：不修改源码的基础上对方法增强
         * 分类：
         *  基于接口的动态代理
         *      涉及的类：Proxy
         *      提供者：JDK官方
         *      如何创建代理对象：
         *          使用Proxy类中的newProxyInstance方法
         *              参数有：
         *              ClassLoader:
         *                  用于加载代理对象字节码，和被代理对象使用相同的类加载器。
         *              Class[]:字节码数组
         *                  用于让代理对象和被代理对象有相同的方法
         *              InvocationHandler: 增强的代码
         *                  一般写该接口的实现类，通常是匿名内部类
         *      创建代理对象的要求：
         *          被代理类至少实现一个接口，如果没有则不能使用
         *  基于子类的动态代理
         *      涉及的类：Enhancer
         *      提供者：第三方cglib库
         *      被代理对象的要求；不能是最终类
         *      create方法参数：
         *          Class：字节码
         *              用于指定被代理对象的字节码
         *          Callback：用于提供增强的代码
         *              一般写该接口的子接口实现类：MethodInterceptor
         *
         */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 作用：执行被代理对象的任何接口方法都会经过该方法
             * @param proxy 代理对象的引用
             * @param method 当前执行的方法
             * @param args 当前执行方法所需的参数
             * @return 被代理对象方法的返回值
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtn = null;
                //1 获取方法执行的参数
                Float money = (Float)args[0];
                //2 判断当前方法是不是销售
                if("saleProduct".equals(method.getName())){
                    rtn = method.invoke(producer, money * 0.6f);
                }
                return rtn;
            }
        });

        proxyProducer.saleProduct(1000);
    }
}
