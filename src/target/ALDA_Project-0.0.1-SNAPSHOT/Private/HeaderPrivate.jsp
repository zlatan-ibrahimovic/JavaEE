<div class="navbar navbar-inverse">

	<!-- Collect the nav links, forms, and other content for toggling -->
	<nav class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="<c:url value="/Home"/>"><span
					class="glyphicon glyphicon-home" aria-hidden="true"> </span></a></li>

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
		</ul>
	</nav>
</div>