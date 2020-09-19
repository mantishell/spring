package com.mantishell.proxy;

/**
 * 对成产厂家要求的接口
 */
public interface IProducer {

    /**
     * 销售
     * @param money
     */
    void saleProduct(float money);

    /**
     * 售后
     * @param money
     */
    void afterService(float money);
}


