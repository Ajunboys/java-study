package com.codedok.boot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codedok.boot.model.User;
import com.codedok.boot.service.UserOperatService;

import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * User RESTController
 * </p>
 *
 * @author junqiang.wei
 * @date Created in 2021-12-25 03:31
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserOperatService userOperatService;
	
	@GetMapping("/{uid}")
	public User getUser(@PathVariable(name = "uid") Long uid) {
		log.info("get user by user-id:{}", uid);
		return userOperatService.getUserByUID(uid);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getUsers(){
		return userOperatService.getAllUser();
	}
}
