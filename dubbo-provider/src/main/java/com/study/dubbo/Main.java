package com.study.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication()
public class Main{
	public static void main(String[] args){
		SpringApplication springApp = new SpringApplication(Main.class);
		springApp.run(args);
	}
	
	@RequestMapping("/index")
    public String greeting() {
        return "hello provider";
    }
}
