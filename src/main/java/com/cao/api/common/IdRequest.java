package com.cao.api.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口信息状态请求
 *
 * @author xiaocao
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = -1916997012943795523L;
}