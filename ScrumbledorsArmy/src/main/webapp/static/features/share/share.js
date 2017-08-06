/**
 * 
 */

angular.module('shareApp', [])

.controller('shareController', function($http) {

	console.log('loading shareController');

	var data = {
		adminUser : {
			id : 1,
			username : 'TKing',
			password : '123',
			email : 'tking@email.com'
		},
		sharedUser : {
			id : 2,
			username : 'BWingo',
			password : '123',
			email : 'bwingo@email.com'
		},
		sharedBoard : {
			id : 1,
			name : 'Project1',
			description : 'Its a project about nothing.'
		},
		roleId : 2
	}

	console.log(data);

	$http({
		method : "POST",
		url : "http://localhost:8085/ScrumbledorsArmy/share",
		data : data,
		headers : {
			'Content-Type' : 'application/json'
		}
	}).then(function(status) {
		console.log(status);
	}, function(status) {
		console.log(status);
	});

})