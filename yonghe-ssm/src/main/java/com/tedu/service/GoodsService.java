package com.tedu.service;

import com.tedu.pojo.Goods;

import java.util.List;

public interface GoodsService {

	List<Goods> findAll();

	void addGoods(Goods goods);

	void deleteById(Integer id);

	Goods findById(Integer id);

	void updateById(Goods goods);

}
