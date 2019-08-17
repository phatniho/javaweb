<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<title>员工管理</title>
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

th.width-50 {
	width: 50px;
}

th.width-64 {
	width: 64px;
}

th.width-80 {
	width: 80px;
}

th.width-120 {
	width: 100px;
}

hr {
	margin-bottom: 20px;
	border: 1px solid #aaa;
}

#add-cashier {
	text-align: center;
	font-size: 20px;
}
</style>

<script type="text/javascript">
	
</script>
</head>
<body>
	<h2>员工管理</h2>
	<div id="add-cashier">
		<a href="userAdd" target="rightFrame">新增员工</a>
	</div>
	<hr />
	<table border="1">
		<tr>
			<th class="width-40">序号</th>
			<th class="width-120">所属门店</th>
			<th class="width-50">员工姓名</th>
			<th class="width-50">密码</th>
			<th class="width-80">操 作</th>
		</tr>

		<!-- 模版数据 -->
		<c:forEach items="${cashierList}" var="cashier" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><c:forEach items="${doorList}" var="door">
						${door.id == cashier.doorId ? door.name:""}
					</c:forEach></td>
				<td>${cashier.cName}</td>
				<td>${cashier.cPwd}</td>
				<td><a href="cashierDelete?id=${cashier.cId}">删除</a>
					&nbsp;|&nbsp; <a href="cashierInfo?id=${cashier.cId}">修改</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
<!-- body-end  -->
</html>



