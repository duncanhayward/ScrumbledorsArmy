/**
 * 
 */
  //[] tells angular to create a project with the name passed in 
								  //not providing the [] will tell angular one already exists


	/*
	*	Services
	*
	*	-Services allow you to create a reusable set of functions and values that can be passed across
	*the application. 
	*	-Services are useful for getting data from a database, as well as firing save, edit, and delete operations
	*	-Services can share data between controllers
	*
	*/
	

app.service('boardservice', function($rootScope, $compile, $scope){
	
		
		this.loadB = function(){
			//<div class='column' id='lane"+ $rootScope.user.boardRoles[i].brId.board.id  + "' data-drop='true' data-jqyoui-options jqyoui-droppable=" + "{onDrop:'dropCallback'}" + " ><header>"$rootScope.user.boardRoles[i].brId.board.id"</header></div>");
			console.log('Swimlane length = '+ $rootScope.user.boardRoles[$rootScope.currentBoardIndex].brId.board.swimLanes.length);
			
			for(i=0; i<$rootScope.user.boardRoles[$rootScope.currentBoardIndex].brId.board.swimLanes.length;i++){
				
				var newL = angular.element("<div class='column' id='"+ $rootScope.user.boardRoles[$rootScope.currentBoardIndex].brId.board.swimLanes[i].id  + "' data-drop='true' data-jqyoui-options jqyoui-droppable=" + "{onDrop:'dropCallback'}" + " ><header>"+ $rootScope.user.boardRoles[$rootScope.currentBoardIndex].brId.board.swimLanes[i].description +"</header></div>");
				var newLane = $compile(newL)($scope);
				var target= angular.element( document.querySelector( '#columns' ));//document.getElementById("allBoards");
				angular.element(target).append(newLane);
			}
			
			//loadBoardData();
		}
		
	})
