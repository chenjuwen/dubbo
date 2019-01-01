package com.study.dubbo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.study.dubbo.api.bean.User;
import com.study.dubbo.consumer.service.ServiceConsumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	@Autowired
	private ServiceConsumer serviceConsumer;
	
	@Test
	public void testGetUser() {
		User user = serviceConsumer.getUserService().getUser(100L);
		System.out.println(user.getUsername() + ", " + user.getPassword());
	}
	
}
