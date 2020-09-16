/**
 * Copyright (c) 2020 Copyright bp All Rights Reserved.
 * Author: lipengxiang
 * Date: 2020-2020/7/1 16:51
 * Desc:
 */
package com.bpfaas.common.exception;

/**
 * Method not found exception
 *
 * @author pengxiang.li
 * @date 2020/7/1 4:51 下午
 */
public class NotFoundException extends FaasRuntimeException {
    private static final long serialVersionUID = 4773921674738374416L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
