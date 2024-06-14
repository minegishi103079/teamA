<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html;" charset="UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>アカウント登録画面</title>
</head>
<body>

<jsp:include page="Dashboard.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="offset-1 col-10" style="margin-top: 10vh;">
			<h1>アカウントを登録してよろしいですか</h1>
			<form class="form" action="Accounts0030_RegistrationServlet" method="post">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse ">
						<label for="varidationTextarea" class="col-form-label">氏名
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" id="validationTextarea" value="<c:out value="${name}"></c:out>"
							class="form-control bg-secondary-subtle" name="name" placeholder="氏名" readonly>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">メールアドレス
						<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="email" class="form-control bg-secondary-subtle"  value="<c:out value="${mail}"></c:out>" 
						name="mail" placeholder="メールアドレス" readonly>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">パスワード
						<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control bg-secondary-subtle" value="<c:out value="${password1}"></c:out>"
						 name="password1" placeholder="パスワード" readonly>
					</div>
				</div>

                <div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">パスワード(確認)
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control bg-secondary-subtle" value="<c:out value="${password2}"></c:out>" 
						name="password2" placeholder="パスワード(確認)" readonly>
					</div>
				</div>

                <div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">権限
						<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio1" 
                            value="0" <c:if test="${authority==0}">checked</c:if> readonly> 
                            <label class="form-check-label" for="inlineRadio1">権限なし</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio2" 
                            value="1" <c:if test="${authority==1}">checked</c:if> readonly>
                            <label class="form-check-label" for="inlineRadio2">売上閲覧</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio3" 
                            value="2" <c:if test="${authority==2}">checked</c:if> readonly>
                            <label class="form-check-label" for="inlineRadio3">売上担当</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio4" 
                            value="3" <c:if test="${authority==3}">checked</c:if> readonly>
                            <label class="form-check-label" for="inlineRadio4">管理者</label>
                          </div>
					</div>
				</div>


					<div class="d-grid gap-2 d-md-flex justify-content-center p-2">
					  <button class="btn btn-primary" type="submit" href="#">OK</button>
					  <a class="btn btn-light" href="Accounts0030_Registration.jsp">キャンセル</a>
					</div>
				</div>

			</form>
		</div>
	</div>
</body>
</html>
