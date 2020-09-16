/**
 * Copyright (c) 2020 Copyright bp All Rights Reserved.
 * Author: lipengxiang
 * Date: 2020-2020/7/1 16:51
 * Desc:
 */
package com.bpfaas.common.exception;

/**
 * @author pengxiang.li
 * @date 2020/7/1 4:51 下午
 */
public class FaasRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -1253151488039971417L;

    public FaasRuntimeException() {
        super();
    }

    public FaasRuntimeException(String message) {
        super(message);
    }

    public FaasRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FaasRuntimeException(Throwable cause) {
        super(cause);
    }
}
