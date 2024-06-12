<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html;" charset="UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>アカウント登録確認画面</title>
</head>
<body>

<jsp:include page="Dashboard.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="position-absolute top-50 start-50 translate-middle col-10">
			<h1>アカウントを登録してよろしいですか？</h1>
			<form class="was-validated" action="">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">氏名
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" id="validationTextarea" value="<c:out value="${}"></c:out>"
							class="form-control" name="name" placeholder="氏名" disabled>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">メールアドレス
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="email" class="form-control" value="<c:out value="${}"></c:out>" name="mail" placeholder="メールアドレス" disabled>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">パスワード
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" value="<c:out value="${}"></c:out>" name="password" placeholder="パスワード" disabled>
					</div>
				</div>

                <div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">パスワード(確認)
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" value="<c:out value="${}"></c:out>" name="password" placeholder="パスワード(確認)" disabled>
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
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" disabled>
                            <label class="form-check-label" for="inlineRadio1">権限なし</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" disabled>
                            <label class="form-check-label" for="inlineRadio2">参照</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" disabled>
                            <label class="form-check-label" for="inlineRadio2">更新</label>
                          </div>
					</div>
				</div>


				<div class="mx-auto p-2" style="width: 100px;">
					<button type="submit" class="btn btn-primary" href="#">✓登録</button>
				</div>

			</form>
		</div>
	</div>
</body>
</html>



<!-- name,valueの中身まだです
リンクつないでないです -->
