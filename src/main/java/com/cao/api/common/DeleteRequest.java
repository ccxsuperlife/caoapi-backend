package com.cao.api.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 *
 * @author xiaocao
 */
@Data
public class DeleteRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = -8811727432772902098L;
}