package com.study.dubbo.api.service;

import com.study.dubbo.api.bean.User;

/**
 * 定义dubbo服务接口
 */
public interface UserService {
	public User getUser(long id);
}
