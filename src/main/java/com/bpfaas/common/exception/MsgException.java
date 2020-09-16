/**
 * Copyright (c) 2020 Copyright bp All Rights Reserved.
 * Author: lipengxiang
 * Date: 2020-2020/7/1 16:51
 * Desc:
 */
package com.bpfaas.common.exception;

/**
 * Msg Exception
 *
 * @author pengxiang.li
 * @date 2020/7/1 4:51 下午
 */
public class MsgException extends FaasRuntimeException {
    private static final long serialVersionUID = -1481460277551765527L;

    public MsgException() {
        super();
    }

    public MsgException(String message) {
        super(message);
    }

    public MsgException(String message, Throwable cause) {
        super(message, cause);
    }

    public MsgException(Throwable cause) {
        super(cause);
    }
}
