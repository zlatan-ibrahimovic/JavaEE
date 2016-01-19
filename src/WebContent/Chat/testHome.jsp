<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>ChezZlatan</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <!-- CSS code from Bootply.com editor -->
        
        <style type="text/css">
            /*
A custom Bootstrap 3.1 template
from http://bootply.com

This CSS code should follow the 'bootstrap.css'
in your HTML file.

license: MIT
author: bootply.com
*/

html,body {
	height:100%;
    background:center no-repeat fixed url('/assets/example/bg_suburb.jpg');
    background-size: cover;
}

.icon-bar {
	background-color:#fff;
}

.navbar-trans {
	background-color:#279ddd;
    color:#fff;
}

.navbar-trans li>a:hover,.navbar-trans li>a:focus,.navbar-trans li.active {
	background-color:#38afef;
}

.navbar-trans a{
    color:#fefefe;
}

.navbar-trans .form-control:focus {
	border-color: #eee;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,0.075),0 0 8px rgba(100,100,100,0.6);
	box-shadow: inset 0 1px 1px rgba(0,0,0,0.075),0 0 8px rgba(100,100,100,0.6);
}

section {
	padding-top:70px;  
    padding-bottom:50px; 
    min-height:calc(100% - 1px);
}

.v-center {
    padding-top:10%;
    font-size:70px;
}
  
.well {
	border-color:transparent;
}

a.list-group-item.active,[class*='-info'] {
	background-color: #168ccc;
    color:#fff;
}
  
#section1 {
	background-color: #168ccc;
    color:#dedeff;
}
  
#section2 {
	background-color: #e5e5ef;
    color:#686868;
}
  
#section3 {
	background-color: #168ccc;
    color:#ddd;
}

#section4 {
	background-color: #fff;
    color:#444;
}

#section5,#section7,#section7 a {
    color:#f5f5f5;
}

#section6 {
	background-color: #168ccc;
    color:#ddd;
}

footer {
	background-color:#494949;
    color:#ddd;
    min-height:100px;
    padding-top:20px;
    padding-bottom:40px;
}

footer .nav>li>a {
    padding:3px;
    color:#ccc;
}

footer .nav>li>a:hover {
    background-color:transparent;
	color:#fff;
}
        </style>
</head>
<body>

<nav class="navbar navbar-trans navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapsible">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">IMO</a>
    </div>
    <div class="navbar-collapse collapse" id="navbar-collapsible">
      <ul class="nav navbar-nav navbar-left">
        <li><a href="#section1">What</a></li>
        <li><a href="#section2">Registration</a></li>
        <li><a href="#section3">Connection</a></li>
        <li><a href="#section4">Team</a></li>
        <li><a href="#section5">Five</a></li>
        <li><a href="#section6">Why</a></li>
        <li><a href="#section7">Who</a></li>
        <li>&nbsp;</li>
      </ul>
      <form class="navbar-form">
        <div class="form-group" style="display:inline;">
          <div class="input-group"> 
            <div class="input-group-btn">
              <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-chevron-down"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#">Category 1</a></li>
                <li><a href="#">Category 2</a></li>
                <li><a href="#">Category 3</a></li>
                <li><a href="#">Category 4</a></li>
                <li><a href="#">Category 5</a></li> 
              </ul>
            </div>
            <input type="text" class="form-control" placeholder="What are searching for?">
            <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span> </span>
          </div>
        </div>
      </form>
    </div>
  </div>
</nav>

<section class="container-fluid" id="section1">
  	<h1 class="text-center v-center">Sectionalize.</h1>
 	
  	<div class="container">
      <div class="row">
          <div class="col-sm-4">
            <div class="row">
              <div class="col-sm-10 col-sm-offset-2 text-center"><h3>Robust</h3><p>There is other content and snippets of details or features that can be placed here..</p><i class="fa fa-cog fa-5x"></i></div>
            </div>
          </div>
          <div class="col-sm-4 text-center">
            <div class="row">
              <div class="col-sm-10 col-sm-offset-1 text-center"><h3>Simple</h3><p>You may also want to create content that compells users to scroll down more..</p><i class="fa fa-user fa-5x"></i></div>
            </div>
          </div>
          <div class="col-sm-4 text-center">
            <div class="row">
              <div class="col-sm-10 text-center"><h3>Clean</h3><p>In the first 30 seconds of a user's visit to your site they decide if they're going to stay..</p><i class="fa fa-mobile fa-5x"></i></div>
            </div>
          </div>
      </div><!--/row-->
    <div class="row"><br></div>
  </div><!--/container-->
</section>

<section class="container-fluid" id="section2">
  <div class="row">
  	<div class="col-sm-8 col-sm-offset-2 text-center">
          <%@ include file="../WEB-INF/Registration.jsp" %> 	
    </div>
  </div>
</section>

<section class="container-fluid" id="section3">
	<div class="row">
  	<div class="col-sm-8 col-sm-offset-2 text-center">
     
        <%@ include file="../WEB-INF/Connection.jsp" %> 	
    </div>
    </div>
</section>

