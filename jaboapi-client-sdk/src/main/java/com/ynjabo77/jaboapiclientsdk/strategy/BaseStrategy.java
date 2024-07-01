package com.ynjabo77.jaboapiclientsdk.strategy;

import com.ynjabo77.jaboapiclientsdk.apiservice.JaboApiService;

/**
 * 抽出公有方法
 *
 * @author enen
 * @date 2024/6/30
 */
public interface BaseStrategy {
    String handlerRequest(String restfulUrl, String params, JaboApiService apiService);
}
