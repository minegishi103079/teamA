/**
 * 
 */

// // キャンバスの要素を取得
//    const ctxt = document.getElementById('barChart').getContext('2d');
//
//    // 棒グラフを作成
//    const myBarChart = new Chart(ctxt, {
//      type: 'bar', // グラフの種類を指定
//      data: {
//        labels: [<c:forEach var="list" items="${category}">'<c:out value="${list.getCategory_name()}" />', </c:forEach>], // カテゴリ名を設定
//        datasets: [{
//          label: '色の出現回数', // データセットのラベルを設定
//          data: [<c:forEach var="list" items="${category}">'<c:out value="${list.getSum()}" />', </c:forEach> ], // データを設定
//          backgroundColor: [ // 各棒の背景色を設定
//            'rgba(255, 99, 132, 0.2)',
//            'rgba(54, 162, 235, 0.2)',
//            'rgba(255, 206, 86, 0.2)',
//            'rgba(75, 192, 192, 0.2)',
//            'rgba(153, 102, 255, 0.2)',
//            'rgba(255, 99, 132, 0.2)',
//          ],
//          borderColor: [ // 各棒の枠線の色を設定
//            'rgba(255, 99, 132, 1)',
//            'rgba(54, 162, 235, 1)',
//            'rgba(255, 206, 86, 1)',
//            'rgba(75, 192, 192, 1)',
//            'rgba(153, 102, 255, 1)'
//          ],
//          borderWidth: 1 // 枠線の太さを設定
//        }]
//      },
//      options: {
//        scales: {
//          y: {
//            beginAtZero: true // Y軸の最小値を0に設定
//          }
//        }
//      }
//    });