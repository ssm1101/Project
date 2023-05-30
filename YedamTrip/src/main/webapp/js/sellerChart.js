google.charts.load('current', {
	'packages': ['bar']
});
google.charts.setOnLoadCallback(drawChart);

let resultAry = [];
fetch('sellerChart.do')
	.then(resolve => resolve.json())
	.then(result => {
		resultAry.push(['패키지 명', '판매 건수', '수입']);
		for (prop in result) {
			let name = result[prop].tpName;
			let count = result[prop].count;
			let price = result[prop].price;
			resultAry.push([name, count, price]);
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
		colors: ['#2BCBBA', '#A65EEA']
	};

	var chart = new google.charts.Bar(document.getElementById('chart_div'));
	chart.draw(data, google.charts.Bar.convertOptions(options));
}