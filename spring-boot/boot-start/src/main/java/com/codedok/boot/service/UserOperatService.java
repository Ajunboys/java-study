package com.codedok.boot.service;

import java.util.List;

import com.codedok.boot.model.User;
/**
 * <p>
 * User业务操作服务
 * </p>
 *
 * @author junqiang.wei
 * @date Created in 2021-12-25 03:30
 */
public interface UserOperatService {
	
	public List<User> getAllUser();
	
	public User getUserByUID(Long uid);
}
