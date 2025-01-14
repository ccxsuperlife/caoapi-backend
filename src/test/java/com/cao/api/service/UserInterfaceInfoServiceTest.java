package com.cao.api.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class UserInterfaceInfoServiceTest {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Test
    public void invokeCount() {
        Assert.assertTrue(userInterfaceInfoService.invokeCount(1, 1));

    }
}