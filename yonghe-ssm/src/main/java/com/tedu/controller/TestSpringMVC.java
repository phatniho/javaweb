package com.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestSpringMVC {
	@RequestMapping("/testmvc")
	public String testSpringmvc() {
		return "test";
	}
}
