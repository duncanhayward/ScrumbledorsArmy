/**
 * 
 */



var app = angular.module("index", [])

.controller("loginController", function($scope, $http) {
  
  var username = "jay";
  var password = "123";
  
  $scope.username = '';
  $scope.password = '';


 
  
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
            url: '/login',
            headers: {'Content-Type': 'application/json',  'Accept': 'application/json'},
//            data: user//user 
            data: user  
          }).then(function successCallback(response) 
            {
        		
        		$scope.response= JSON.stringify(response.data.username);
        		console.log('response.data->'+$scope.response);
            	console.log(response);
            	if($scope.response=='null'){
            		console.log('Login Failed!!')
            	}
            	else {
            		console.log('Login Successfull');
            		 $('.login').css('display', 'none');
            	}
 
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            	console.log('Not found');
//            	console.log(response);
        });

        console.log('User->'+user.username);
        
     
    }
});