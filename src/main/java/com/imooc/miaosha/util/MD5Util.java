package com.imooc.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @ClassName MD5Util
 * @Description MD5加密工具类
 * @Author Yunlong
 * @Date 2019/8/25 14:07
 * @Version 1.0
 */
public class MD5Util {

    private static final String salt = "1a2b3c4d";

    public static String inputPassToFormPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     * 将客户端输入的密码转为数据库存储的密码
     *
     * @param input  客户端输入密码
     * @param saltDB 数据库密码加密的盐值
     * @return 数据库密码
     */
    public static String inputPassToDbPass(String input, String saltDB) {
        String formPass = inputPassToFormPass(input);
        return formPassToDBPass(formPass, saltDB);
    }

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

}
