<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="util.CommonUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- c:out 未実装 -->

<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/active.css" type="text/css">
<meta charset="UTF-8">
<title>売上詳細表示</title>
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container-fluid">

		<div class="offset-1 col-10" style="margin-top: 10vh;">
			<h1>売上詳細表示</h1>


			<div class="row g-3 align-items-center p-3">
				<div class="col-4 d-flex flex-row-reverse fw-bold">販売日</div>
				<div class="col-6">
					<c:out value="${CommonUtil.localDateFormat(sales.getSale_date()) }"></c:out>
				</div>
			</div>

			<div class="row g-3 align-items-center p-3">
				<div class="col-4 d-flex flex-row-reverse fw-bold">担当</div>
				<div class="col-6">
					<c:out value="${sales.getName()}"></c:out>
				</div>
			</div>

			<div class="row g-3 align-items-center p-3">
				<div class="col-4 d-flex flex-row-reverse fw-bold">商品カテゴリー</div>
				<div class="col-6">
					<c:out value="${sales.getCategory_name()}"></c:out>
				</div>
			</div>

			<div class="row g-3 align-items-center p-3">
				<div class="col-4 d-flex flex-row-reverse fw-bold">商品名</div>
				<div class="col-6">
					<c:out value="${sales.getTrade_name()}"></c:out>
				</div>
			</div>

			<div class="row g-3 align-items-center p-3">
				<div class="col-4 d-flex flex-row-reverse fw-bold">単価</div>
				<div class="col-6">
					<c:out value="${sales.getUnit_price()}"></c:out>
				</div>
			</div>

			<div class="row g-3 align-items-center p-3">
				<div class="col-4 d-flex flex-row-reverse fw-bold">個数</div>
				<div class="col-6">
					<c:out value="${sales.getSale_number()}"></c:out>
				</div>
			</div>

			<div class="row g-3 align-items-center p-3">
				<div class="col-4 d-flex flex-row-reverse fw-bold">備考</div>
				<div class="col-6">
					<c:out value="${sales.getNote()}"></c:out>
				</div>
			</div>
			<div class="row d-flex justify-content-center mt-2">
				<div class="col-auto">
					<form class="" action="Sales0023" method="get" id="edit">
						<button type="submit" class="btn btn-primary" name="sale_id" for="edit"
							value="<c:out value="${sales.getSale_id() }"></c:out>"
							<c:if test="${bean.getAuthority() < 2 }"> disabled</c:if> >✓編集</button>
					</form>
				</div>
				<div class="col-auto">
					<form class="" action="Sales0025" method="get" id="delete">
						<button type="submit" class="btn btn-danger" name="sale_id" for="delete"
							value="<c:out value="${sales.getSale_id() }"></c:out>"
							<c:if test="${bean.getAuthority() < 2 }"> disabled</c:if> >×削除</button>
					</form>
				</div>
				<div class="col-auto">
					<a type="submit" class="btn btn-light" href="Sales0021">キャンセル</a>
				</div>
			</div>

		</div>
	</div>

</body>


</html>