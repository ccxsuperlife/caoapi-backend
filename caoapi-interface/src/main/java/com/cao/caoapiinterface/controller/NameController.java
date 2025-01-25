package com.cao.caoapiinterface.controller;

import com.cao.caoapiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称 API
 *
 * @author yupi
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name, HttpServletRequest request) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
        //从请求头中取出参数
//        request.setCharacterEncoding("utf-8");
//        String nonce = request.getHeader("nonce");
//        String accessKey = request.getHeader("accessKey");
//        String timestamp = request.getHeader("timestamp");

//        String sign = request.getHeader("sign");
//        String body = request.getHeader("body");
//        //不能从请求头中取出secretKey
//       String secretKey = request.getHeader("secretKey");
//        //权限校验
//        if (!accessKey.equals("xiaocao")) {
//            throw new RuntimeException("无权限");
//        }
//        if (Long.parseLong(nonce) > 10000) {
//            throw new RuntimeException("无权限");
//        }
//        String serverSign = SignUtils.sign(body, "abcdefgh");
//        if (!serverSign.equals(sign)) {
//            throw new RuntimeException("无权限");
//        }
        //权限通过，放行
        return "POST 你的名字是" + user.getUsername();
    }
}
