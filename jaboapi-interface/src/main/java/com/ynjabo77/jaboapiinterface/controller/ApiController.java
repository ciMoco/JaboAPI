package com.ynjabo77.jaboapiinterface.controller;

import com.ynjabo77.jaboapiclientsdk.model.params.HoroscopeParams;
import com.ynjabo77.jaboapiclientsdk.model.params.UserParams;
import com.ynjabo77.jaboapiinterface.service.MyInterfaceApiService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * API
 */
@RestController
@RequestMapping(value = "/ynjabo77")
public class ApiController {

    @Resource
    MyInterfaceApiService myInterfaceApiService;

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody UserParams user) {
        return "post 用户名字是" + user.getName();
    }

    @PostMapping("/getRandomScenery")
    public String getRandomScenery() {
        return myInterfaceApiService.getRandomScenery();
    }

    @PostMapping("/getMoYu")
    public String getMoYu() {
        return myInterfaceApiService.getMoYu();
    }

    @PostMapping("/getRandomWallpaper")
    public String getRandomWallpaper() {
        return myInterfaceApiService.getRandomWallpaper();
    }

    @PostMapping("/getHoroscope")
    public String getHoroscope(@RequestBody HoroscopeParams horoscopeParams) {
        return myInterfaceApiService.getHoroscope(horoscopeParams);
    }
}
