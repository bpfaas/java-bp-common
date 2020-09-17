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
public class BpNotFoundException extends BpRuntimeException {
    private static final long serialVersionUID = 4773921674738374416L;

    public BpNotFoundException() {
        super();
    }

    public BpNotFoundException(String message) {
        super(message);
    }

    public BpNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BpNotFoundException(Throwable cause) {
        super(cause);
    }
}
