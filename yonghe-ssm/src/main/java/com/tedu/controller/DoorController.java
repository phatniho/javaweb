package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.pojo.Door;
import com.tedu.service.DoorService;

// Door模块的Controller
@Controller
public class DoorController {
	@Autowired // 自动装配:将由Spring容器负责创建该对象,并赋值给该变量
	DoorService doorService;

	// 1.查询所有门店信息
	@RequestMapping("/doorList")
	public String doorList(Model model) {
		// 1.调用Service层的方法查询所有门店
		List<Door> list = doorService.findAll();
		// 2.将所有门店的集合存入Model中
		model.addAttribute("list", list);
		// 3.转向门店列表页面
		return "door_list";
	}

	// 2.根据id删除门店信息
	@RequestMapping("/doorDelete")
	public String doorDelete(Integer id) {
		// 调用Service方法删除门店
		doorService.deleteById(id);
		// 转发转向门店列表页面,显示最新门店信息
		return "forward:/doorList";
	}

	// 3.新增门店信息
	@RequestMapping("/doorAdd")
	public String doorAdd(Door door) {
		// 调用Service方法新增门店
		doorService.addDoor(door);
		// 转发转向门店列表页面,显示最新门店信息
		return "forward:/doorList";
	}

	// 4.根据id查询门店详情
	@RequestMapping("/doorInfo")
	public String doorInfo(Integer id, Model model) {
		// 调用Service方法查找门店,接收返回的结果
		Door door = doorService.findById(id);
		// 将返回的结果存入model中
		model.addAttribute("door", door);
		// 将model中的信息回显到修改页面上
		return "door_update";
	}

	// 5.根据id修改门店信息
	@RequestMapping("/doorUpdate")
	public String doorUpdate(Door door) {
		// 调用Service方法修改门店信息
		doorService.updateById(door);
		// 转发转向门店列表页面,显示最新门店信息
		return "forward:/doorList";
	}

	// 通用的jsp页面跳转方法
	// 比如:访问到/WEB-INF/pages/door_add.jsp
	// 只需要让下面的方法返回"door_add"值
	// 因为方法返回的值,就是路径斜杠后面的值,因此,再访问时,需要方位/door_add路径
	// url路径与返回路径一致,传入变量接收url路径参数,三个变量名必须一致
	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page) {
		return page;
	}
}
