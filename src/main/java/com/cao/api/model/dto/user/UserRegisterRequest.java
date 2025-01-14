package com.cao.api.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author xiaocao
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -5042026885880421420L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
