package com.study.dubbo.consumer.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.study.dubbo.api.service.UserService;

@Service
public class ServiceConsumer {
	/**
	 * 消费dubbo服务
	 */
	@Reference(version="1.0.0")
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
