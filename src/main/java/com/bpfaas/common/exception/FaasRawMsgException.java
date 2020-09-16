/**
* Copyright (c) 2020 Copyright bp All Rights Reserved.
* Author: brian.li
* Date: 2020-09-09 14:57
* Desc: 
*/

package com.bpfaas.common.exception;

import lombok.Getter;

/***
 * 接收到此异常时, 消息处理将根据错误类型设置httpStatusCode并返回;
 * 
 * 而不会按照Msg消息格式返回.
 */
public class FaasRawMsgException extends FaasRuntimeException {
  private static final long serialVersionUID = -5526784669061817583L;
  
  @Getter
  private final int httpStatusCode;

  public FaasRawMsgException(String message, int httpStatusCode) {
    super(message);
    this.httpStatusCode = httpStatusCode;
  }
}