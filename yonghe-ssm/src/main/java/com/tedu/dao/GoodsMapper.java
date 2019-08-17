package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Goods;

public interface GoodsMapper {

	List<Goods> findAll();

	void addGoods(Goods goods);

	void deleteById(Integer id);

	Goods findById(Integer id);

	void updateById(Goods goods);

}
