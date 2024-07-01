package com.ynjabo77.jaboapiclientsdk.constant;

/**
 * 地址常量
 *
 * @author enen
 * @date 2024/6/30
 */
public interface JaboApiUrl {
    /**
     * 网关
     */
    // todo 修改为线上地址
    String GATEWAY_HOST = "http://localhost:8090";

    /**
     * 测试
     */
    String USERNAME_POST = "/api/ynjabo77/user";

    /**
     * 获取随机风景图片
     */
    String RANDOM_SCENERY = "/api/ynjabo77/getRandomScenery";

    /**
     * 获取摸鱼日历
     */
    String MO_YU = "/api/ynjabo77/getMoYu";

    /**
     * 获取随机壁纸
     */
    String RANDOM_WALLPAPER = "/api/ynjabo77/getRandomWallpaper";

    /**
     * 获取星座运势
     */
    String HOROSCOPE = "/api/ynjabo77/getHoroscope";
}
