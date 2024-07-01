package com.ynjabo77.jaboapiclientsdk.strategy.impl;

import com.ynjabo77.jaboapiclientsdk.apiservice.JaboApiService;
import com.ynjabo77.jaboapiclientsdk.strategy.BaseStrategy;

/**
 * @author enen
 * @date 2024/6/30
 */
public class Present implements BaseStrategy {

    @Override
    public String handlerRequest(String restfulUrl, String params, JaboApiService apiService) {
        return apiService.definitionRequest(restfulUrl, "");
    }
}
