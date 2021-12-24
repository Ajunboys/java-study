package com.codedok.boot.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedok.boot.properties.ApplicationProperty;
import com.codedok.boot.properties.DeveloperProperty;
/**
 * <p>
 * 测试Controller
 * </p>
 *
 * @author junqiang.wei
 * @date Created in 2021-12-25 03:33
 */
@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {
	private final ApplicationProperty applicationProperty;
	private final DeveloperProperty developerProperty;
	
	public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
		this.applicationProperty = applicationProperty;
		this.developerProperty = developerProperty;
	}
	
	@GetMapping
	public Map<String, Object> getProperties(){
		Map<String, Object> propertiesMap = new HashMap<>();
		propertiesMap.put("application", applicationProperty);
		propertiesMap.put("developer", developerProperty);
		return propertiesMap;
	}
}
