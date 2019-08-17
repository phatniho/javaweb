<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>商品管理</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	font-family: "微软雅黑";
	background-color: #EDEDED;
}

h2 {
	text-align: center;
}

table {
	width: 96%;
	margin: 0 auto;
	text-align: center;
	border-collapse: collapse;
	font-size: 16px;
}

td, th {
	padding: 5px;
}

th {
	background-color: #DCDCDC;
	width: 120px;
}

th.width-40 {
	width: 40px;
}

th.width-70 {
	width: 70px;
}

th.width-80 {
	width: 80px;
}

hr {
	margin-bottom: 20px;
	border: 1px solid #aaa;
}

#add-goods {
	text-align: center;
	font-size: 20px;
}
</style>
</head>
<body>
	<!-- body-start  -->

	<h2>商品管理</h2>
	<div id="add-goods">
		<a href="goods_add" target="rightFrame">新增商品</a>
	</div>
	<hr />
	<table border="1">
		<tr>
			<th class="width-40">序号</th>
			<th>商品名称</th>
			<th class="width-80">商品价格</th>
			<th class="width-80">操 作</th>
		</tr>

		<c:forEach items="${goodsList}" var="goods" varStatus="status">
			<!-- 模版数据 -->
			<tr>
				<td>${status.count}</td>
				<td>${goods.gName}</td>
				<td>${goods.gPrice}</td>
				<td><a href="goodsDelete?id=${goods.id}">删除</a> &nbsp;|&nbsp; <a
					href="goodsInfo?id=${goods.id}">修改</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
<!-- body-end  -->
</html>



