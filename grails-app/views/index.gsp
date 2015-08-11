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
		<asset:javascript src="lib/angular-route/angular-route.js"/>
		
		
		<!-- Application -->
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>

</head>
<body>

    <div class="container" data-ng-app="loginApp">
		<div ng-view></div>
    </div> 

</body>
</html>
