<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html;" charset="UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/active.css" type="text/css">
<title>アカウント検索条件入力</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<c:if test="${ not empty errors }">
		<div class="alert alert-danger" role="alert">
			<c:forEach var="error" items="${ errors }">
				<c:out value="${ error }" />
			</c:forEach>
		</div>
	</c:if>


	<div class="container-fluid">
		<div class="offset-1 col-10" style="margin-top: 10vh;">
			<h1>アカウント検索条件入力</h1>
			<form class="form" action="Accounts0040" method="post">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label fw-bold">氏名
							<button type="button" class="btn btn-secondary btn-sm" disabled>部分一致</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" id="validationTextarea "
							class="form-control" name="name" placeholder="氏名">
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label fw-bold">メールアドレス</label>
					</div>
					<div class="col-6 p-2">
						<input type="text" class="form-control" name="mail"
							placeholder="メールアドレス">
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label fw-bold">権限</label>
					</div>
					<div class="col-6 p-2">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio1" value="0"> <label
								class="form-check-label" for="inlineRadio1">権限なし</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio2" value="1"> <label
								class="form-check-label" for="inlineRadio2">売上閲覧</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio3" value="2"> <label
								class="form-check-label" for="inlineRadio3">売上担当</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio4" value="3"> <label
								class="form-check-label" for="inlineRadio4">管理者</label>
						</div>
					</div>
				</div>
				<div class="d-grid gap-2 d-md-flex justify-content-center p-2">
					<button class="btn btn-primary" type="submit">🔍検索</button>
					<a class="btn btn-light" href="Accounts0040">クリア</a>
				</div>


			</form>
		</div>
	</div>
</body>
</html>
