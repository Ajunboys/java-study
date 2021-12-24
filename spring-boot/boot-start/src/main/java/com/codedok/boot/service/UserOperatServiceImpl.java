package com.codedok.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codedok.boot.components.UserComponent;
import com.codedok.boot.model.User;
/**
 * <p>
 * User业务操作服务实现
 * </p>
 *
 * @author junqiang.wei
 * @date Created in 2021-12-25 03:31
 */
@Service
public class UserOperatServiceImpl implements UserOperatService {

	private final UserComponent userComponent;
	
 
	public UserOperatServiceImpl(UserComponent userComponent) {
		this.userComponent = userComponent;
	}
	
	@Override
	public List<User> getAllUser() {
		return userComponent.initUserData();
	}

	@Override
	public User getUserByUID(Long uid) {
		User user = new User();
		for(User u : getAllUser()) {
			if (u.getUid().equals(uid)) {
				user = u;
			}
		}
		return user;
	}

}
