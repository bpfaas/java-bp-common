/**
 * Copyright (c) 2020 Copyright bp All Rights Reserved.
 * Author: lipengxiang
 * Date: 2020-2020/6/12 15:07
 * Desc:
 */
package com.bpfaas.common.web;

/**
 * 错误代码
 *
 * @author pengxiang.li
 * @date 2020/6/12 3:07 下午
 */
public enum ErrorCode {
    // --------------------------------------------------------
    // 1类成功.
    // --------------------------------------------------------

    /**
     * 正确
     */
    OK(200),
    /**
     * 处理中 – 用于异步处理，再次请求时尚未处理完成
     */
    OK_SYNC(202),

    // --------------------------------------------------------
    // 2类平台问题.
    // --------------------------------------------------------
    /**
     * 传递的参数格式非法.
     */
    PARAMETER_ERROR(400),
    /**
     * 无权限; 包含签名错误等;
     */
    UNAUTHORIZE(401),
    /**
     * 操作了不存在的数据
     */
    NOT_FOUND(404),
    /**
     * 当前的操作过期或超时, 不能继续操作
     */
    OPERATOR_EXPIRED(408),
    /**
     * 操作失败; 非内部错误; 而是条件不足等原因造成. (当无法匹配到详细原因时)
     */
    OPERATOR_ERROR(417),
    /**
     * @desc: 应用调用次数超限; (此处应用为使用 appid 调用的应用).
     */
    APPCALL_LIMITED(444),
    /**
     * @desc: 当前的操作过于频繁, 稍后继续操作
     */
    OPERATOR_LIMITED(445),
    /**
     * @desc: 内部错误或是不合法的调用引起
     */
    SERVICE_ERROR(500),
    /**
     * @desc: 服务不可用, 可能为负载过重或内部服务超时
     */
    SERVICE_UNAVAILABLE(504);

    private int value;

    public int getValue() {
        return this.value;
    }

    private ErrorCode(int value) {
        this.value = value;
    }

    public static ErrorCode fromCode(int value) {
        ErrorCode[] codes = ErrorCode.values();
        for (int i = 0; i < codes.length; i++) {
            if (value == codes[i].getValue()) {
                return codes[i];
            }
        }

        return null;
    }
}
