package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Cashier;

public interface CashierMapper {

	void addCashier(Cashier cashier);

	Cashier loginCashier(Cashier cashier);

	List<Cashier> findAll();

	void deleteById(Integer cId);

	Cashier findById(Integer id);

	void updateById(Cashier cashier);

}
