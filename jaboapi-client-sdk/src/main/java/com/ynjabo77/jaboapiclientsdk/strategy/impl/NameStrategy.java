package com.ynjabo77.jaboapiclientsdk.strategy.impl;

import com.google.gson.Gson;
import com.ynjabo77.jaboapiclientsdk.apiservice.JaboApiService;
import com.ynjabo77.jaboapiclientsdk.constant.ResponseResult;
import com.ynjabo77.jaboapiclientsdk.model.params.UserParams;
import com.ynjabo77.jaboapiclientsdk.strategy.BaseStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Post 请求测试接口
 *
 * @author enen
 * @date 2024/6/30
 */
@Slf4j
public class NameStrategy implements BaseStrategy {

    @Override
    public String handlerRequest(String restfulUrl, String params, JaboApiService apiService) {
        log.info("url = {}, params = {}", restfulUrl, params);
        Gson gson = new Gson();
        UserParams userParams = null;
        if (StringUtils.isBlank(params)) {
            return ResponseResult.BASE_RESULT;
        }
        try {
            userParams = gson.fromJson(params, UserParams.class);
        } catch (Exception e) {
            log.error("转换json出现异常，错误为：{}，输入参数为：{}", e.getMessage(), params);
            return ResponseResult.BASE_RESULT;
        }
        return apiService.definitionRequest(restfulUrl, userParams);
    }
}
