package com.tedu.service;

import com.tedu.pojo.Cashier;

import java.util.List;

public interface CashierService {

	void addCashier(Cashier cashier);

	Cashier loginCashier(Cashier cashier);

	List<Cashier> findAll();

	void deleteById(Integer cId);

	Cashier findById(Integer id);

	void updateById(Cashier cashier);

}
