package com.cao.api.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author xiaocao
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 1403552054686480272L;

    private String userAccount;

    private String userPassword;
}
