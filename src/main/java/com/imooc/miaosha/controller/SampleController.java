package com.imooc.miaosha.controller;

import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.redis.UserKey;
import com.imooc.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName SampleController
 * @Description TODO
 * @Author Yunlong
 * @Date 2019/8/22 20:35
 * @Version 1.0
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    /**
     * thymeleaf模板引擎测试
     *
     * @param model
     * @return
     */
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "Jack");
        return "hello";
    }

    /**
     * 数据库查询测试
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/db/get")
    public Object dbGet() {
        User user = userService.getById(1);
        return user;
    }

    /**
     * 数据库事务测试
     *
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping("/db/tx")
    public Object dbTx() {
        User u1 = new User(4, "bac");
        userService.insert(u1);
        User u2 = new User(1, "jksa");
        userService.insert(u2);
        return true;
    }

    /**
     * redis GET方法测试
     *
     * @return
     */
    @RequestMapping("/redis/get")
    @ResponseBody
    public Object redisGet() {
        User user = redisService.get(UserKey.getById, "1", User.class);
        return user;
    }

    /**
     * redis SET方法测试
     *
     * @return
     */
    @RequestMapping("/redis/set")
    @ResponseBody
    public Object redisSet() {
        User user = new User(1, "11111");
        redisService.set(UserKey.getById, "1", user);
        return true;
    }


}
