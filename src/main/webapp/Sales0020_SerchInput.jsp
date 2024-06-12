<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Dashboard.jsp"></jsp:include>
	
	<c:if test="${ not empty errors }">
		<div class="alert alert-danger" role="alert">
			<c:forEach var="error" items="${ errors }">
				<c:out value="${ error }" />
			</c:forEach>
		</div>
	</c:if>



	<div class="container-fluid">

		<div class="position-absolute top-50 start-50 translate-middle col-10">
			<h1>売上検索条件入力</h1>
			
			<form name="form" action="Sales0021" method="post">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label class="col-form-label">販売日</label>
					</div>

					<div class="col-6 p-2">
						<div class="row">
							<div class="col-5 p-2">
								<input type="date" class="col-4 form-control" name="date1"
									placeholder="yyyy/mm/dd">
							</div>
							<div class="col-2 p-2 ">
								<label class="d-flex justify-content-center">～</label>
							</div>

							<div class="col-5 p-2">

								<input type="date" class="col-4 form-control" name="date2"
									placeholder="yyyy/mm/dd">
							</div>
						</div>
					</div>

				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse ">
						<label class="col-form-label" for="account">担当</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" aria-label="select example"
							name="account_id" id="account">
							<option value="" selected>選択してください</option>
							<c:forEach var="accounts" items="${accounts}">
								<option value="<c:out value="${accounts.getAccount_id()}"/>">
									<c:out value="${accounts.getName()}"></c:out>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="row align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label class="col-form-label" for="category">商品カテゴリー</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" aria-label="select example"
							name="category_id" id="category" >
							<option value="" selected>選択してください</option>
							<c:forEach var="categories" items="${categories}">
								<option value="<c:out value="${categories.getCategory_id()}"/>">
									<c:out value="${categories.getCategory_name()}"></c:out>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label class="col-form-label" for="trade" >商品名
							<button type="button" class="btn btn-secondary btn-sm" disabled>部分一致</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" class="form-control" name="trade_name" id="trade"
							placeholder="商品名">
					</div>
				</div>


				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label class="col-form-label" for="note">備考
							<button type="button" class="btn btn-secondary btn-sm" disabled>部分一致</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" class="form-control" placeholder="備考" name="note" id="note" ></input>
					</div>
				</div>

				<div class="d-grid gap-2 d-md-flex justify-content-center mt-2">
					<button type="submit" class="btn btn-primary">検索</button>
					<a class="btn btn-light" href="Sales0020">クリア</a>
				</div>

			</form>
		</div>
	</div>
</body>
</html>

<!-- 
・チェックのエラーメッセージ（販売日、件数）
・検索、クリアボタンのリンクの指定　→完了
・nameは適当なのでわかりやすいものに変更したほうがいいかも　→完了
 -->