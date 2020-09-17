/**
 * Copyright (c) 2020 Copyright bp All Rights Reserved.
 * Author: lipengxiang
 * Date: 2020-2020/7/1 16:51
 * Desc:
 */
package com.bpfaas.common.exception;

import lombok.Getter;

/**
 * @author pengxiang.li
 * @date 2020/7/1 4:51 下午
 */
public class BpErrSubcodeException extends RuntimeException {
    private static final long serialVersionUID = -1259159488139971417L;

    /**
     * 错误代码.
     */
    @Getter
    private String errSubCode;

    public BpErrSubcodeException() {
        super();
    }
    public BpErrSubcodeException(String errSubCode) {
        super(errSubCode);
        this.errSubCode = errSubCode;
    }
    public BpErrSubcodeException(String errSubCode, Throwable cause) {
        super(errSubCode, cause);
        this.errSubCode = errSubCode;
    }
    public BpErrSubcodeException(Throwable cause) {
        super(cause);
    }
}
