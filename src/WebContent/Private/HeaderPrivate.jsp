<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/Home"/>"><span
					class="glyphicon glyphicon-home" aria-hidden="true"> </span></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="/MySpace"/>">MySpace </a></li>
				<li><a href="<c:url value="/MyAnnounces"/>">My Announces</a></li>
				<li><a href="<c:url value="/NewAnnounce"/>">New Announces</a></li>
				<li><a href="<c:url value="/MyFavoritesAnnounces"/>">My Favorites Announces</a></li>
				<li><a href="<c:url value="/Deconnexion"/>">Deconnexion</a></li>
				<li><a href="#" class="btn btn-info btn-lg">
         		 <span class="glyphicon glyphicon-user"></span> ${sessionUser.name}
        		</a></li>
        		
			</ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    