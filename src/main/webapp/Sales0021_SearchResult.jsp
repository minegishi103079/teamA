<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			<c:forEach var="saleslist" items="${sales}"><%--varとitems の中身書く --%>
				<tr>
					<td><buttontype ="submit" class="btn btn-primary"> ✓詳細 </button</td>
					<td><c:out value="${saleslist.getSale_id()}" /></td> <%--No --%>
					<td><c:out value="${saleslist.getSale_date()}" /></td> <%-- 販売日--%>
					<td><c:out value="${saleslist.getAccount_id()}" /></td> <%--担当 --%>
					<td><c:out value="${saleslist.getCategory_id()}" /></td> <%-- 商品カテゴリー--%>
					<td><c:out value="${saleslist.getCategory_id()}" /></td> <%-- 商品名--%>
					<td><c:out value="${saleslist.getUnit_price()}" /></td> <%-- 単価--%>
					<td><c:out value="${saleslist.getSale_number()}" /></td> <%-- 個数--%>
					<td><c:out value="${saleslist.getUnit_price() * saleslist.getSale_number()}" /></td> <%-- 小計--%>
>>>>>>> branch 'master' of https://github.com/minegishi103079/teamA.git
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>

<%--varとitems の中身書く --%>
<%-- --%>

