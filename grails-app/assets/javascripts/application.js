// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//

(function(){

	  var app = angular.module("loginApp", ['ngRoute']);
	  
	  app.config(['$routeProvider', function($routeProvider) {
            $routeProvider.
              when('/login', {
                templateUrl: '/LoginApp/fragments/login.html',
                controller: 'LoginCtrl'
              }).
              when('/logout', {
                  templateUrl: '/LoginApp/fragments/logout.html',
                  controller: 'LogoutCtrl'
                }).
              when('/register', {
                    templateUrl: '/LoginApp/fragments/register.html',
                    controller: 'RegisterCtrl'
                  }).
              when('/notes', {
                  templateUrl: '/LoginApp/fragments/notes.html',
                  controller: 'NotesCtrl'
                }).
            when('/created/:activationCode', {
                templateUrl: '/LoginApp/fragments/created.html',
                controller: 'ActivateCtrl'
              }).
              otherwise({
                redirectTo: '/login'
              });
          }]);
	  
	  
	  /*
	   * Main controller responsible for Login.
	   */
	  app.controller('LoginCtrl', function($scope, $http, LoginService, $location) {
		    $scope.username = '';
		    $scope.password = '';
		    $scope.status = '';
		    
		    $scope.login = function(){
		    	LoginService.login($scope.username, $scope.password).then(function(msg){
				    $scope.password = '';
			    	$location.path('/notes');
		    	}, function(msg){
		    		$scope.status = 'Login Failed, Please try again.';
		    	});
		    };
	  });
	  
	  /*
	   * Controller responsible for retrieving Notes (requires authentication).
	   */
	  app.controller('NotesCtrl', function($scope, $http, LoginService) {
		  $scope.greeting = 'Greeting from notes';
		  $scope.notes = [];
		  
		  var token = 'Bearer ' + LoginService.getToken();
		  		  
		  $http.get('/LoginApp/api/notes', {
			  headers : { 'Authorization': token }
		  }).then(function(response){
			  $scope.notes = response.data;
		  });
		  
	  });	  
	  
	  app.controller('LogoutCtrl', function($scope, LoginService) {
		  LoginService.clearToken();
	  });
	  
	  //TODO: Use $asyncValidators to validate in real time
	  app.controller('RegisterCtrl', function($scope, $http, $location) {
		  $scope.username = '';
		  $scope.email = '';
		  $scope.password = '';
		  $scope.message = '';
		  
		  $scope.register = function(){
			  
			  if (!$scope.registerForm.$valid){
				  console.log('form is not valid');
				  return;
			  }
			  
			  var data = {
					  username : $scope.username, 
					  password: $scope.password,
					  email: $scope.email
			  	};

			  $http.post('/LoginApp/api/users', data).then(function(response){
				    var activationCode = response.data.code
					$location.path('/created/' + activationCode);
				  }, function(response){
					  $scope.message = "Username/Email is not available, Try Another"
					  //$scope.message = response.data.message;
				});
		  };
		  
	  });
	  
	  app.controller('ActivateCtrl', function($scope, $routeParams) {
		  $scope.activationCode = $routeParams.activationCode;
	  });
	  
	  
	  /*
	   * Login Service responsible for getting an Access Token.
	   */
	  app.factory('LoginService', function($http, $q){
		  
		  var service = {};
		  var accessToken;
		  var refreshToken;
		  var TOKEN_KEY = "LoginAppToken";
		  
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
				  accessToken = response.data.access_token;
				  localStorage.setItem(TOKEN_KEY, accessToken); // LocalStorage
				  refreshToken = response.data.refresh_token;
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
			return localStorage.getItem(TOKEN_KEY);
		  };
		  
		  service.getHeaders = function(){
			return { 'Authorization': 'Bearer' + accessToken }  
		  };
		  
		  service.clearToken = function(){
			  localStorage.removeItem(TOKEN_KEY); // LocalStorage
			  accessToken = null;
			  refreshToken = null;
		  };
		  
		  return service;
	  });

	
})();