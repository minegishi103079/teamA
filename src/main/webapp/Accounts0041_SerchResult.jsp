<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="util.CommonUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-quiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
	<title></title>
</head>
<body>

	<jsp:include page="Dashboard.jsp"></jsp:include>
	<div class="container mt-5 justify-content-center">
		<h1>アカウント検索結果表示</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">操作</th>
					<th scope="col">No</th>
					<th scope="col">氏名</th>
					<th scope="col">メールアドレス</th>
					<th scope="col">権限</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<form method="post" action="">
					<c:forEach var="saleslist" items="${salelist}">
						<tr>
						
							<td><button type ="submit" class="btn btn-primary" name="sale_id" value="${saleslist.getSale_id() }"> ✓詳細 </button>
							<button type ="submit" class="btn btn-danger" name="sale_id" value="${saleslist.getSale_id() }"> ×削除</button></td>
							<td><c:out value="${saleslist.getSale_id()}" /></td> <%--No --%>
							<td><c:out value="${CommonUtil.localDateFormat( saleslist.getSale_date() )}" /></td> <%-- 販売日--%>
							<td><c:out value="${saleslist.getName()}" /></td> <%--担当 --%>
							<td><c:out value="${saleslist.getCategory_name()}" /></td> <%-- 商品カテゴリー--%>
							<td><c:out value="${saleslist.getTrade_name()}" /></td> <%-- 商品名--%>
							<td><c:out value="${CommonUtil.numberComma( saleslist.getUnit_price() )}" /></td> <%-- 単価--%>
							<td><c:out value="${CommonUtil.numberComma( saleslist.getSale_number() )}" /></td> <%-- 個数--%>
							<td><c:out value="${saleslist.getUnit_price() * saleslist.getSale_number()}" /></td> <%-- 小計--%>
						</tr>
					</c:forEach>
				</form>
			</tbody>
		</table>
	</div>

</body>
</html>


