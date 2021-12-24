package com.codedok.boot.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <p>
 * User模型
 * </p>
 *
 * @author junqiang.wei
 * @date Created in 2021-12-25 03:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private Long uid;
	
	private String username;
	
	private String password;
	
	private Date birthday;
	
	private String email;
	
}
