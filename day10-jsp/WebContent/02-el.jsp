<%@page import="com.tedu.User"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<h1>1.获取常量,表达式或变量(先存入域)的值,并输出</h1>
	${"Hello JSP--el输出"}
	<hr />
	<%="Hello JSP--jsp输出"%>
	<hr />
	Hello JSP--html输出
	<hr />
	${ 100+23 }
	<hr />
	<%
		String name = "韩少云";
	%>
	<%=name%>
	<hr />
	<%
		request.setAttribute("name1", name);
	%>
	${ name1 }
	<%-- 在EL中书写变量,在执行时EL会根据变量的名字到域中寻找指定名称的属性值,
	如果找到就将值返回并输出,如果找不到就什么也不输出! --%>
	<h1>2.获取域中数组或集合中的元素/数据</h1>
	<%
		String[] names = { "刘德华", "张学友", "郭富城", "黎明" };
		session.setAttribute("name", names);
	%>
	<%-- EL只能获取域中的数据,但不能遍历 --%>
	${ name[0] }
	<br /> ${ name[1] }
	<br /> ${ name[2] }
	<br /> ${ name[3] }
	<h1>3.获取域中的map集合中的元素/数据</h1>
	<%
		Map map = new HashMap();
		map.put("name", "阿凡达");
		map.put("age", 18);
		map.put("nickname", "小啊");
		request.setAttribute("hm", map);
	%>
	${ hm.get("name") }
	<br /> ${ hm["age"] }
	<br /> ${ hm.nickname }
	<h1>4.获取域中的对象(User对象)的属性值</h1>
	<%
		User u = new User("张飞", "123", "zf@tedu.cn");
		request.setAttribute("user", u);
	%>
	${ user.getUsername() }
	<br />${ user["pwd"] }
	<br />${ user.email }
</body>
</html>