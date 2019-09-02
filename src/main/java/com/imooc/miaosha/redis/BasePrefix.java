package com.imooc.miaosha.redis;

/**
 * @ClassName BasePrefix
 * @Description TODO
 * @Author Yunlong
 * @Date 2019/8/24 11:16
 * @Version 1.0
 */
public abstract class BasePrefix implements IKeyPrefix {
    private int expireSeconds;// 缓存有效期
    private String prefix;// key前缀

    /**
     * 默认0代表永不过期
     *
     * @param prefix
     */
    public BasePrefix(String prefix) {
        this(0, prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
