package com.ynjabo77.jaboapiclientsdk.strategy;

import com.ynjabo77.jaboapiclientsdk.apiservice.JaboApiService;
import com.ynjabo77.jaboapiclientsdk.constant.JaboApiUrl;
import com.ynjabo77.jaboapiclientsdk.strategy.impl.HoroscopeStrategy;
import com.ynjabo77.jaboapiclientsdk.strategy.impl.NameStrategy;
import com.ynjabo77.jaboapiclientsdk.strategy.impl.Present;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 策略核心上下文类
 *
 * @author enen
 * @date 2024/6/30
 */
public class BaseContext {
    private static final Map<String, BaseStrategy> strategyMap = new ConcurrentHashMap<>();

    private JaboApiService jaboApiService;

    private static final Present PRESENT = new Present();

    static {
        strategyMap.put(JaboApiUrl.USERNAME_POST, new NameStrategy());
        strategyMap.put(JaboApiUrl.HOROSCOPE, new HoroscopeStrategy());
        strategyMap.put(JaboApiUrl.MO_YU, PRESENT);
        strategyMap.put(JaboApiUrl.RANDOM_SCENERY, PRESENT);
        strategyMap.put(JaboApiUrl.RANDOM_WALLPAPER, PRESENT);
    }

    public String handler(String restfulUrl, String params) {
        BaseStrategy baseStrategy = strategyMap.get(restfulUrl);
        return baseStrategy.handlerRequest(restfulUrl, params, jaboApiService);
    }

    public void setJaboApiClient(JaboApiService jaboApiService) {
        this.jaboApiService = jaboApiService;
    }
}
