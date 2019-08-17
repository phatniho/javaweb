package com.tedu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.pojo.User;

/*
 * Controller类
 * 
 * @Controller的作用有两个:
 * (1)标识当前类属于控制层
 * (2)配合包扫描器,将当前类的对象的创建交给spring容器
 * (spring会扫描指定包下的所有类,只要扫描到类上有注解,就会负责当前类的对象的创建)
 */
@Controller
public class HelloController {
	// 配置请求路径和方法的映射关系
	// 当浏览器访问hello时,就会执行下面的testHello()方法
	// 另外:路径在整个项目中,应该是独一无二的
	@RequestMapping("/hello")
	public String testHello() {
		System.out.println("hello springmvc");
		// 转向:/WEB-INF/pages/home.jsp
		return "home";
	}

	// 获取请求中的参数1
	@RequestMapping("/testParam1")
	public String testParam1(String name, Integer age) {
		System.out.println("name=" + name);
		System.out.println("age=" + age);
		return "home";
	}

	// 获取请求中的参数2
	@RequestMapping("/testParam2")
	public String testParam2(User user) {
		System.out.println(user);
		return "home";
	}

	// 获取请求中的参数3
	@RequestMapping("/testParam3")
	public String testParam3(Date date) {
		System.out.println(date);
		return "home";
	}

	// 转发
	@RequestMapping("/toForward")
	public String testForward() {
		System.out.println("转发到hello");
		// 方法之间的调用,不属于转发
		// return testHello();
		// 从当前方法转发到/hello,路径不会改变
		return "forward:/hello";
	}

	// 重定向
	@RequestMapping("/toRedirect")
	public String testRedirect() {
		System.out.println("重定向到hello");
		// 从当前方法重定向到/hello,路径会改变
		return "redirect:/hello";
	}

	// 响应数据:Model的使用
	@RequestMapping("/model")
	public String testModel(Model model) {
		// 将数据封装到User对象中
		User user = new User();
		user.setName("张飞");
		user.setAge(29);
		model.addAttribute("user", user);
		// 转发(转向)到test.jsp
		return "test";
	}

	// 响应JSON数据1
	@RequestMapping("/json1")
	@ResponseBody // 将返回的对象或集合转成json格式的数据
	public User testJson1() {
		// 将数据封装到User对象中
		User user = new User();
		user.setName("张飞");
		user.setAge(29);
		return user;
	}

	// 响应JSON数据2
	@RequestMapping("/json2")
	@ResponseBody // 将返回的对象或集合转成json格式的数据
	public List<User> testJson2() {
		// 将数据封装到User对象中
		User u1 = new User();
		u1.setName("张飞");
		u1.setAge(29);
		User u2 = new User();
		u2.setName("刘备");
		u2.setAge(23);
		List<User> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
		return list;
	}

	// 自定义日期格式,默认为/分隔,可以修改为-
	@InitBinder
	public void InitBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
