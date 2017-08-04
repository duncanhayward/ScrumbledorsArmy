/**
 * 
 */
Date.prototype.addDays = function(days) {
    var dat = new Date(this.valueOf())
    dat.setDate(dat.getDate() + days);
    return dat;
}

function getDates(startDate, stopDate) {
    var dateArray = new Array();
    var currentDate = startDate;
    while (currentDate <= stopDate) {
        dateArray.push( new Date (currentDate) )
        currentDate = currentDate.addDays(1);
    }
    return dateArray;
}
var range=getDates(new Date(2012, 08, 1),new Date(2012, 08, 15));
console.log(range);
var y=[101,99,95,80,75,68,50,45,42,39,35,20,15,0];
var dps=[];
app.controller('ChartController', function($scope) {
	 $scope.chart = new CanvasJS.Chart("chartContainer", {
		 
		 
		 	theme: 'theme1',
		 
		    title:{
		    	text: "Basic Burndown chart" 
		    	},
		    	
		    animationEnabled: true,
		    axisY: {
		             includeZero: true,
		         },
		 
		    axisX: {
		        	 valueFormatString:'MMM DD',
		        	 
		    
		        	 interval: 1,
		        	 
		        	 intervalType:"day"
		         },
		         
		         data: [{
		        	 		type: "area",
		        	        markerSize:8,
		        	        dataPoints:dps
		        	 
		        	       }]
		        	 
		        	     });
	 function parseDatapoints(){
		 for(var i=dps.length; i<range.length;i++){
			 dps.push({
				 x:range[i],
				 y:y[i]
			 });	
		 }
	 };
	 function addDatapoints(){
		 parseDatapoints();
		$scope.chart.options.data[0].dataPoints=dps;
		 $scope.chart.render();
	 }
	 addDatapoints();
	 


});

