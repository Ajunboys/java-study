package com.codedok.boot.components;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.codedok.boot.model.User;
/**
 * <p>
 * User测试实例用户数据
 * </p>
 *
 * @author junqiang.wei
 * @date Created in 2021-12-25 03:31
 */
@Component
public class UserComponent {
	
	@Bean
	public List<User> initUserData(){
		return Arrays.asList(
				new User(968912L, "tony", "123456!", new Date(), "tony@gmail.com"),

				new User(968913L, "jack", "123456!", new Date(), "jack@gmail.com"),

				new User(968915L, "ader", "123456!", new Date(), "ader@gmail.com"),

				new User(968916L, "ak98", "123456!", new Date(), "ak98@gmail.com")
				
				);
	}
}
