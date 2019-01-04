package com.study.dubbo.provider.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.study.dubbo.api.bean.Address;
import com.study.dubbo.api.bean.User;
import com.study.dubbo.api.service.UserService;

/**
 * dubbo服务接口的实现类，使用@Service注解暴露dubbo服务
 */
@Service(interfaceClass=UserService.class, version="1.0.0", timeout=10000)
@Component
public class UserServiceImpl implements UserService {
	@Override
	public User getUser(long id) {
		return new User(id, "cjm", "123");
	}
	
	@Override
	public void updateAddress(Address address) {
		System.out.println(address.getProvince() + ", " + address.getCity());
	}
}
