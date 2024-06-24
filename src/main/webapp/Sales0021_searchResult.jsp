<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="util.CommonUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-quiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="css/active.css" type="text/css">
	<title>売上検索結果表示</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container mt-5 justify-content-center">
		<div class="ms-5 me-5">
		<h1>売上検索結果表示</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">操作</th>
					<th scope="col">No</th>
					<th scope="col">販売日</th>
					<th scope="col">担当</th>
					<th scope="col">商品カテゴリー</th>
					<th scope="col">商品名</th>
					<th scope="col">単価</th>
					<th scope="col">個数</th>
					<th scope="col">小計</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<form method="post" action="Sales0022">
					<c:forEach var="saleslist" items="${salelist}">
						<tr>
							<td><button type ="submit" class="btn btn-primary text-nowrap" name="sale_id" value="${saleslist.getSale_id() }"> 詳細 </button</td>
							<td><c:out value="${saleslist.getSale_id()}" /></td>
							<td><c:out value="${CommonUtil.localDateFormat( saleslist.getSale_date() )}" /></td>
							<td><c:out value="${saleslist.getName()}" /></td>
							<td><c:out value="${saleslist.getCategory_name()}" /></td>
							<td><c:out value="${saleslist.getTrade_name()}" /></td>
							<td><c:out value="${CommonUtil.numberComma( saleslist.getUnit_price() )}" /></td>
							<td><c:out value="${CommonUtil.numberComma( saleslist.getSale_number() )}" /></td>
							<td><c:out value="${saleslist.getUnit_price() * saleslist.getSale_number()}" /></td>
						</tr>
					</c:forEach>
				</form>
			</tbody>
		</table>
		</div>
	</div>

</body>
</html>



