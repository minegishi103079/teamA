<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- c:out 未実装 -->

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <meta charset="UTF-8">
    <title>売上詳細表示</title>
</head>

<body>

<jsp:include page="Dashboard.jsp"></jsp:include>

    <div class="container-fluid">
        <div class="position-absolute top-50 start-50 translate-middle col-10">
            <h1>売上詳細表示</h1>


            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    販売日
                </div>
                <div class="col-6">
                    <c:out value="${sales.getSale_date() }"></c:out>
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    担当
                </div>
                <div class="col-6">
                    <c:out value="${sales.getName()}"></c:out>
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    商品カテゴリー
                </div>
                <div class="col-6">
                    <c:out value="${sales.getCategory_name()}"></c:out>
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    商品名
                </div>
                <div class="col-6">
                    <c:out value="${sales.getTrade_name()}"></c:out>
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    単価
                </div>
                <div class="col-6">
                    <c:out value="${sales.getUnit_price()}"></c:out>
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    個数
                </div>
                <div class="col-6">
                    <c:out value="${sales.getSale_number()}"></c:out>
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    備考
                </div>
                <div class="col-6">
                    <c:out value="${sales.getNote()}"></c:out>
                </div>
            </div>

            <div class="row d-flex justify-content-center mt-2">

                <div class="col-auto">
                	<form class="" action="Sales0023" method="get" id="edit">
                    	<button type="submit" class="btn btn-primary" name="sales" value="${sales }" for="edit">✓編集</button>
                    </form>
                </div>
                <div class="col-auto">
	                <form class="" action="Sales0025" method="get" id="delete">
    	                <button type="submit" class="btn btn-danger" name="sales" value="${sales }" for="delete">×削除</button>
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