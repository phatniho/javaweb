package com.tedu.service;

import com.tedu.dao.GoodsMapper;
import com.tedu.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsMapper dao;

	@Override
	public List<Goods> findAll() {
		List<Goods> list = dao.findAll();
		return list;
	}

	@Override
	public void addGoods(Goods goods) {
		dao.addGoods(goods);
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public Goods findById(Integer id) {
		Goods goods = dao.findById(id);
		return goods;
	}

	@Override
	public void updateById(Goods goods) {
		dao.updateById(goods);
	}

}
