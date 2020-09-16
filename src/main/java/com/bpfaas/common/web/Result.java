package com.bpfaas.common.web;

import lombok.Getter;

public class Result {
  /**
   * 是否成功
   */
  @Getter
  private boolean success;
  /**
   * 错误消息
   */
  @Getter
  private String errMsg;

  /**
   * 构建正确的结果.
   */
  public Result() {
    this.success = true;
  }

  /**
   * 使用错误消息构造
   * 
   * @param errMsg
   */
  public Result(String errMsg) {
    this.errMsg = errMsg;
    this.success = false;
  }
}