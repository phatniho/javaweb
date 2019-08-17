package com.tedu.dan;

import java.util.Map;

import com.tedu.pojo.Emp;

public interface EmpMapper {
	public int addUser(Emp emp);

	public Emp login(Map map);
}
