<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html;" charset="UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>login</title>
</head>
<body class="bg-light">

<c:if test="${ not empty errors }">
		<div class="alert alert-danger" role="alert">
			<c:forEach var="error" items="${ errors }">
				<c:out value="${ error }" />
			</c:forEach>
		</div>
	</c:if>
<form name="form" action="C0010_login" method="post">
	<div class="row mt-5">
		<div class="position-relative">
			<div class="nav justify-content-center">
				<div class="card bg-light border-0 p-4">
					<div class="card-body">
						<h3>物品売上管理システム</h3>
						<input type="email" class="form-control"id="exampleFormControlInput1" name="mail" placeholder="メールアドレス" required> 
						<input type="password" id="inputPassword5" class="form-control mt-2" name="password" placeholder="パスワード" required>
						<div class="d-grid gap-2 mt-2">
							<button type="submit" class="btn btn-primary">ログイン</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>	
</body>


</html>
