package com.tedu.dan;

import com.tedu.pojo.Emp;

import java.util.Map;

public interface EmpMapper {
	public int addUser(Emp emp);

	public Emp login(Map map);
}
