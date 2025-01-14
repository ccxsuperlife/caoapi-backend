package com.cao.caoapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.cao.caoapiclientsdk.model.User;
import com.cao.caoapiclientsdk.utils.SignUtils;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.HashMap;
import java.util.Map;

/**
 * 调用第三方接口的客户端
 */
@Data
@AllArgsConstructor
public class CaoApiClient {

    private String accessKey;

    private String secretKey;

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    //构造一个私有方法，构造请求头
    public Map<String, String> getHeaderMap(String body) {
        //构造一个HashMap对象
        HashMap<String, String> paramMap = new HashMap<>();
        //用户的标识
        paramMap.put("accesskey", accessKey);
        paramMap.put("body", body);
        //不能在服务器之间传递secretkey
//        paramMap.put("secretkey", secretKey);
        //生成一个4位数的随机数
        paramMap.put("nonce", RandomUtil.randomNumbers(4));
        //获取当前时间的秒数
        paramMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        //生成签名。用户参数 + 密钥 => 签名生成算法 => 签名
        paramMap.put("sign", SignUtils.sign(body, secretKey));
        return paramMap;
    }

    public String getUserNameByPost(User user) {
        //将User对象转换为JSON字符串
        String json = JSONUtil.toJsonStr(user);
        // 使用HttpRequest工具发送POST请求，并获取服务器的相应
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/user/")
                .body(json) //将JSON字符串转换为请求体
                .addHeaders(getHeaderMap(json)) //添加请求头
                .execute(); //执行请求
        //打印服务器返回的状态码
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
}
