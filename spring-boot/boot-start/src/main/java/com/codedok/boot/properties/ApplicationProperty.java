package com.codedok.boot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
/**
 * <p>
 * 项目配置
 * </p>
 *
 * @author junqiang.wei
 * @date Created in 2021-12-25 03:32
 */
@Data
@Component
public class ApplicationProperty {
	@Value("${application.name}")
	private String name;
	
	@Value("${application.version}")
	private String version;
	
	@Value("${application.developer}")
	private String developer;
}
