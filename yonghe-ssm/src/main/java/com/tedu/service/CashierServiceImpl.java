package com.tedu.service;

import com.tedu.dao.CashierMapper;
import com.tedu.pojo.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashierServiceImpl implements CashierService {
	@Autowired
	CashierMapper dao;

	@Override
	public void addCashier(Cashier cashier) {
		dao.addCashier(cashier);
	}

	@Override
	public Cashier loginCashier(Cashier cashier) {
		Cashier c1 = dao.loginCashier(cashier);
		return c1;
	}

	@Override
	public List<Cashier> findAll() {
		List<Cashier> list = dao.findAll();
		return list;
	}

	@Override
	public void deleteById(Integer cId) {
		dao.deleteById(cId);
	}

	@Override
	public Cashier findById(Integer id) {
		Cashier cashier = dao.findById(id);
		return cashier;
	}

	@Override
	public void updateById(Cashier cashier) {
		dao.updateById(cashier);
	}
}
