<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <meta charset="UTF-8">
    <title>売上詳細編集</title>
</head>

<body>
<jsp:include page="Dashboard.jsp"></jsp:include>

    <div class="container-fluid">
        <div class="position-absolute top-50 start-50 translate-middle col-10">
            <h1>売上詳細編集</h1>
            <form action="Sales0024" method="get">

                <div class="row g-3 align-items-center">
                    <div class="col-4 d-flex flex-row-reverse">
                        <label for="date" class="col-form-label">販売日
                            <button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
                        </label>
                    </div>
                    <div class="col-3 p-2">
                        <input type="date" id="date" class="col-4 form-control" name="date" placeholder="yyyy/mm/dd"
                            value="2014-01-05" required>
                    </div>
                </div>

                <div class="row g-3 align-items-center">
                    <div class="col-4 d-flex flex-row-reverse ">
                        <label for="account" class="col-form-label">担当
                            <button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
                        </label>
                    </div>
                    <div class="col-6 p-2">
                        <select class="form-select" name="Responsible" id="account" required>
                            <option value="account_id" disabled selected>accountName</option>
                            <option value="高">高</option>
                            <option value="中">中</option>
                            <option value="低">低</option>
                        </select>
                    </div>
                </div>

                <div class="row align-items-center">
                    <div class="col-4 d-flex flex-row-reverse">
                        <label for="category" class="col-form-label">商品カテゴリー
                            <button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
                        </label>
                    </div>
                    <div class="col-6 p-2">
                        <select class="form-select" name="goodscategory" id="category" required>
                            <option value="category_id" disabled selected>categoryName</option>
                            <option value="高">高</option>
                            <option value="中">中</option>
                            <option value="低">低</option>
                        </select>
                    </div>
                </div>

                <div class="row g-3 align-items-center">
                    <div class="col-4 d-flex flex-row-reverse">
                        <label for="trade" class="col-form-label">商品名
                            <button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
                        </label>
                    </div>
                    <div class="col-6 p-2">
                        <input type="textarea" id="trade" class="form-control" name="goodsname" value="trade_name"
                        placeholder="商品名" required>
                    </div>
                </div>

                <div class="row g-3 align-items-center">
                    <div class="col-4 d-flex flex-row-reverse">
                        <label for="unit" class="col-form-label">単価
                            <button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
                        </label>
                    </div>
                    <div class="col-3 p-2">
                        <input type="textarea" id="unit" class="form-control" name="price" value="unit_price" placeholder="単価" required>
                    </div>
                </div>

                <div class="row g-3 align-items-center">
                    <div class="col-4 d-flex flex-row-reverse">
                        <label for="num" class="col-form-label">個数
                            <button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
                        </label>
                    </div>
                    <div class="col-3 p-2">
                        <input type="textarea" id="num" class="form-control" name="quantity" value="sale_number"
                        placeholder="個数" required>
                    </div>
                </div>

                <div class="row g-3 align-items-center">
                    <div class="col-4 d-flex flex-row-reverse">
                        <label for="note" class="col-form-label">備考</label>
                    </div>
                    <div class="col-6 p-2">
                        <textarea class="form-control" id="note" name="textarea" placeholder="備考" required>note</textarea>
                    </div>
                </div>

                <div class="row d-flex justify-content-center mt-2">
                    <div class="col-auto">
                        <button type="submit" class="btn btn-primary">✓更新</button>
                    </div>
                    <div class="col-auto">
                        <a type="submit" class="btn btn-light" href="Sales0021">キャンセル</a>
                    </div>
                </div>
            </form>
        </div>
       
    </div>
</body>

</html>