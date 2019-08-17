package com.tedu.dao;

import com.tedu.pojo.Emp;

import java.util.List;

/*
 * mybatis的Mapper接口开发
 * (1)创建一个接口,接口的全路径名和mapper文件的namespace值要相同
 * (2)SQL标签的ID值也要和接口中的方法名保持一致
 * (3)SQL语句的参数类型和接口中方法的参数类型要保持一致
 * (4)SQL标签上的resultType即返回值类型和接口中方法的返回值类型相同(如果返回值是集合,resultType只需要制定集合中的泛型)
 * 
 * dao:data access object 数据访问对象,表示连接并访问数据的一层
 * EmpMapper.xml文件的接口
 */
public interface EmpMapper {
	// 在EmpMapper.xml中的一条SQL语句要对应接口中的一个方法
	public List<Emp> findAll();

	public int addEmp(Emp emp);

	public int update(Emp emp);

	public int deleteById(Integer id);
}
