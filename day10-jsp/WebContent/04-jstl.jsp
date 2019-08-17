<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<h1>3.c:forEach标签(重要!!)</h1>
	<h3>(1)遍历域中的数组或集合中的元素</h3>
	<%
		String[] names = { "刘德华", "张学友", "郭富城", "黎明" };
		request.setAttribute("names", names);
		for (String name : names) {
		}
	%>
	<c:forEach items="${ names }" var="name">
		${ name }<br />
	</c:forEach>

	<h3>(2)遍历域中的map集合中的元素</h3>
	<%
		Map map = new HashMap();
		map.put("name", "阿凡达");
		map.put("age", 18);
		map.put("nickname", "小啊");
		request.setAttribute("map1", map);
	%>
	<c:forEach items="${map1}" var="entry">
		${entry.getKey()} : ${entry.getValue()}<br />
		${entry.key} : ${entry.value}<br />
		${entry["key"]} : ${entry["value"]}<br />
		${entry}<br />
	</c:forEach>
	<h3>(3)遍历0~100之间的所有整数,将是7的倍数的数值输出到网页上</h3>
	<c:forEach begin="0" end="100" var="i">
		<c:if test="${i%7==0}">${i}</c:if>
	</c:forEach>
	<h3>(4)使用逗号分隔上面的练习中的数值,并去除最后一个逗号</h3>
	<!-- varStatus表示当前循环遍历信息的对象,该对象上常见的属性有:
	(1)status.first --如果返回true,表示当前遍历的是第一个元素
	(2)status.last --如果返回true,表示当前遍历的是最后一个元素
	(3)status.count --统计当前遍历到了第几个元素
	(4)status.index --begin从0开始时,index也从0开始,begin不从0开始,index也不从0开始.不推荐使用.
	推荐使用status.count-1来表示下标
	 -->
	<%-- <c:forEach begin="0" end="100" var="i" varStatus="status" step="7">
		${i}
		${status.last?"":","}
	</c:forEach> --%>
	<c:forEach begin="0" end="100" var="i" varStatus="status">
		<c:if test="${i%7==0}">
		${status.first?"":","}
		${i}
		</c:if>
	</c:forEach>
	<h3>(5)遍历0~100之间的所有整数,将是3的倍数的数值输出到网页上</h3>
	<c:forEach begin="0" end="100" var="i">${i%3==0?i:" "}</c:forEach>

</body>
</html>