/**
 * 
 */
console.log('script was called')
var app = angular.module("routePage", ["ngRoute"])
    .config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "login.html",
        controller : "loginCtrl"
       
    })
    .when("/home", {
        templateUrl : "home.html",
        controller : "scrumPageCtrl"
    })
    .when("/login", {
        templateUrl : "login.html",
          controller : "loginCtrl"
    })
    .when("/register", {
        templateUrl : "register.html",
        controller : "registerCtrl"
    })
      .when("/scrumboard", {
        templateUrl : "dragDropEx.html",
        controller: 'scrumCtrl'	
    });
})

.config(['$locationProvider', function($locationProvider) {
  $locationProvider.hashPrefix('');
}])

.controller("registerCtrl", function($scope, $http, $location) {
	
	 $scope.changePageToLogin= function(){
			$location.path('/login');
		  }
	
	
})

.controller("scrumPageCtrl", function($scope, $http, $location) {
	 console.log('scrumCtrl callled');
	 $scope.changeToScrum= function(){
		
			$location.path('/scrumboard');
		  }
	
	
})

.controller("loginCtrl", function($scope, $http, $location) {
  var username = "jay";
  var password = "123";
  
  $scope.username = '';
  $scope.password = '';


  $scope.changePageToRegister= function(){
	$location.path('/register');
  }
 
  
  $scope.login = function() {
    console.log($scope.username);

    	var user= {
    		id: '0',
    		username: $scope.username,
    		password : $scope.password
    	};
    	
    	console.log('User->'+user.username);
    	console.log('id->'+user.id);
    	console.log('password->'+user.password);
    	
        $http({
            method: 'POST',
            url: 'http://localhost:8085/ScrumbledorsArmy/login',
            headers: {'Content-Type': 'application/json',  'Accept': 'application/json'},
//            data: user//user 
            data: user  
          }).then(function successCallback(response) 
            {
        		
        		$scope.response= JSON.stringify(response.data.username);
        		console.log('response.data->'+$scope.response);
            	console.log(response.status);
            	if(response.status!=200){
            		console.log('Login Failed!!')
            		
            	}
            	else {
            		console.log('Login Successfull');
            		$location.path('/home');
//            		 $('.login').css('display', 'none');
            	}
 
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            	console.log('Not found');
//            	console.log(response);
        });

        console.log('User->'+user.username);
        
     
    }
})

.controller('scrumCtrl', function($scope){

	$scope.message="HELLO";
	
	$scope.addElement= function(){
		console.log("scrumCtrl function called");
		
		var newe = angular.element("<div class= 'column'>Test</div>");
		var target= document.getElementById("target");
		angular.element(target).append(newe);
//		var newLane = document.createElement('div');
//		newLane.className = "column";
//		newLane.id = "div" + divCount++;
//		newLane.setAttribute("ondrop", "drop(event)");
//		newLane.setAttribute("ondragover", "allowDrop(event)");
//		newLane.setAttribute("draggable", "true");
//		
//		//creating header for column that will display swim lane name
//		newLaneHeader = document.createElement("header");
//		newLaneHeader.innerHTML = document.getElementById('lane_name').value;
//		
//		newLane.appendChild(newLaneHeader);
//		
//		document.getElementById('columns').appendChild(newLane);
//		document.getElementById('columns').removeChild(document.getElementById('lane_name'));
//		
//		//after a swim lane is on the board, you can begin adding cards (stories)
//		if (document.getElementById('addCard') == null){
//		createAddCardBtn();
//		}
		
		//with each swim lane added, update width of page to house all lanes without vertical scroll
//		updateWidth();
	}
	
})


