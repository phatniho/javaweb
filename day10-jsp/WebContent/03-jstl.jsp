<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<h1>1.c:set标签</h1>
	<h3>(1)往指定域中添加属性</h3>
	<%
		String name1 = "张三";
		request.setAttribute("name1", name1);
	%>
	<c:set var="name2" value="张三丰" scope="request" />
	${ name2 }
	<br />
	<c:set var="name2" value="张无忌" />
	${ name2 }
	<br /> ${ requestScope.name2 }
	<br />
	<h3>(2)修改域中已有的属性</h3>
	<c:set var="name2" value="张无忌" scope="request" />
	${ name2 }

	<h1>2.c:if标签 -- 构造简单的if...else语句</h1>
	<!-- 如果test值为true,就会输出标签中的内容,否则就不会输出 -->
	<c:if test="${3>4}">
		没有错,就是这样
	</c:if>
	<c:if test="${!(3>4)}">
		错啦,不是这样
	</c:if>

	<h1>3.c:forEach标签(重要!!)</h1>
	<h3>(1)遍历域中的数组或集合中的元素</h3>
	<h3>(2)遍历域中的map集合中的元素</h3>
	<h3>(3)遍历0~100之间的所有整数,将是7的倍数的数值输出到网页上</h3>
	<h3>(4)使用逗号分隔上面的练习中的数值,并去除最后一个逗号</h3>
</body>
</html>