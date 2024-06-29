package com.ynjabo77.jaboapiinterface.controller;

import com.ynjabo77.jaboapiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * 名称 API
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name) {
        return "get 你的名字，我猜是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "post 你的名字，我猜是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user) {
        return "post 用户名字是" + user.getName();
    }
}
