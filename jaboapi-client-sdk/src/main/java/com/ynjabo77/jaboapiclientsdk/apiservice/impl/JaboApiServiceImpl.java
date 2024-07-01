package com.ynjabo77.jaboapiclientsdk.apiservice.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.ynjabo77.jaboapiclientsdk.apiservice.JaboApiService;
import com.ynjabo77.jaboapiclientsdk.client.JaboApiClient;
import com.ynjabo77.jaboapiclientsdk.common.ErrorCode;
import com.ynjabo77.jaboapiclientsdk.constant.JaboApiUrl;
import com.ynjabo77.jaboapiclientsdk.exception.BusinessException;
import com.ynjabo77.jaboapiclientsdk.utils.SignUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author enen
 * @date 2024/6/30
 */
@Data
@Slf4j
public class JaboApiServiceImpl implements JaboApiService {

    private static final String GATEWAY_HOST = JaboApiUrl.GATEWAY_HOST;

    private JaboApiClient jaboApiClient;

    /**
     * 封装请求头
     *
     * @param body 请求参数
     * @return 请求头Map
     */
    private Map<String, String> getHeaderMap(String body) {
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("accessKey", jaboApiClient.getAccessKey());
        headerMap.put("nonce", RandomUtil.randomNumbers(4));
        try {
            headerMap.put("body", URLEncoder.encode(body, StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("加密传递参数出错，异常信息为：{}", e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "加密传递参数出错");
        }
        headerMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        headerMap.put("sign", SignUtils.genSign(body, jaboApiClient.getSecretKey()));
        return headerMap;
    }

    private <T> String getJson(T arg) {
        return JSONUtil.toJsonStr(arg);
    }

    /**
     * 封装发起请求
     *
     * @param restfulUrl RESTFUL风格请求路径
     * @param arg        参数
     * @param <T>        参数
     * @return 响应结果
     */
    @Override
    public <T> String definitionRequest(String restfulUrl, T arg) {
        String json = getJson(arg);
        HttpResponse response = HttpRequest.post(GATEWAY_HOST + restfulUrl)
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute()
                .charset(StandardCharsets.UTF_8);
        String result = response.body();
        log.info("SDK 返回状态为：{}", response.getStatus());
        log.info("SDK 返回结果为：{}", result);
        return result;
    }
}
