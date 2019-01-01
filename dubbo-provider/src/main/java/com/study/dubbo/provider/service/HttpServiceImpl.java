package com.study.dubbo.provider.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.study.dubbo.api.bean.User;
import com.study.dubbo.api.service.HttpService;

//@Service(interfaceClass=HttpService.class)
//@Component
public class HttpServiceImpl implements HttpService {
	@Override
	public User getUser(long id) {
		return new User(id, "cxq", "234");
	}
}
