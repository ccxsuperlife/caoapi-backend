package com.cao.api.service.impl.inner;

import com.cao.api.mapper.InterfaceInfoMapper;
import com.cao.caoapicommon.model.entity.InterfaceInfo;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
public class InnerInterfaceInfoServiceImplTest {

    public static void main(String[] args) {
        InnerInterfaceInfoServiceImpl innerInterfaceInfoService = new InnerInterfaceInfoServiceImpl();
        InterfaceInfo post = innerInterfaceInfoService.getInterfaceInfo("http://localhost:8123/api/name/user", "POST");
        System.out.println(post);
    }
}