package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.pojo.Cashier;
import com.tedu.pojo.Door;
import com.tedu.service.CashierService;
import com.tedu.service.DoorService;
import com.tedu.service.OrderService;

@Controller
public class UserController {
	@Autowired
	OrderService orderService;
	@Autowired
	DoorService doorService;
	@Autowired
	CashierService cashierService;

	@RequestMapping("/cashierList")
	public String cashierList(Model model) {
		List<Cashier> cashierList = cashierService.findAll();
		model.addAttribute("cashierList", cashierList);
		// 查询所有门店信息
		List<Door> doorList = doorService.findAll();
		// 将门店集合存入model中
		model.addAttribute("doorList", doorList);
		return "cashier_list";
	}

	@RequestMapping("/userAdd")
	public String userAdd(Model model) {
		// 查询所有门店信息
		List<Door> doorList = doorService.findAll();
		// 将门店集合存入model中
		model.addAttribute("doorList", doorList);
		return "user_add";
	}

	@RequestMapping("/addUser")
	public String addUser(Cashier cashier) {
		cashierService.addCashier(cashier);
		return "_right";
	}

	@RequestMapping("/login")
	public String login() {
		return "user_login";
	}

	@RequestMapping("/loginUser")
	public String loginUser(Cashier cashier, Model model) {
		Cashier c1 = cashierService.loginCashier(cashier);
		if (c1 == null) {
			return "reload";
		} else {
			model.addAttribute("cashier", c1);
			return "forward:/orderList";
		}
	}

	@RequestMapping("/cashierDelete")
	public String cashierDelete(Integer id) {
		cashierService.deleteById(id);
		return "forward:/cashierList";
	}

	@RequestMapping("/cashierInfo")
	public String cashierInfo(Integer id, Model model) {
		List<Door> doorList = doorService.findAll();
		model.addAttribute("doorList", doorList);
		Cashier cashier = cashierService.findById(id);
		model.addAttribute("cashier", cashier);
		return "cashier_update";
	}

	@RequestMapping("/cashierUpdate")
	public String cashierUpdate(Cashier cashier) {
		cashierService.updateById(cashier);
		return "forward:/cashierList";
	}
}
