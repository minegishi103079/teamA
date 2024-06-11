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
    <div class="container-fluid">
        <div class="position-absolute top-50 start-50 translate-middle col-10">
            <h1>売上詳細表示</h1>


            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    販売日
                </div>
                <div class="col-8">
                    2015/11/11
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    担当
                </div>
                <div class="col-8">
                    田中
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    商品カテゴリー
                </div>
                <div class="col-8">
                    食料品
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    商品名
                </div>
                <div class="col-8">
                    オレンジ
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    単価
                </div>
                <div class="col-8">
                    500
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    個数
                </div>
                <div class="col-8">
                    3
                </div>
            </div>

            <div class="row g-3 align-items-center p-3">
                <div class="col-4 d-flex flex-row-reverse">
                    備考
                </div>
                <div class="col-8">
                    テスト
                </div>
            </div>

            <div class="row d-flex justify-content-center mt-2">

                <div class="col-auto">
                    <button type="submit" class="btn btn-primary" href="#">✓編集</button>
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-danger" href="#">×削除</button>
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-light" href="#">キャンセル</button>
                </div>
                
            </div>

        </div>
    </div>

</body>

</html>