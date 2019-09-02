package com.imooc.miaosha.redis;

public interface IKeyPrefix {
    /**
     * @return 缓存有效期
     */
    int expireSeconds();

    /**
     * @return key的前缀
     */
    String getPrefix();
}
