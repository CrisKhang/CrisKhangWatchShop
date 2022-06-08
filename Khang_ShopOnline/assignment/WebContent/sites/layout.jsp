 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">

<head>
<title>${page.title }</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="/Assignment/" />
 <!-- Bootstrap CSS -->
 <link href="csss/style.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>

<body>
	<main class="container">
		<header class="row">
            <img src="images/banner3.jpg" alt="##" style="width: 100%;">
  
        </header>
		<nav class="row">
			<nav class="col navbar navbar-expand-sm navbar-dark">
				<a class="navbar-brand" href="Homepage" style="font-size: 18pt;font-family: cursive; color: aqua;">Gia Khang Watch Shop Julius</a>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					  <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						
						<li class="nav-item active">
              				<a class="nav-link" href="Homepage">
               					 <i class="fa fa-home" aria-hidden="true"></i>Home<span class="sr-only"></span>
            				</a>
            			</li>
						<li class="nav-item">
              				<a class="nav-link" href="FavoriteServlet">
               					 <i class="fas fa-heart" aria-hidden="true"></i> My Favorites
              				</a>
           				 </li>
						<!-- MyACC -->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdownId"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
								class="fa fa-user" aria-hidden="true"></i> My Account</a>
							<div class="dropdown-menu" aria-labelledby="dropdownId">
							<c:if test="${! isLogin }">
								<a class="dropdown-item text-success" href="LoginServlet">Login</a> <a
									class="dropdown-item" href="ForgotPasswordServlet">Forgot Password</a> <a
									class="dropdown-item" href="Registration">Registration</a>
									</c:if>
									<c:if test="${isLogin }"> 
									<a class="dropdown-item text-danger" href="LogoffServlet">Log Out</a> 
									<a class="dropdown-item" href="ChangepasswordServlet">Change Password</a> 
									<a class="dropdown-item" href="EditprofileServlet">Edit Profile</a>
									</c:if>
							</div>
						</li>
						<li class="nav-item">
              				<a class="nav-link" href="UserManagementServlet">
               					 <i class="fas fa-heart" aria-hidden="true"></i> User Management
              				</a>
           				 </li>
           				 
					</ul>
				</div>
			</nav>
		</nav>
		<section class="row">
			<jsp:include page="${page.contentUrl }"></jsp:include>
		</section>
		<footer class="footer">
  	 <div class="container">
  	 	<div class="row">
  	 		<div class="footer-col">
  	 			<h4>company</h4>
  	 			<ul>
  	 				<li><a href="http://localhost:8080/Assignment/sites/layout.jsp">about us</a></li>
  	 				<li><a href="http://localhost:8080/Assignment/sites/layout.jsp">our services</a></li>
  	 				<li><a href="http://localhost:8080/Assignment/sites/layout.jsp">privacy policy</a></li>
  	 				<li><a href="http://localhost:8080/Assignment/sites/layout.jsp">affiliate program</a></li>
  	 			</ul>
  	 		</div>
  	 		<div class="footer-col">
  	 			<h4>get help</h4>
  	 			<ul>
  	 				<li><a href="http://localhost:8080/Assignment/sites/layout.jsp">FAQ</a></li>
  	 				<li><a href="http://localhost:8080/Assignment/sites/layout.jsp">shipping</a></li>
  	 				<li><a href="http://localhost:8080/Assignment/sites/layout.jsp">returns</a></li>
  	 				<li><a href="http://localhost:8080/Assignment/Admin/VideosManagement">order status</a></li>
  	 				<li><a href="http://localhost:8080/Assignment/sites/layout.jsp">payment options</a></li>
  	 			</ul>
  	 		</div>
  	 		<div class="footer-col">
  	 			<h4>online shop</h4>
  	 			<ul>
  	 				<li><a href="http://localhost:8080/Assignment/Homepage">watch</a></li>
  	 				<li><a href="http://localhost:8080/Assignment/Homepage">bag</a></li>
  	 				<li><a href="http://localhost:8080/Assignment/Homepage">shoes</a></li>
  	 				<li><a href="http://localhost:8080/Assignment/Homepage">dress</a></li>
  	 			</ul>
  	 		</div>
  	 		<div class="footer-col">
  	 			<h4>follow us</h4>
  	 			<div class="social-links">
  	 				<a href="https://www.facebook.com/profile.php?id=100066519874057"><i class="fab fa-facebook-f"></i></a>
  	 				<a href="https://www.facebook.com/profile.php?id=100066519874057"><i class="fab fa-twitter"></i></a>
  	 				<a href="https://www.instagram.com/_imkaggg/"><i class="fab fa-instagram"></i></a>
  	 				<a href="https://myaccount.google.com/u/1/?hl=vi&utm_source=OGB&utm_medium=act"><i class="fab fa-linkedin-in"></i></a>
  	 			</div>
  	 		</div>
  	 	</div>
  	 </div>
  </footer>
	</main>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		
		<c:if test="${not empty page.scriptUrl }">
		    <jsp:include page="${page.scripUrl }"></jsp:include>
		</c:if>
</body>

</html>