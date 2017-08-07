/*
	JavaScript for the Drag & Drop Example
*/


app.controller('scrumCtrl', function($scope){

	$scope.message="HELLO";
	
	$scope.addElement= function(){
		console.log("scrumCtrl function called")
		var newLane = document.createElement('div');
		newLane.className = "column";
		newLane.id = "div" + divCount++;
		newLane.setAttribute("ondrop", "drop(event)");
		newLane.setAttribute("ondragover", "allowDrop(event)");
		newLane.setAttribute("draggable", "true");
		
		//creating header for column that will display swim lane name
		newLaneHeader = document.createElement("header");
		newLaneHeader.innerHTML = document.getElementById('lane_name').value;
		
		newLane.appendChild(newLaneHeader);
		
		document.getElementById('columns').appendChild(newLane);
		document.getElementById('columns').removeChild(document.getElementById('lane_name'));
		
		//after a swim lane is on the board, you can begin adding cards (stories)
		if (document.getElementById('addCard') == null){
		createAddCardBtn();
		}
		
		//with each swim lane added, update width of page to house all lanes without vertical scroll
//		updateWidth();
	}
	
})


//
//var count = 0;
//var divCount = 0;
//var colCount = 0;
//
//function updateWidth(){
//	if(colCount > 4){
//	// colCount = $('#columns > div').length;
//	colCount++;
//	var pgWidth = colCount * 250;
//	document.body.style.width = pgWidth + 'px';
//	console.log(pgWidth);
//	}else{
//		colCount++;
//		document.body.style.width = '1250px';
//	}
//	
//	console.log(colCount);
//}
//
//	function nameLane(){
//		var laneName = document.createElement('input');
//		laneName.id = "lane_name";
//		laneName.setAttribute("type", "text");
//		laneName.setAttribute("placeholder", "Enter Lane Name");
//		laneName.addEventListener("keyup", function(event){
//			//check to see if the enter key was pressed
//			if (event.which === 13) {
//			//if so, run the addTask function
//		addNewLane();}});
//		
//		document.getElementById('columns').appendChild(laneName);
//	}
//	
//	function addNewLane(){
//		//creating new column (swim lane)
//		
//		
//	}
//
//	function createAddCardBtn(){
//		//adding an Add Card button to the view
//		var addCardBtn = document.createElement('button');
//		addCardBtn.id = "addCard";
//		addCardBtn.className = "btn btn-info";
//		addCardBtn.innerHTML = "Add Card";
//		addCardBtn.addEventListener("click", addNewCard);
//		
//		var container = document.createElement('div');
//		container.className = "container-fluid";
//		
//		container.appendChild(addCardBtn);
//		
//		document.body.appendChild(container);
//	}
//
//	function addNewCard(){
//		//this textarea will take in the user story
//		var story = document.createElement('textarea');
//		story.id = "storyInput";
//		story.row = 15;
//		
//		//when user hits enter inside textarea, it will add story to swim lane
//		document.getElementById('columns').appendChild(story);
//		document.getElementById('storyInput').addEventListener('keyup', function(event){
//			//check to see if the enter key was pressed
//			if (event.which === 13) {
//			//if so, run the addTask function
//		addCard();}})
//	}
//	
//	function addCard(){
//		count++;
//		
//		//creating the story card
//		var newCard = document.createElement('div'); // this works
//		newCard.className = "card"; //this works
//		newCard.id = "drag" + count; // this works
//		newCard.draggable = "true"; // this works
//		newCard.ondragstart = function drag(ev){ev.dataTransfer.setData("text", ev.target.id);}
//		//when this card is double-clicked, it will reveal an Add Task button
//		newCard.addEventListener("dblclick", addBtn);
//		
//		nc1 = document.createElement('div'); //this works
//		nc1.className = "container-fluid"; //this works
//		
//		nc2 = document.createElement('p'); //this works
//		nc2.innerHTML = document.getElementById("storyInput").value; //this works
//		
//		nc1.appendChild(nc2); //this works
//		newCard.appendChild(nc1); //this works
//		
//		document.getElementById('div0').appendChild(newCard);
//		// document.body.appendChild(newCard);
//		columns.removeChild(document.getElementById('storyInput'));
//	}
//	
//	function addBtn(){
//		// if there isn't already an Add Task button, add one to card
//		if(document.getElementById('addBtn') == null){
//		console.log("added button");
//		//get id of element that triggered event
//		console.log(this.id);
//		var btn = document.createElement('button');
//		btn.id = "addBtn";
//		btn.type = "button";
//		btn.className = "btn btn-info btn-lg";
//		btn.innerHTML  = "Add Task";
//		
//		// this allows for the modal to appear when button pressed
//		btn.setAttribute("data-toggle", "modal");
//		btn.setAttribute("data-target", "#addTaskModal");
//		btn.addEventListener("click", editAddFunc);
//		
//		document.getElementById(this.id).appendChild(btn);
//		}
//	}
//	
//	function editAddFunc(){
//		//creating modal to handle adding tasks
//		console.log("Clicked on!");
//		var popup = document.createElement('div');
//		popup.className = "modal fade";
//		popup.id = "addTaskModal";
//		popup.setAttribute("role", "dialog");
//		
//		var dialog = document.createElement('div');
//		dialog.className = "modal-dialog";
//		
//		var content = document.createElement('div');
//		content.className = "modal-content";
//		
//		var header = document.createElement('div');
//		header.className = "modal-header";
//		
//		var btn = document.createElement('button');
//		btn.type = "button";
//		btn.className = "close";
//		btn.setAttribute("data-dismiss", "modal");
//		btn.innerHTML = "&times;"
//		
//		var title = document.createElement('h4');
//		title.className = "modal-title";
//		title.innerText = "Add Task";
//		
//		var modalBody = document.createElement('div');
//		modalBody.className = "modal-body";
//		
//		var pText = document.createElement('textarea');
//		
//		//gluing all the pieces of the modal together
//		modalBody.appendChild(pText);
//		btn.appendChild(header);
//		content.appendChild(header);
//		header.appendChild(title);
//		header.appendChild(btn);
//		content.appendChild(modalBody);
//		dialog.appendChild(content);
//		popup.appendChild(dialog);	
//		
//		popup.addEventListener("keyup", function(event){
//			//check to see if the enter key was pressed
//			if (event.which === 13) {
//			//if so, run the addTask function
//		addTask();}})
//		
//		// console.log(popup); 
//		// document.getElementById('drag1').removeChild(document.getElementById('addBtn'));
//		document.body.appendChild(popup);
//	}
//	
//	function addTask(){
//		console.log("adding Task");
//		//close modal window after enter hit
//		$("#addTaskModal .close").click()
//		
//		var storyAddedTo = document.getElementById('addBtn').parentNode.id;
//		if(document.getElementById('tl_id') == null){
//		var tasksLink = document.createElement('button');
//
//		//add View Tasks button 
//		tasksLink.id = "tl_id";
//		tasksLink.type = "button";
//		tasksLink.className = "btn btn-info btn-lg";
//		tasksLink.innerHTML = "View Tasks";
//		
//		//link the button to the modal window
//		tasksLink.setAttribute("data-toggle", "modal");
//		tasksLink.setAttribute("data-target", "#viewTaskModal");
//		tasksLink.addEventListener("click", viewTasks);
//		
//		//add link to current story to view tasks
//		document.getElementById(storyAddedTo).appendChild(tasksLink);
//		}
//		
//		//remove add button from story
//		document.getElementById(storyAddedTo).removeChild(document.getElementById('addBtn'));
//	}
//	
//	function viewTasks(){
//		console.log("Registered click on View Tasks");
//		
//		var trig = document.getElementById(this.id);
//		console.log(trig.parentElement.id);
//		
//		// creating ul list with (potentially dynamic) li
//		var ulist = document.createElement('ul');
//		// var litem = document.createElement('li');
//		// litem.setAttribute("data-ng-repeat", "task in tasks");
//		// litem.innerHTML = '{{ task }}';
//		
//		// ulist.appendChild(litem);
//		
//		//creating Modal
//		var viewTaskPopup = document.createElement('div');
//		viewTaskPopup.className = "modal fade";
//		viewTaskPopup.id = "viewTaskModal";
//		viewTaskPopup.setAttribute("role", "dialog");
//		
//		var dialog = document.createElement('div');
//		dialog.className = "modal-dialog";
//		
//		var content = document.createElement('div');
//		content.className = "modal-content";
//		
//		var header = document.createElement('div');
//		header.className = "modal-header";
//		
//		var btn = document.createElement('button');
//		btn.type = "button";
//		btn.className = "close";
//		btn.setAttribute("data-dismiss", "modal");
//		btn.innerHTML = "&times;"
//		
//		var title = document.createElement('h4');
//		title.className = "modal-title";
//		title.innerText = "View Task(s)";
//		
//		var modalBody = document.createElement('div');
//		modalBody.className = "modal-body";
//		
//		var pText = document.createElement('p');
//		pText.innerText = "This is where the tasks will go";
//		
//		modalBody.appendChild(pText);
//		
//		// piecing together modal box
//		modalBody.appendChild(ulist);
//		btn.appendChild(header);
//		content.appendChild(header);
//		header.appendChild(title);
//		header.appendChild(btn);
//		content.appendChild(modalBody);
//		dialog.appendChild(content);
//		viewTaskPopup.appendChild(dialog);
//		
//		console.log(viewTaskPopup);
//		document.body.appendChild(viewTaskPopup);
//		document.getElementById(trig.parentElement.id).removeChild(document.getElementById('tl_id'));
//		
//	}