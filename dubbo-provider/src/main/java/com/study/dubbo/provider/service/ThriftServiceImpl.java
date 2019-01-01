package com.study.dubbo.provider.service;

import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.study.dubbo.thrift.Message;
import com.study.dubbo.thrift.Response;
import com.study.dubbo.thrift.ThriftService;

//@Service(interfaceClass=ThriftService.Iface.class, protocol="thrift")
//@Component
public class ThriftServiceImpl implements ThriftService.Iface {
	@Override
	public String hello(String username) throws TException {
		return "Hello " + username;
	}

	@Override
	public Response sendMessage(Message message) throws TException {
		System.out.println(message.getType() + ", " + new String(message.getData()));
		Response response = new Response(0, "success");
		return response;
	}
	
}
