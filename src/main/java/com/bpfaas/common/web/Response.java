/**
 * Copyright (c) 2020 Copyright bp All Rights Reserved.
 * Author: lipengxiang
 * Date: 2020-2020/6/2 15:17
 * Desc:
 */
package com.bpfaas.common.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class Response {

    @Setter @Getter
    private int statusCode = 200;

    @Setter @Getter
    private Object body;

    private Map<String, Collection<String>> headers;

    public Response() {
        this.headers = new HashMap<>();
    }

    /**
     * Get response headers map.
     * @return headers map
     */
    public Map<String, Collection<String>> getHeaders() {
        return this.headers;
    }

    /**
     * Get response header by key.
     * @param key header键名
     * @return 指定key的head值.
     */
    public Collection<String> getHeader(String key) {
        if(!this.headers.containsKey(key)) {
            return null;
        }

        return this.headers.get(key);
    }

    /**
     * Set response header by key and value.
     * @param key header键名
     * @param value 对应的值
     */
    public void setHeader(String key, String value) {
        Collection<String> headers1 = this.headers.get(key);
        if (null == headers1) {
            ArrayList<String> values = new ArrayList<>();
            values.add(value);
            this.headers.put(key, values);
        }
        else {
            List<String> headers2 = (List<String>) headers1;
            if (headers2.size() == 1) {
                headers2.set(0, value);
            }
            else {
                headers2.clear();
                headers2.add(value);
            }
        }
    }

    /**
     * Set response header by key and values
     * @param key header键名
     * @param value 对应的键值集合
     */
    public void setHeader(String key, Collection<String> value) {
        Collection<String> headers1 = this.headers.get(key);
        if (null == headers1) {
            this.headers.put(key, new ArrayList<>(value));
        }
        else {
            this.headers.replace(key, new ArrayList<>(value));
        }
    }

    /**
     * Remove response header by key
     * @param key header键名
     */
    public void removeHeader(String key) {
        this.headers.remove(key);
    }
}
