package com.ynjabo77.jaboapiclientsdk.strategy.impl;

import com.google.gson.Gson;
import com.ynjabo77.jaboapiclientsdk.apiservice.JaboApiService;
import com.ynjabo77.jaboapiclientsdk.constant.ResponseResult;
import com.ynjabo77.jaboapiclientsdk.model.params.HoroscopeParams;
import com.ynjabo77.jaboapiclientsdk.strategy.BaseStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Post 请求星座接口
 *
 * @author enen
 * @date 2024/6/30
 */
@Slf4j
public class HoroscopeStrategy implements BaseStrategy {

    @Override
    public String handlerRequest(String restfulUrl, String params, JaboApiService apiService) {
        log.info("url = {}, params = {}", restfulUrl, params);
        Gson gson = new Gson();
        HoroscopeParams horoscopeParams = null;
        if (StringUtils.isBlank(params)) {
            return ResponseResult.BASE_RESULT;
        }
        try {
            horoscopeParams = gson.fromJson(params, HoroscopeParams.class);
        } catch (Exception e) {
            log.error("转换json出现异常，错误为：{}，输入参数为：{}", e.getMessage(), params);
            return ResponseResult.BASE_RESULT;
        }
        return apiService.definitionRequest(restfulUrl, horoscopeParams);
    }
}
