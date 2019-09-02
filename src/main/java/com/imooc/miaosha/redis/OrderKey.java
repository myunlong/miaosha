package com.imooc.miaosha.redis;

/**
 * @ClassName OrderKey
 * @Description 定义订单模块的key
 * @Author Yunlong
 * @Date 2019/8/24 11:24
 * @Version 1.0
 */
public class OrderKey extends BasePrefix {

    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
