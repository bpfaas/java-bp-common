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
public class BpException extends Exception {
    private static final long serialVersionUID = -1259159488039971417L;

    public BpException() {
        super();
    }

    public BpException(String message) {
        super(message);
    }

    public BpException(String message, Throwable cause) {
        super(message, cause);
    }

    public BpException(Throwable cause) {
        super(cause);
    }
}
