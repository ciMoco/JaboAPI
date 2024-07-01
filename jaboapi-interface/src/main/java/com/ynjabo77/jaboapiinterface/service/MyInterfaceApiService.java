package com.ynjabo77.jaboapiinterface.service;

import com.ynjabo77.jaboapiclientsdk.model.params.HoroscopeParams;

/**
 * @author enen
 * @date 2024/6/30
 */
public interface MyInterfaceApiService {

    /**
     * 获取随机风景图片
     */
    String getRandomScenery();

    /**
     * 获取摸鱼日历
     */
    String getMoYu();

    /**
     * 获取随机壁纸
     */
    String getRandomWallpaper();

    /**
     * 获取星座运势
     * @param horoscopeParams 星座
     */
    String getHoroscope(HoroscopeParams horoscopeParams);
}
