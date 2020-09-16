/*
 * Copyright (c) 2020 Copyright bp All Rights Reserved.
 * Author: pengxiang.li
 * Desc:
 */

package com.bpfaas.common.utils;

/**
 * @author pengxiang.li
 * @date 2020/1/31 7:20 下午
 */
public interface ICommandStream {
    void onStream(String line);
}