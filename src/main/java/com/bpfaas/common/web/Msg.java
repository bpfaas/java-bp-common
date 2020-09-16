/**
 * Copyright (c) 2020 Copyright bp All Rights Reserved.
 * Author: lipengxiang
 * Date: 2020-2020/6/12 14:55
 * Desc:
 */
package com.bpfaas.common.web;

import java.util.HashMap;
import java.util.Map;

import com.bpfaas.common.exception.MsgException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * 网络消息包.
 *
 * <code>
 *     // To create a HashMap data.
 *     new Msg&lt;Object&mt;();
 *
 *     // To create a AnyEntity data.
 *     new Msg&lt;AnyEntity&mt;();
 * </code>
 *
 * @author pengxiang.li
 * @date 2020/6/12 2:55 下午
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Msg<T> extends MsgBase {

  @JsonProperty("err_code")
  public int getErrCode() { return this.err.getValue(); }
  @JsonProperty("err_code")
  public void setErrCode(int v) { this.err = ErrorCode.fromCode(v); }

  /**
   * 统一的错误代码.
   */
  @JsonProperty("err") @Setter @Getter
  private ErrorCode err;
  /**
   * 错误信息.
   */
  @JsonProperty("err_msg") @Setter @Getter
  private String errMsg;
  /**
   * 具体业务的错误标识
   */
  @JsonProperty("err_subcode") @Setter @Getter
  private String errSubCode;
  /**
   * 具体的业务数据.
   */
  @JsonProperty("data")
  private T data;

  public T getData() {
    return data;
  }

  public Msg() { super(); this.err = ErrorCode.OK; }
  public Msg(T data) { super(); this.err = ErrorCode.OK; this.data = data; }
  public Msg(ErrorCode err) { super(); this.err = err; }
  public Msg(ErrorCode err, final String errMsg) { super(); this.err = err; this.errMsg = errMsg; }

  /**
   * 使用指定对象作为data.
   */
  @JsonIgnore
  public void setDataWithObject(T data) {
    this.data = data;
  }

  /**
   * 设置业务数据.
   * @param key
   * @param value
   */
  @SuppressWarnings("unchecked")
  public void setData(final String key, Object value) {
    if (null == value) {
      removeData(key);
      return;
    }

    if (null == data) {
      try {
        data = (T) new HashMap<String, Object>();
      }
      catch (ClassCastException e) {
        throw new MsgException("cannot invoke Msg.setData, because its data has a Type.", e);
      }
    }
    else if (!(data instanceof HashMap<?, ?>)) {
      throw new MsgException("cannot invoke Msg.setData, because its data has a Type.");
    }

    ((Map<String, Object>)data).put(key, value);
  }

  /**
   * 移除指定的业务数据
   * @param key
   */
  @SuppressWarnings("unchecked")
  public void removeData(final String key) {
    if (data == null) {
      return;
    }

    if (data instanceof HashMap<?, ?>) {
      ((Map<String, Object>)data).remove(key);
    }
    else {
      throw new MsgException("cannot invoke Msg.removeData, because its data has a Type.");
    }
  }

  /**
   * 获取指定的业务数据.
   *
   * @param key
   * @param <T1>
   * @return
   */
  @SuppressWarnings("unchecked")
  public <T1> T1 getData(final String key) {
    if (null == data || null == key || !(data instanceof HashMap<?, ?>)) {
      return null;
    }

    try {
      return (T1)((Map<String, Object>)data).get(key);
    }
    catch (ClassCastException e) {
      throw new MsgException("cannot invoke Msg.getData, because its data has a Type.", e);
    }
  }
}
