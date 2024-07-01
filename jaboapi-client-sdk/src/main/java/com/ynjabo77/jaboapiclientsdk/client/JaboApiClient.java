package com.ynjabo77.jaboapiclientsdk.client;

import lombok.Data;


/**
 * 调用第三方接口的客户端
 */
@Data
public class JaboApiClient {

    private String accessKey;

    private String secretKey;

    public JaboApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }
}
