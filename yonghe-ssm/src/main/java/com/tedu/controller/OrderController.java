package com.tedu.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.pojo.Door;
import com.tedu.pojo.Order;
import com.tedu.service.DoorService;
import com.tedu.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	DoorService doorService;

	// 1.查询所有订单集合
	@RequestMapping("/orderList")
	public String orderList(Model model) {
		// 查询所有门店信息
		List<Door> doorList = doorService.findAll();
		// 将门店集合存入model中
		model.addAttribute("doorList", doorList);
		// 查询所有订单集合
		List<Order> orderList = orderService.findAll();
		// 将订单集合存入model中
		model.addAttribute("orderList", orderList);
		// 转向目标页面
		return "order_list";
	}

	// 2.根据id删除订单
	@RequestMapping("/orderDelete")
	public String orderDelete(Integer id) {
		orderService.deleteById(id);
		return "forward:/orderList";
	}

	// 3.跳转到新增订单页面,跳转的同时,将查询出所有门店,将所有门店带到新增订单页面
	@RequestMapping("/toOrderAdd")
	public String toOrderAdd(Model model) {
		// 查询所有门店信息
		List<Door> doorList = doorService.findAll();
		// 将门店集合存入model中
		model.addAttribute("doorList", doorList);
		return "order_add";
	}

	@RequestMapping("/orderAdd")
	public String orderAdd(Order order) {
		orderService.addOrder(order);
		return "forward:/orderList";
	}

	// 4.根据id查询订单
	@RequestMapping("/orderInfo")
	public String orderInfo(Integer id, Model model) {
		// 查询所有门店信息
		List<Door> doorList = doorService.findAll();
		// 将门店集合存入model中
		model.addAttribute("doorList", doorList);
		Order order = orderService.findById(id);
		model.addAttribute("order", order);
		return "order_update";
	}

	// 5.根据id修改订单
	@RequestMapping("/orderUpdate")
	public String orderUpdate(Order order, Model model) {
		// 查询所有门店信息
		List<Door> doorList = doorService.findAll();
		// 将门店集合存入model中
		model.addAttribute("doorList", doorList);
		orderService.updateById(order);
		return "forward:/orderList";
	}

	/* 自定义日期转换格式 */
	@InitBinder
	public void InitBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
