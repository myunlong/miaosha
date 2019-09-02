package com.imooc.miaosha.redis;

/**
 * @ClassName UserKey
 * @Description 定义用户模块的key
 * @Author Yunlong
 * @Date 2019/8/24 11:22
 * @Version 1.0
 */
public class UserKey extends BasePrefix {

    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");

}
