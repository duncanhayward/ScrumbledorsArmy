﻿/**
 * 
 */
console.log('script was called')

var addCardBtn = 0;
var addTaskBtn = 0;
var viewTask = 0;
var task = 1;
var taskId=1;

var Tasks = [];

for (var i=0;i<10;i++) {
    Tasks[i] = [];
 }
//Tasks[1]={};
//Tasks[2]={};
//Tasks[3]={};
//Tasks[4]={};
//Tasks[5]={};
//Tasks[6]={};
//Tasks[7]={};
//Tasks[8]={};
//Tasks[9]={};
//Tasks[10]={};



var app = angular.module("routePage", ["ngRoute", "ngDragDrop", "ui.bootstrap"])
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


.directive('modalDialog', function() {
			  return {
			    restrict: 'E',
			    scope: {
			      show: '='
			    },
			    replace: true, // Replace with the template below
			    transclude: true, // we want to insert custom content inside the directive
			    link: function(scope, element, attrs) {
			      scope.dialogStyle = {};
			      if (attrs.width)
			        scope.dialogStyle.width = attrs.width;
			      if (attrs.height)
			        scope.dialogStyle.height = attrs.height;
			      scope.hideModal = function() {
			        scope.show = false;
			      };
			    },
			    template: "<div class='ng-modal' ng-show='show'><div class='ng-modal-overlay' ng-click='hideModal()'></div><div class='ng-modal-dialog' ng-style='dialogStyle'><div class='ng-modal-close' ng-click='hideModal()'>X</div><div class='ng-modal-dialog-content' ng-transclude></div></div></div>"
			  };
			})


