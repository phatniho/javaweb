package com.tedu.controller;

import com.tedu.pojo.Goods;
import com.tedu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class GoodsController {
	@Autowired
	GoodsService goodsService;

	@RequestMapping("goodsList")
	public String goodsList(Model model) {
		List<Goods> goodsList = goodsService.findAll();
		model.addAttribute("goodsList", goodsList);
		return "goods_list";
	}

	@RequestMapping("goodsAdd")
	public String goodsAdd(Goods goods) {
		goodsService.addGoods(goods);
		return "forward:goodsList";
	}

	@RequestMapping("goodsDelete")
	public String goodsDelete(Integer id) {
		goodsService.deleteById(id);
		return "forward:goodsList";
	}

	@RequestMapping("goodsInfo")
	public String goodsInfo(Integer id, Model model) {
		Goods goods = goodsService.findById(id);
		model.addAttribute("goods", goods);
		return "goods_update";
	}

	@RequestMapping("goodsUpdate")
	public String goodsUpdate(Goods goods) {
		goodsService.updateById(goods);
		return "forward:goodsList";
	}

}
