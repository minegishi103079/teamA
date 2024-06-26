/**
 * 
 */


 const ctx = document.getElementById('lineChart').getContext('2d');
    const myLineChart = new Chart(ctx, {
      type: 'line', // グラフの種類を指定
      data: {
        labels: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
        datasets: [{
          label: '2024年 月別売上',
          data: [a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12],
          borderColor: 'rgba(75, 192, 192, 1)',
          tension: 0.1 // 折れ線のカーブ率を指定
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });