package com.ynjabo77.jaboapiclientsdk.apiservice;

/**
 * @author enen
 * @date 2024/6/30
 */
public interface JaboApiService {

    /**
     * 封装发起请求
     *
     * @param restfulUrl 地址
     * @param arg        参数
     * @param <T>        参数
     * @return 请求结果
     */
    <T> String definitionRequest(String restfulUrl, T arg);
}
