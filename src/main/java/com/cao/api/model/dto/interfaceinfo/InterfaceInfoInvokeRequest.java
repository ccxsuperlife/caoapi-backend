package com.cao.api.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口调用请求
 *
 * @TableName product
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户请求参数（不是接口信息的参数）
     */
    private String userRequestParams;

    private static final long serialVersionUID = 1L;
}
