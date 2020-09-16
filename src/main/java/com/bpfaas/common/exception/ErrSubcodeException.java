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
public class ErrSubcodeException extends RuntimeException {
    private static final long serialVersionUID = -1259159488139971417L;

    /**
     * 错误代码.
     */
    @Getter
    private String errSubCode;

    public ErrSubcodeException() {
        super();
    }
    public ErrSubcodeException(String errSubCode) {
        super(errSubCode);
        this.errSubCode = errSubCode;
    }
    public ErrSubcodeException(String errSubCode, Throwable cause) {
        super(errSubCode, cause);
        this.errSubCode = errSubCode;
    }
    public ErrSubcodeException(Throwable cause) {
        super(cause);
    }
}
