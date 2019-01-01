package com.study.dubbo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/test")
	public String index(ModelMap modelMap){
		return "test";
	}
}
