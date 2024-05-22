package com.ynjabo77.jaboapiinterface.controller;

import com.ynjabo77.jaboapiclientsdk.model.User;
import com.ynjabo77.jaboapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称 API
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name) {
        return "get 你的名字，我猜是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "post 你的名字，我猜是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        // todo 数据库查是否分配用户
        if (!accessKey.equals("enen")) {
            throw new RuntimeException("你没资格，滚");
        }
        // todo 从数据库查secretKey
        String serverSign = SignUtils.genSign(body, "enen");
        if (!sign.equals(serverSign)) {
            throw new RuntimeException("你没资格滚");
        }
        return "post 用户的名字，我猜是" + user.getName();
    }
}
