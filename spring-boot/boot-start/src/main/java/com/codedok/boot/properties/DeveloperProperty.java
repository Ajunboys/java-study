package com.codedok.boot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
/**
 * <p>
 * 开发人员配置信息
 * </p>
 *
 * @author junqiang.wei
 * @date Created in 2021-12-25 03:32
 */
@Data
@ConfigurationProperties(prefix = "developer")
@Component
public class DeveloperProperty {
	private String name;
    private String website;
    private String qq;
    private String phoneNumber;
}
