<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Welcome</title>
		<!-- JQuery -->
		<asset:javascript src="lib/jquery/dist/jquery.js"/>

		<!-- BootStrap -->
		<asset:stylesheet src="lib/bootstrap/dist/css/bootstrap.css"/>
		<asset:stylesheet src="lib/bootstrap/dist/css/bootstrap-theme.css"/>
		<asset:javascript src="lib/bootstrap/dist/js/bootstrap.js"/>
		
		<!-- Angular -->
		<asset:javascript src="lib/angular/angular.js"/>
		
		<!-- Application -->
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>		
</head>
<body>

    <div class="container" data-ng-app="loginApp">

      <form class="form-signin" data-ng-controller="LoginCtrl">
        <h1>Status: {{status}}</h1>
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" placeholder="Username" required autofocus required data-ng-model="username">
        <input type="password" class="form-control" placeholder="Password" required data-ng-model="password">
        <button class="btn btn-lg btn-primary btn-block" type="submit" data-ng-click="login()">Sign in</button>
      </form>
      
      <hr>
      
      <form class="form-signin">
        <h2 class="form-signin-heading">Register</h2>
        <input type="text" class="form-control" placeholder="UserName" required autofocus>
        <input type="email" class="form-control" placeholder="Email address" required autofocus>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
      </form>      

    </div> <!-- /container -->

</body>
</html>
