<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<meta charset="UTF-8">
<title>売上詳細削除確認</title>
</head>

<body>
<jsp:include page="Dashboard.jsp"></jsp:include>

	<div class="container-fluid">
		<!-- <div class="position-absolute top-50 start-50 translate-middle col-10"> -->
		<div class="offset-1 col-10" style="margin-top: 10vh;">
			<h1>売上詳細削除確認</h1>
			<form action="Sales0025" method="post" id="decide">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="date" class="col-form-label">販売日</label>
					</div>
					<div class="col-3 p-2">
						<input type="date" id="date" class="col-4 form-control"
							name="sale_date" placeholder="yyyy/mm/dd" value="<c:out value="${sales.getSale_date() }"></c:out>" readonly>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse ">
						<label for="account" class="col-form-label">担当
						</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" name="account_id" id="account" readonly>
                            <option value="<c:out value="${sales.getAccount_id()}"></c:out>" selected>
                            	<c:out value="${sales.getName()}"></c:out>
                            </option>
                        </select>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="category" class="col-form-label">商品カテゴリー</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" name="category_id" id="category" readonly>
							<option value="<c:out value="${sales.getCategory_id()}"></c:out>" selected>
                            	<c:out value="${sales.getCategory_name()}"></c:out>
                            </option>
						</select>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="trade" class="col-form-label">商品名</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" id="trade" class="form-control"
							name="trade_name" value="<c:out value="${sales.getTrade_name()}"></c:out>" placeholder="商品名" readonly>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="unit" class="col-form-label">単価</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea" id="unit" class="form-control" name="unit_price"
							value="<c:out value="${sales.getUnit_price()}"></c:out>" placeholder="単価" readonly>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="num" class="col-form-label">個数</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea" id="num" class="form-control"name="sale_number" value="<c:out value="${sales.getSale_number()}"></c:out>" placeholder="個数" readonly>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="note" class="col-form-label">備考</label>
					</div>
					<div class="col-6 p-2">
						<textarea class="form-control" id="note" name="note" placeholder="備考" readonly><c:out value="${sales.getNote()}"></c:out></textarea>
					</div>
				</div>
			</form>

				<div class="row d-flex justify-content-center mt-2">
					<div class="col-auto">
						<button type="submit" class="btn btn-danger" name="sale_id" 
						value="<c:out value="${sales.getSale_id() }"></c:out>" form="decide">✓OK</button>
					</div>
					<div class="col-auto">
						<form method="post" action="Sales0022" id="cancel">
							<button type="submit" class="btn btn-light" name="sale_id" 
							value="<c:out value="${sales.getSale_id() }"></c:out>" form="cancel">キャンセル</button>
						</form>
					</div>
				</div>
			
		</div>

	</div>
</body>

</html>

<!--valueの中身
form actionとOKとキャンセルボタンのリンク先の指定  -->

