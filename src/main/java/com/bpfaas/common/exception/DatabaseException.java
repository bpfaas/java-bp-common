/**
 * Copyright (c) 2020 Copyright bp All Rights Reserved.
 * Author: lipengxiang
 * Date: 2020-2020/7/1 17:30
 * Desc:
 */
package com.bpfaas.common.exception;

/**
 * Database Exception
 *
 * @author pengxiang.li
 * @date 2020/7/1 5:30 下午
 */
public class DatabaseException extends FaasException {
	private static final long serialVersionUID = 1749850513565294722L;

	public DatabaseException() { super(); }
    public DatabaseException(String message) {
        super(message);
    }
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
    public DatabaseException(Throwable cause) {
        super(cause);
    }
}
