package com.codedok.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * SpringBoot程序启动类
 * </p>
 *
 * @author junqiang.wei
 * @date Created in 2021-12-25 03:29
 */
@Slf4j
@SpringBootApplication
public class BootStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootStartApplication.class, args);
		log.debug("boot started!");
	}

}
