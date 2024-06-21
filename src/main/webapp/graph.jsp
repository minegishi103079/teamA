<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/active.css" type="text/css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


<div class="col-6">
 <canvas id="lineChart"></canvas>
 <script type="text/javascript">
  var a1 = 100;
  var a2 = 100;
  var a3 = 100;
  var a4 = 100;
  var a5 = 100;
  var a6 = 100;
  var a7 = 100;
  var a8 = 100;
  var a9 = 100;
  var a10 = 100;
  var a11 = 100;
  var a12 = 100;
</script>
  <script src="js/monthlySale.js"></script>
  
</div>

<div class="col-10">
<canvas id="barChart"></canvas>
  <script>
    // キャンバスの要素を取得
    const ctxt = document.getElementById('barChart').getContext('2d');

    // 棒グラフを作成
    const myBarChart = new Chart(ctxt, {
      type: 'bar', // グラフの種類を指定
      data: {
        labels: ['赤', '青', '黄', '緑', '紫'], // カテゴリ名を設定
        datasets: [{
          label: '色の出現回数', // データセットのラベルを設定
          data: [12, 19, 3, 5, 2], // データを設定
          backgroundColor: [ // 各棒の背景色を設定
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)'
          ],
          borderColor: [ // 各棒の枠線の色を設定
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)'
          ],
          borderWidth: 1 // 枠線の太さを設定
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true // Y軸の最小値を0に設定
          }
        }
      }
    });
  </script>
</div>
  
</body>
</html>