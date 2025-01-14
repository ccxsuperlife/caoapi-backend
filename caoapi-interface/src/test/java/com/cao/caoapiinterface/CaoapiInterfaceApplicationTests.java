package com.cao.caoapiinterface;

import com.cao.caoapiclientsdk.client.CaoApiClient;
import com.cao.caoapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CaoapiInterfaceApplicationTests {

    @Resource
    private CaoApiClient caoApiClient;

    @Test
    void contextLoads() {
        String result = caoApiClient.getNameByPost("xiaocao");
        User user = new User();
        user.setUsername("xiaocao");
        String resul2 = caoApiClient.getUserNameByPost(user);
        System.out.println(resul2);

    }

}
