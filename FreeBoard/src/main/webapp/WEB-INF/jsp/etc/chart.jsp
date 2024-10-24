<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      var chartData = [['Writer', 'Count per Writer']]; //차트데이터 담을 변수 선언
      
      //서버리소스 호출
      fetch('countByWriter.do') //url
      .then(resolve => resolve.json())
      .then(result => {
    	  //result값 확인
    	  console.log(result);
    	  result.forEach((row)=>{
    		  chartData.push([row.member_name, row.count]) //매개값
    	  });
    	  google.charts.load('current', {'packages':['corechart']});
          google.charts.setOnLoadCallback(drawChart);
    	  //console.log(chartData);
      })
      .catch(err => console.log(err));
      
      

      function drawChart() {

        var data = google.visualization.arrayToDataTable(chartData
        	/*
        	[
          ['Task', 'Hours per Day'], //화면에 보이지는 않지만 항목에 대한 설명
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7],
          ['Test',    3]
        ]
        	*/);

        var options = {
          title: '사용자별 게시글 현황'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      } // end of drawChart.
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
