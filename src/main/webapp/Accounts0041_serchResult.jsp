<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="util.CommonUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-quiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="css/active.css" type="text/css">
	<title>アカウント検索結果表示</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container mt-5 justify-content-center">
		<h1>アカウント検索結果表示</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope style="width:15%">操作</th>
					<th scope style="width:10%">No</th>
					<th scope style="width:25%">氏名</th>
					<th scope style="width:25%">メールアドレス</th>
					<th scope style="width:auto">権限</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<form method="get" action="Accounts0042" id="edit">
				</form>
				<form method="get" action="Accounts0044" id="delete">
				</form>
					<c:forEach var="accountslist" items="${accountlist}">
						<tr>
						
							<td><button type ="submit" class="btn btn-primary text-nowrap" name="account_id" form="edit" 
								value="${accountslist.getAccount_id() }"<c:if test="${bean.getAuthority() != '3' }"> disabled</c:if>> ✓詳細 </button>
							<button type ="submit" class="btn btn-danger text-nowrap" name="account_id" form="delete" 
								value="${accountslist.getAccount_id() }"<c:if test="${bean.getAuthority() != '3' }"> disabled</c:if>> ×削除</button></td>
							<td><c:out value="${accountslist.getAccount_id()}" /></td> 
							<td><c:out value="${accountslist.getName()}" /></td>
							<td><c:out value="${accountslist.getMail()}" /></td>
							<td><c:out value="${CommonUtil.authorityFormat( accountslist.getAuthority() ) }" /></td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
	

</body>
</html>


