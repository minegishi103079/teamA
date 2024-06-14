<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<meta charset="UTF-8">
<title>売上登録</title>
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

	<div class="container-fluid mt-3">
		<!-- <div class="position-absolute top-50 start-50 translate-middle col-10"> -->
		<div class="offset-1 col-10" style="margin-top: 10vh;">
			<h1>売上登録</h1>
			<form class="form" action="Sales0011check_Servlet" method="get">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">販売日
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-3 p-2">
						<input type="date" id="validationTextarea"class="col-4 form-control" name="sale_date" placeholder="yyyy/mm/dd" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse ">
						<label for="varidationTextarea" class="col-form-label">担当
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" name="account_id" required>
							<option value="" disabled selected>選択してください</option>
							<c:forEach var="accounts" items="${accounts}">
							<option value="<c:out value="${accounts.getAccount_id()}"></c:out>"><c:out value="${accounts.getName()}"></c:out></option>
							</c:forEach>
						</select>
						
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">商品カテゴリー
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" name="category_id" required>
							<option value="" disabled selected>選択してください</option>
							<c:forEach var="categories" items="${categories}">
							<option value="<c:out value="${categories.getCategory_id()}"></c:out>"><c:out value="${categories.getCategory_name()}"></c:out></option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">商品名
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" id="validationTextarea"
							class="form-control" name="trade_name" placeholder="商品名" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">単価
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea" id="validationTextarea"
							class="form-control" name="unit_price" placeholder="単価" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">個数
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea" id="validationTextarea"
							class="form-control" name="sale_number" placeholder="個数" required>
					</div>
				</div>

				<div class="row g-3 align-items">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="Text" class="col-form-label">備考</label>
					</div>
					<div class="col-6 p-2">
						<textarea name="note" class="form-control" id="Textarea" rows="3" placeholder="備考"></textarea>
					</div>
				</div>

				<div class="mx-auto p-2" style="width: 100px;">
					<button type="submit" class="btn btn-primary" href="Sale0011_check.jsp">✓登録</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>