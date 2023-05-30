google.charts.load('current', {
	'packages': ['bar']
});
google.charts.setOnLoadCallback(drawChart);

let resultAry = [];
fetch('adminChart.do')
	.then(resolve => resolve.json())
	.then(result => {
		resultAry.push(['판매자', '수수료']);
		for (prop in result) {
			let name = result[prop].mbName + "/" + result[prop].tpName;
			let count = 0;
			if (result[prop].topPermiss == 'O') {
				count = Math.floor(result[prop].price * 0.1);
			} else if (result[prop].topPermiss == 'X') {
				count = Math.floor(result[prop].price * 0.05);
			}
			resultAry.push([name, count]);
		}
		google.charts.setOnLoadCallback(drawChart);
		console.log(resultAry);
	})
	.catch(reject => console.log(reject));

function drawChart() {
	var data = google.visualization.arrayToDataTable(resultAry);

	var options = {
		bars: 'vertical',
		vAxis: {
			format: 'decimal'
		},
		height: 400,
		colors: ['#2BCBBA']
	};

	var chart = new google.charts.Bar(document.getElementById('chart_div'));
	chart.draw(data, google.charts.Bar.convertOptions(options));
}