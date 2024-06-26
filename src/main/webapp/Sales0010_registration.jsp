<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/active.css" type="text/css">
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
	
	<c:if test="${ not empty s }">
	<div class="alert alert-primary alert-dismissible fade show d-flex align-items-center justify-content-center" role="alert">
	
		<c:out value="${ s }" />
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
						
					
	</c:if>


	<div class="container-fluid mt-3">
		<div class="offset-1 col-10" style="margin-top: 10vh;">
			<h1>売上登録</h1>
			<form class="form" action="Sales0010" method="post">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="date" class="col-form-label fw-bold">販売日
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-3 p-2">
						<input type="date" id="date" class="col-4 form-control"
							name="sale_date" placeholder="yyyy/mm/dd"
							value="<c:if test="${empty saleInsert }"><c:out value="${LocalDate.now() }" /></c:if><c:out value="${saleInsert.getSale_date() }"></c:out>" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse ">
						<label for="account" class="col-form-label fw-bold">担当
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" name="account_id" id="account"
							required>
							<c:if test="${ empty saleInsert.getAccount_id()}">
								<option value="" selected>選択してください</option>
							</c:if>
							<c:forEach var="accounts" items="${accountlist}">
								<option value="<c:out value="${accounts.getAccount_id()}"></c:out>"
									<c:if test="${accounts.getAccount_id() eq saleInsert.getAccount_id()}"> selected</c:if>
								>
									<c:out value="${accounts.getName()}"></c:out>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="category" class="col-form-label fw-bold">商品カテゴリー
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" name="category_id" id="category"
							required>
							<c:if test="${ empty saleInsert.getCategory_id()}">
								<option value="" selected>選択してください</option>
							</c:if>
							<c:forEach var="categories" items="${categories}">
								<option value="<c:out value="${categories.getCategory_id()}"/>"
									<c:if test="${categories.getCategory_id() eq saleInsert.getCategory_id()}"> selected</c:if>
								>
									<c:out value="${categories.getCategory_name()}"></c:out>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="trade" class="col-form-label fw-bold">商品名
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" id="trade" class="form-control"
							name="trade_name"
							value="<c:out value="${saleInsert.getTrade_name()}"></c:out>"
							placeholder="商品名" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="unit" class="col-form-label fw-bold">単価
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea" id="unit" class="form-control"
							name="unit_price"
							value="<c:out value="${saleInsert.getUnit_price()}"></c:out>"
							placeholder="単価" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="num" class="col-form-label fw-bold">個数
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea" id="num" class="form-control"
							name="sale_number"
							value="<c:out value="${saleInsert.getSale_number()}"></c:out>"
							placeholder="個数" required>
					</div>
				</div>

				<div class="row g-3 align-items">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="note" class="col-form-label fw-bold">備考</label>
					</div>
					<div class="col-6 p-2">
						<textarea class="form-control" id="note" name="note" rows="5"
							placeholder="備考"><c:out value="${saleInsert.getNote()}"></c:out></textarea>
					</div>
				</div>
				<div class="mx-auto p-2" style="width: 100px;">
					<button type="submit" class="btn btn-primary">✓登録</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>