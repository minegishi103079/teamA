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

	<jsp:include page="header.jsp"></jsp:include>
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
				<form method="get" action="Accounts0042_DetailsEditServlet" id="edit">
				</form>
				<form method="get" action="Accounts0044_DetailsEditdeleteServlet" id="delete">
				</form>
					<c:forEach var="accountslist" items="${accountlist}">
						<tr>
						
							<td><button type ="submit" class="btn btn-primary" name="sale_id" form="edit" value="${accountslist.getAccount_id() }"> ✓詳細 </button>
							<button type ="submit" class="btn btn-danger" name="sale_id" form="delete" value="${accountslist.getAccount_id() }"> ×削除</button></td>
							<td><c:out value="${accountslist.getAccount_id()}" /></td> <%--No --%>
							<td><c:out value="${accountslist.getName()}" /></td> <%--氏名 --%>
							<td><c:out value="${accountslist.getMail()}" /></td> <%--メール --%>
							<td><c:out value="${accounts.getAuthority() }" /></td> <%-- 権限--%>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>


