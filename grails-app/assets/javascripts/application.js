// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//

(function(){

	  var app = angular.module("loginApp", []);
	  
	  /*
	   * Main controller responsible for Login.
	   */
	  app.controller('LoginCtrl', function($scope, $http, LoginService, $location) {
		    $scope.username = '';
		    $scope.password = '';
		    $scope.status = '';
		    
		    $scope.login = function(){
		    	LoginService.login($scope.username, $scope.password).then(function(msg){
		    		$scope.status = msg;
			    	// $location.path('/');
		    	}, function(msg){
		    		$scope.status = msg;
		    	});
		    };
	  });
	  
	  /*
	   * Login Service responsible for getting an Access Token.
	   */
	  app.factory('LoginService', function($http, $q){
		  
		  var service = {};
		  var accessToken;
		  var refreshToken;
		  
		  /*
		   * Retrieves Access Token from REST API, the token can then be used on
		   * subsequent calls to authenticate. 
		   */
		  service.login = function(username, password){
			  var data = {username : username, password: password}
			  
			  var deferred = $q.defer();
			  
			  $http.post('/LoginApp/api/login', data).then(function(response){
				  // 200 - OK
				  console.log('Login Sucessful');
				  accessToken = response.access_token;
				  refreshToken = response.refresh_token;
				  deferred.resolve('Login Successful');
				  
			  }, function (response){
				  // 401 - Unauthorized
				 console.log('Error while trying to get token');
				 console.log(response);
				 deferred.reject('Login Failed');
				 
			  });
			  return deferred.promise;
		  };
		  
		  service.getToken = function(){
			console.log('fetching Access Token');
			return accessToken;   
		  };
		  
		  service.clearToken = function(){
			  accessToken = null;
			  refreshToken = null;
		  };
		  
		  
		  return service;
	  });

	
})();