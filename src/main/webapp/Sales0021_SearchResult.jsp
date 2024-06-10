<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-quiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
	<title></title>
</head>
<body>
	<div class="container mt-5 justify-content-center">
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
			<c:forEach var="" items="${}"><%--varとitems の中身書く --%>
				<tr>
					<td><buttontype ="submit" class="btn btn-primary"> ✓詳細 </button</td>
					<td><c:out value="${}" /></td> <%--No --%>
					<td><c:out value="${}" /></td> <%-- 販売日--%>
					<td><c:out value="${}" /></td> <%--担当 --%>
					<td><c:out value="${}" /></td> <%-- 商品カテゴリー--%>
					<td><c:out value="${}" /></td> <%-- 商品名--%>
					<td><c:out value="${}" /></td> <%-- 単価--%>
					<td><c:out value="${}" /></td> <%-- 個数--%>
					<td><c:out value="${}" /></td> <%-- 小計--%>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>

<%--varとitems の中身書く --%>
<%-- --%>

