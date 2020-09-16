/**
 * Copyright (c) 2020 Copyright bp All Rights Reserved.
 * Author: lipengxiang
 * Date: 2020-2020/6/12 15:03
 * Desc:
 */
package com.bpfaas.common.web;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

/**
 *
 *
 * @author pengxiang.li
 * @date 2020/6/12 3:03 下午
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MsgBase {

    /**
     * 调用信息.
     */
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class TraceObject {
        /**
        * 引起此消息调用链的用户/模块id.
        */
        @JsonProperty("operator")
        private String operator;

        /**
         * 调试模式下的系统名称.
         */
        @JsonProperty("debugSys")
        private String debugSys;

        /**
        * 此消息链发生的时间.
        */
        @JsonProperty("time_at")
        private Date timeAt;
    }

    /**
     * 消息最原始的发送者.
     */
    @JsonProperty("trace") @Getter
    private TraceObject trace;

    /**
     * 设置trace对象.
     */
    public void setTrace(TraceObject trace) {
        this.trace = trace;
    }
    /**
     * 设置trace对象.
     */
    public void setTrace(String operator, Date timeAt, String debugSys) {
        if (null == this.trace) {
            this.trace = new TraceObject();
        }
        this.trace.setDebugSys(debugSys);
        this.trace.setOperator(operator);
        this.trace.setTimeAt(timeAt);
    }
    /**
     * 设置trace对象.
     */
    public void setTrace(String operator, Date timeAt) {
        if (null == this.trace) {
            this.trace = new TraceObject();
        }
        this.trace.setOperator(operator);
        this.trace.setTimeAt(timeAt);
    }
}