.controller("registerCtrl", function($scope, $http, $location) {
	
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
             check = 0;

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
             email      :$scope.remail ,
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
	
	
//})

.controller("scrumPageCtrl", function($scope, $http, $location) {
	 console.log('scrumCtrl callled');
	 $scope.changeToScrum= function(){
		
			$location.path('/scrumboard');
		  }
	 
	 $scope.logout = function(){
         $location.path('/login');
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

.controller('scrumCtrl', function($scope, $compile, $location){
	
	var colId = 1;
	var cardId = 0;
	

	$scope.message="HELLO";
	
	$scope.addElement= function(){
		console.log("scrumCtrl function called");
		
		var inputBox = angular.element("<input type='text' id='nameLane' placeholder='Enter Swim Lane Name' ng-keyup='nameLane()'/>");
		var lanename = $compile(inputBox)($scope);
		angular.element(addLanes).append(lanename);
	}
		
	$scope.nameLane= function(){
		console.log("name lane controller activated");
		
		if(event.keyCode==13){
		var newe = angular.element("<div class='column' id='lane"+ colId++ + "' data-drop='true' data-jqyoui-options jqyoui-droppable=" + "{onDrop:'dropCallback'}" + " ><header>" + document.getElementById('nameLane').value +  "</header></div>");
		var newlane = $compile(newe)($scope);
		var target= document.getElementById("columns");
		angular.element(target).append(newlane);
		document.getElementById('nameLane').remove();
		
		if(addCardBtn == 0){
		var addCard = angular.element("<button class='btn btn-info' ng-click='writeStory()'>Add Card</button>");
		var card = $compile(addCard)($scope);
		angular.element(addLanes).append(card);
		addCardBtn = addCardBtn + 1;
			}
		}
	}
	
	$scope.writeStory= function(){
		console.log("write story controller activated");
		
		var userStory = angular.element("<textarea id='storyBox' placeholder='Enter Story Here' ng-keyup='addCard()'></textarea>");
		var story = $compile(userStory)($scope);
		angular.element(target).append(story);
	}
	
	$scope.addCard= function(){
		var storyCard = angular.element("<div class='card' id=" + cardId++ + " data-drag='true' jqyoui-draggable='{animate: true}' ng-Dblclick='addModal($event)'><div class='container-fluid'><p>" + document.getElementById('storyBox').value + "</p></div></div>");
		var stories = $compile(storyCard)($scope);
		
		if(event.keyCode == 13){
		angular.element(lane1).append(stories);
		document.getElementById('storyBox').remove();
		}
	}
	
//	$scope.addTaskBtn=function($event){
//		console.log("double clicked!");
//		
//		var element = angular.element($event.target.parentNode.parentNode);
//		console.log(element.attr("id"));
//		
//		var clicked = document.getElementById(element.attr("id"));
//		
//		console.log(clicked);
//		
////		console.log(cardId);
//		if(document.getElementById('addTask')==null){
//		var addTask = angular.element("<button class='btn btn-info' id='addTask' ng-click='addModal()'>Add Task</button> ");
//		var tasks = $compile(addTask)($scope);
//		
//
//		
//		
//		angular.element(clicked).append(tasks);
//		}
//	}
	
	$scope.addModal=function($event){
		console.log("add modal controller clicked");
		
//		<div class="modal fade in" id="addTaskModal" role="dialog" style="display: block;"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><h4 class="modal-title">Add Task</h4><button type="button" class="close" data-dismiss="modal">×</button></div><div class="modal-body"><textarea></textarea></div></div></div></div>
		
		var modal = angular.element("<div class='modal fade in' id='addTaskModal' role='dialog' style='display: block;'><div class='modal-dialog'><div class='modal-content'><div class='modal-header'><h4 class='modal-title'>Add Task</h4><button type='button' class='close' data-dismiss='modal'>&times;</button></div><div class='modal-body' id='addTask'><textarea id='" + taskId++ +  "' ng-keyup='addTask()'></textarea></div></div></div></div>");
		var addTaskModal = $compile(modal)($scope);
		angular.element(lane1).append(addTaskModal);
		
		console.log(addTaskModal);
		
		var element = angular.element($event.target.parentNode.parentNode);
		console.log("card that was clicked "+ element.attr("id"));
		
		var clicked = document.getElementById(element.attr("id"));
		
		$scope.clicked = clicked;
		
		
		
//		if(viewTask == 0){
		var viewTasks = angular.element("<a id='" + clicked.id + "'ng-click='viewTasks($event)'>View Tasks</a>");
		console.log("This is the element that was clicked id" + clicked.id);
		
		var viewT = $compile(viewTasks)($scope);
//		viewTask = viewTask + 1;
//		}
		
		angular.element(clicked).append(viewT);
			
		
//		document.getElementById('addTask').remove();
	}
	
	$scope.addTask=function(){
		console.log("in addTask controller");
		
		if(event.keyCode == 13){
			console.log("This is in the tasks: " + document.getElementById(taskId-1).value);
			Tasks[$scope.clicked.id][0]= $scope.clicked.id;
			//{"cardId" : $scope.clicked, "taskDesc" : document.getElementById(taskId-1).value};
			Tasks[$scope.clicked.id][1]=document.getElementById(taskId-1).value;
			
//			document.getElementById('addTaskModal').style.display = "none";
			document.getElementById('addTaskModal').remove();
		}
	}
	
	$scope.viewTasks=function($event){
		console.log("view tasks fn clicked!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
//		var element1 = angular.element($event.target.parentNode.parentNode);
		var clicked1 =$event.target.id;
		console.log('clicked1- '+ clicked1);
		var views = angular.element("<div class='modal fade in' id='viewTaskModal' role='dialog' style='display: block;'><div class='modal-dialog'><div class='modal-content'><div class='modal-header'><h4 class='modal-title'>View Task(s)</h4><button type='button' class='close' ng-click='close()' data-dismiss='modal'>&times;</button></div><div class='modal-body'><ul id='tasks'></ul></div></div></div></div></div>");
		var viewTs = $compile(views)($scope);
		
//		var thetasks = angular.element("<h1>A NEW TASK!</h1>");
//		var ttasks = $compile(thetasks)($scope);
//		
//		angular.element(document.getElementById('tasksGo')).append(ttasks);
		
//		console.log(Tasks[0]);
		
		
		//to get cardID : Tasks[2].cardId.id
		//to get task Value : Tasks[1].taskDesc
		
	
		
//		console.log("Checking clicked" + $scope.clicked1.id);
		
		angular.element(lane1).append(viewTs);
		
		for(i = 0; i < Tasks.length; i++){
			console.log('Task[][0]'+Tasks[i][0]);
			if(Tasks[i][0] == clicked1){
				console.log(Tasks[i][0] == clicked1);
//				var modal = angular.element( document.querySelector( '#tasks' ));
//				for(j=0;j<Tasks[i].length;j++){
				var thetask = angular.element("<li>" + Tasks[i][1] + "</li>");
				var theTaskS = $compile(thetask)($scope);
				
				console.log("----------------------------------" + task + "---------------------------------");
				
				var myEl = angular.element( document.querySelector( '#tasks' ) );
				
				myEl.append(theTaskS);
				
//				}
				
				}
		}
		
		
		
		
		
		
	}
	
	$scope.dropCallback=function($event){
		console.log("Successfully dragged to a new lane");
		
		var element = angular.element($event.target);
		console.log(element.attr("id"));
		
		
	}
	
	$scope.close=function(){
		document.getElementById("viewTaskModal").remove();
	}
	
	 $scope.logout = function(){
         $location.path('/login');
     }
	
})

