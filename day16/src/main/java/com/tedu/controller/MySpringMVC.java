package com.tedu.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.pojo.Emp;

@Controller
public class MySpringMVC {
	@InitBinder
	public void InitBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping("/index")
	public String test1() {
		System.out.println("hello");
		return "index";
	}

	@RequestMapping("/login")
	public String test2(Integer id, String name) {
		System.out.println("登录页面");
		return "login";
	}

	@RequestMapping("/welcome")
	public String test3(Integer id, String name) {
		System.out.println("id=" + id);
		System.out.println("name=" + name);
		return "welcome";
	}

	@RequestMapping("/register")
	public String test4() {
		System.out.println("注册页面");
		return "register";
	}

	@RequestMapping("/success")
	public String test5(Emp emp) {
		System.out.println(emp);
		return "success";
	}
}
