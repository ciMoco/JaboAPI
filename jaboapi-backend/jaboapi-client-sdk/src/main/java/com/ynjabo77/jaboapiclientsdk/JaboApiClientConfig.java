package com.ynjabo77.jaboapiclientsdk;

import com.ynjabo77.jaboapiclientsdk.client.JaboApiClient;
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

    private String accessKey;

    private String secretKey;

    @Bean
    public JaboApiClient jaboApiClient() {
        return new JaboApiClient(accessKey,secretKey);
    }
}
