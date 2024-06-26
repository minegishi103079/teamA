<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html;" charset="UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/active.css" type="text/css">
<title>アカウント詳細編集画面</title>
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
			<h1>アカウント詳細編集</h1>
			<form class="form" action="Accounts0042" method="post">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label fw-bold">氏名
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="varidationTextarea" class="form-control" name="name"
							value="<c:out value="${accounts.getName()}"></c:out>"
							placeholder="氏名" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label fw-bold">メールアドレス
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="text" class="form-control" name="mail"
							value="<c:out value="${accounts.getMail()}"></c:out>"
							placeholder="メールアドレス" required>
					</div>
				</div>

				<div class="row g-3">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label fw-bold">パスワード
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" name="password1"
							value="<c:out value="${accounts.getPassword()}"></c:out>"
							placeholder="パスワード" required>
							<div class= "mt-1">英大文字・英小文字・数字・記号(!@;:)のうち3種類を含む8文字以上30文字以内にして下さい</div>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label fw-bold">パスワード(確認)
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" name="password2"
							value="<c:out value="${accounts.getPassword()}"></c:out>"
							placeholder="パスワード(確認)" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label fw-bold">権限
							<button type="button" class="btn btn-secondary btn-sm"
								value="<c:out value="${accounts.getAuthority()}"></c:out>"
								disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio1" value="0"
								<c:if test="${accounts.getAuthority()==0}">checked</c:if>>
							<label class="form-check-label" for="inlineRadio1">権限なし</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio2" value="1"
								<c:if test="${accounts.getAuthority()==1}">checked</c:if>>
							<label class="form-check-label" for="inlineRadio2">売上閲覧</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio3" value="2"
								<c:if test="${accounts.getAuthority()==2}">checked</c:if>>
							<label class="form-check-label" for="inlineRadio3">売上担当</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio4" value="3"
								<c:if test="${accounts.getAuthority()==3}">checked</c:if>>
							<label class="form-check-label" for="inlineRadio4">管理者</label>
						</div>
					</div>
				</div>

				<div class="d-grid gap-2 d-md-flex justify-content-center p-2">
					<button class="btn btn-primary" type="submit" name="account_id"
						value="<c:out value="${accounts.getAccount_id() }"></c:out>">✔更新</button>
					<a class="btn btn-light" href="Accounts0041">キャンセル</a>
				</div>

			</form>
		</div>
	</div>
</body>
</html>
