/**
 * Copyright (c) 2020 Copyright bp All Rights Reserved.
 * Author: lipengxiang
 * Date: 2020-2020/7/1 16:51
 * Desc:
 */
package com.bpfaas.common.exception;

/**
 * Json parse and stringify Exception
 *
 * @author pengxiang.li
 * @date 2020/7/1 4:51 下午
 */
public class BpJsonException extends BpException {
    private static final long serialVersionUID = -5996617354987319003L;

    public BpJsonException() {
        super();
    }

    public BpJsonException(String message) {
        super(message);
    }

    public BpJsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public BpJsonException(Throwable cause) {
        super(cause);
    }
}
