package com.study.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.dubbo.api.bean.Address;
import com.study.dubbo.api.bean.User;
import com.study.dubbo.consumer.service.ServiceConsumer;

@RestController
@SpringBootApplication()
public class Main{
	@Autowired()
	private ServiceConsumer serviceConsumer;
	
	public static void main(String[] args){
		SpringApplication springApp = new SpringApplication(Main.class);
		springApp.run(args);
	}
	
	@RequestMapping("/index")
    public String greeting() {
		Address address = new Address();
		address.setProvince("GuangDong");
		address.setCity("GuangZhou");
		serviceConsumer.getUserService().updateAddress(address);
		
		User user = serviceConsumer.getUserService().getUser(110L);
        return "hello consumer: username=" + user.getUsername() + ", password=" + user.getPassword() + ", nowtime=" + user.getNowtime();
    }
	
}
