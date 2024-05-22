package com.ynjabo77.jaboapiinterface;

import com.ynjabo77.jaboapiclientsdk.client.JaboApiClient;
import com.ynjabo77.jaboapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class JaboapiInterfaceApplicationTests {

    @Resource
    private JaboApiClient jaboApiClient;

    @Test
    void contextLoads() {
        String string = jaboApiClient.getNameByGet("enen");
        User user = new User();
        user.setName("enen");
        String usernameByPost = jaboApiClient.getUsernameByPost(user);
        System.out.println(string);
        System.out.println(usernameByPost);

    }

}
