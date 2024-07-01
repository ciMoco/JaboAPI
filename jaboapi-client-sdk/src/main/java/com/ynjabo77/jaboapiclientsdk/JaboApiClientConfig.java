package com.ynjabo77.jaboapiclientsdk;

import com.ynjabo77.jaboapiclientsdk.apiservice.impl.JaboApiServiceImpl;
import com.ynjabo77.jaboapiclientsdk.client.JaboApiClient;
import com.ynjabo77.jaboapiclientsdk.strategy.BaseContext;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("jaboapi.client")
@Data
@ComponentScan
public class JaboApiClientConfig {

    /**
     * 公钥
     */
    private String accessKey;

    /**
     * 私钥
     */
    private String secretKey;

    @Bean
    public BaseContext baseContext() {
        JaboApiServiceImpl jaboApiService = new JaboApiServiceImpl();
        jaboApiService.setJaboApiClient(new JaboApiClient(accessKey,secretKey));
        BaseContext baseContext = new BaseContext();
        baseContext.setJaboApiClient(jaboApiService);
        return baseContext;
    }
}
