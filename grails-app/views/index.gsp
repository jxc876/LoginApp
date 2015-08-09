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
		
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>		
</head>
<body>
    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="email" class="form-control" placeholder="Email address" required autofocus>
        <input type="password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
      
      <hr>
      
      <form class="form-signin">
        <h2 class="form-signin-heading">Register</h2>
        <input type="email" class="form-control" placeholder="UserName" required autofocus>
        <input type="email" class="form-control" placeholder="Email address" required autofocus>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
      </form>      

    </div> <!-- /container -->

</body>
</html>
