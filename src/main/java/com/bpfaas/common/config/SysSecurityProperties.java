package com.bpfaas.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;


import lombok.Data;

/**
 * 安全配置
 *
 * @author rjf
 * @since 2020/12/23
 */
@Data
@ConfigurationProperties(prefix = "sys.security")
public class SysSecurityProperties {

    /**
     * 是否启用安全校验
     */
    private boolean enable = false;

    /**
     * 服务签名
     */
	private String serviceSign;

	private String tokenHeaderName = "Authorization";
	private String authServiceEndpoint;

    /**
     * 鉴权接口
     */
    private List<String> authFilterPathPatterns = new ArrayList<>();

    /**
     * 非鉴权接口
     */
    private List<String> authFilterExcludePathPatterns = new ArrayList<>();
}