<section class="container-fluid" id="section4">
	<h2 class="text-center">Change this Content. Change the world.</h2>
    <div class="row">
      <div class="col-sm-8 col-sm-offset-2">
      <img src="/assets/example/bg_smartphones.jpg" class="img-responsive center-block ">
      <p class="text-center">Images will scale down proportionately as browser width narrows.</p>
      </div>
    </div>
</section>

<section class="container-fluid" id="section5">
  <div class="col-sm-10 col-sm-offset-1">
    <div class="container">
    <div class="row">
      <div class="col-sm-4 col-xs-12">
            <div class="list-group">
              <a href="#" class="list-group-item active">
                <h2 class="list-group-item-heading">Basic</h2>
                <h6>Free to get started</h6>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 100 - more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 2 - this is more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 3 GB</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 4</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Feature</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Feature</p>
              </a>
              <a href="#" class="list-group-item">
                <button class="btn btn-primary btn-lg btn-block">Get Started</button>
              </a>
            </div>
      </div><!--/left-->
      
      <div class="col-sm-4 col-xs-12">
            <div class="list-group text-center">
              <a href="#" class="list-group-item active">
                <h2 class="list-group-item-heading">Better</h2>
                <h6>Most popular plan</h6>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 200 - more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 2 - this is more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 5 GB</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 6</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Feature</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Feature</p>
              </a>
              <a href="#" class="list-group-item">
                <button class="btn btn-default btn-lg btn-block">$10 per month</button>
              </a>
            </div>
      </div><!--/middle-->
      
      <div class="col-sm-4 col-xs-12">
            <div class="list-group text-right">
              <a href="#" class="list-group-item active">
                <h2 class="list-group-item-heading">Best</h2>
                <h6>For enterprise grade</h6>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 100 - more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 2 - this is more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 8 GB</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 10</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Unlimited</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Unlimited</p>
              </a>
              <a href="#" class="list-group-item">
                <button class="btn btn-default btn-lg btn-block">$20 per month</button>
              </a>
            </div>
      </div><!--/right-->
      
    </div><!--/row-->
    </div><!--/container--> 
  </div>
</section>

<section class="container-fluid" id="section6">
	<h2 class="text-center">Do you see what I mean?</h2>
    <p class="text-center lead">Add some compelling information here</p>
    <img src="/assets/example/bg_iphone.png" class="img-responsive center-block ">
    
</section>

<section class="container" id="section7">
	<h1 class="text-center">Social Media Fascination</h1>
    <div class="row">
      <!--fontawesome icons-->
      <div class="col-sm-1 col-sm-offset-2 col-xs-4 text-center">
       <i class="fa fa-github fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-foursquare fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       	<i class="fa fa-facebook fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-pinterest fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-google-plus fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-twitter fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-dribbble fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-instagram fa-4x"></i>
      </div>
  </div><!--/row-->
  <div class="row">
  	<div class="col-md-12 text-center">
      <br><br>
      <p>
    	<a href="http://www.bootstrapzero.com/bootstrap-template/sectionalize">Get the code for this template.</a>
      </p>
    </div>
  </div>
</section>

<footer id="footer">
  <div class="container">
    <div class="row">    
      <div class="col-xs-6 col-sm-6 col-md-3 column">          
          <h4>Information</h4>
          <ul class="nav">
            <li><a href="about-us.html">Products</a></li>
            <li><a href="about-us.html">Services</a></li>
            <li><a href="about-us.html">Benefits</a></li>
            <li><a href="elements.html">Developers</a></li>
          </ul> 
        </div>
      <div class="col-xs-6 col-md-3 column">          
          <h4>Follow Us</h4>
          <ul class="nav">
            <li><a href="#">Twitter</a></li>
            <li><a href="#">Facebook</a></li>
            <li><a href="#">Google+</a></li>
            <li><a href="#">Pinterest</a></li>
          </ul> 
      </div>
      <div class="col-xs-6 col-md-3 column">          
          <h4>Contact Us</h4>
          <ul class="nav">
            <li><a href="#">Email</a></li>
            <li><a href="#">Headquarters</a></li>
            <li><a href="#">Management</a></li>
            <li><a href="#">Support</a></li>
          </ul> 
      </div>
      <div class="col-xs-6 col-md-3 column">          
          <h4>Customer Service</h4>
          <ul class="nav">
            <li><a href="#">About Us</a></li>
            <li><a href="#">Delivery Information</a></li>
            <li><a href="#">Privacy Policy</a></li>
            <li><a href="#">Terms &amp; Conditions</a></li>
          </ul> 
      </div>
    </div><!--/row-->
  </div>
</footer>
<script type="text/javascript">
/* activate scrollspy menu */
$('body').scrollspy({
  target: '#navbar-collapsible',
  offset: 50
});

/* smooth scrolling sections */
$('a[href*=#]:not([href=#])').click(function() {
    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
      if (target.length) {
        $('html,body').animate({
          scrollTop: target.offset().top - 50
        }, 1000);
        return false;
      }
    }
});

</script>
</body>
</html>