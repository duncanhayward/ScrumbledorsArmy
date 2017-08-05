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
console.log('script was called')

var app = angular
		.module("routePage", [ "ngRoute" ])
		.config(function($routeProvider) {
			$routeProvider.when("/", {
				templateUrl : "login.html",
				controller : "loginCtrl"

			}).when("/home", {
				templateUrl : "home.html",
				controller : "scrumPageCtrl"
			}).when("/login", {
				templateUrl : "login.html",
				controller : "loginCtrl"
			}).when("/register", {
				templateUrl : "register.html",
				controller : "registerCtrl"
			}).when("/scrumboard", {
				templateUrl : "dragDropEx.html",
				controller : 'scrumCtrl'
			}).when("/burndown",{
				templateUrl:"Test.html",
				controller:'BurndownCtrl'
				
			});
		})

		.config([ '$locationProvider', function($locationProvider) {
			$locationProvider.hashPrefix('');
		} ])

		.controller(
				"registerCtrl",
				function($scope, $http, $location) {
					$('.rmessage').css('display', 'none');
					var check = 0;
					var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

					console.log('Register Ctrl Called');
					$scope.ValidateRegister = function() {
						$scope.rmessage = '';
						$('.rmessage').css('display', 'none');

						console.log('ValidateRegister() callled');

						if ($scope.rpassword == "" || $scope.rcpassword == ""
								|| $scope.rusername == ""
								|| $scope.remail == "") {
							$scope.rmessage += 'Fields Left Empty! \n';
							check = 1;
						}

						if ($scope.rpassword != $scope.rcpassword) {
							$scope.rmessage += 'Passwords Do Not Match! \n';
							check = 1;
						}

						if (!filter.test($scope.remail)) {
							$scope.rmessage += 'Email is Invalid! \n'
							check = 1;
						}

						if (check == 1) {
							$('.rmessage').css('display', 'block');
							console.log('Validations failed');

						} else {

							console.log('Validations passed');
							$scope.registerUser();
						}

				
					}
					$scope.changePageToLogin = function() {
						$location.path('/login');
					}
					
					$scope.registerUser = function() {
						

						var ruser = {
							email 	 :$scope.remail ,
							username : $scope.rusername,
							password : $scope.rpassword
						};

						console.log('User->' + ruser.username);
						console.log('id->' + ruser.email);
						console.log('password->' + ruser.password);

						$http({
							method : 'POST',
							url : 'http://localhost:8085/ScrumbledorsArmy/register',
							headers : {
								'Content-Type' : 'application/json',
								'Accept' : 'application/json'
							},
							// data: user//user
							data : ruser
						}).then(function successCallback(response) {

							$scope.response = JSON.stringify(response.data.username);
							console.log('response.data->' + $scope.response);
							console.log(response.status);
							if (response.status != 200) {
								console.log('Register Failed!!');

							} else {
								console.log('Register Successfull');
								$location.path('/login');
								// $('.login').css('display', 'none');
							}

						}, function errorCallback(response) {
							// called asynchronously if an error occurs
							// or server returns response with an error status.
							console.log('Not found');
							// console.log(response);
						});

						console.log('User->' + ruser.username);
						
						}
					
		})
					
					
.controller('ChartController', function($scope) {
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
		        	 valueFormatString:'DD',
		        	 
		    
		        	 interval: 1,
		        	 
		        	 intervalType:"day"
		         },
		    toolTip:{
		    	enabled:false
		    	
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
	 


})
			

		.controller("scrumPageCtrl", function($scope, $http, $location) {
			console.log('scrumCtrl callled');
			$scope.changeToScrum = function() {

				$location.path('/scrumboard');
			}

		})

		.controller("loginCtrl", function($scope, $http, $location) {
			var username = "jay";
			var password = "123";

			$scope.username = '';
			$scope.password = '';

			$scope.changePageToRegister = function() {
				$location.path('/register');
			}

			$scope.login = function() {
				console.log($scope.username);

				var user = {
					id : '0',
					username : $scope.username,
					password : $scope.password
				};

				console.log('User->' + user.username);
				console.log('id->' + user.id);
				console.log('password->' + user.password);

				$http({
					method : 'POST',
					url : 'http://localhost:8085/ScrumbledorsArmy/login',
					headers : {
						'Content-Type' : 'application/json',
						'Accept' : 'application/json'
					},
					// data: user//user
					data : user
				}).then(function successCallback(response) {

					$scope.response = JSON.stringify(response.data.username);
					console.log('response.data->' + $scope.response);
					console.log(response.status);
					if (response.status != 200) {
						console.log('Login Failed!!')

					} else {
						console.log('Login Successfull');
						$location.path('/home');
						// $('.login').css('display', 'none');
					}

				}, function errorCallback(response) {
					// called asynchronously if an error occurs
					// or server returns response with an error status.
					console.log('Not found');
					// console.log(response);
				});

				console.log('User->' + user.username);

			}
		})

		.controller('scrumCtrl', function($scope) {

			$scope.message = "HELLO";

			$scope.addElement = function() {
				console.log("scrumCtrl function called");

				var newe = angular.element("<div class= 'column'>Test</div>");
				var target = document.getElementById("target");
				angular.element(target).append(newe);
				// var newLane = document.createElement('div');
				// newLane.className = "column";
				// newLane.id = "div" + divCount++;
				// newLane.setAttribute("ondrop", "drop(event)");
				// newLane.setAttribute("ondragover", "allowDrop(event)");
				// newLane.setAttribute("draggable", "true");
				//		
				// //creating header for column that will display swim lane name
				// newLaneHeader = document.createElement("header");
				// newLaneHeader.innerHTML =
				// document.getElementById('lane_name').value;
				//		
				// newLane.appendChild(newLaneHeader);
				//		
				// document.getElementById('columns').appendChild(newLane);
				// document.getElementById('columns').removeChild(document.getElementById('lane_name'));
				//		
				// //after a swim lane is on the board, you can begin adding
				// cards (stories)
				// if (document.getElementById('addCard') == null){
				// createAddCardBtn();
				// }

				// with each swim lane added, update width of page to house all
				// lanes without vertical scroll
				// updateWidth();
			}

		})
