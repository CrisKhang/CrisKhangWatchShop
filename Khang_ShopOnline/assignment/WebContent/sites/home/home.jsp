<%@ page 
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
   
    <link href="csss/style.css" rel="stylesheet" />
   <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="5"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
       <img src="images/slideshow10.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item ">
    <img src="images/slideshow7.png" alt="##">
    </div>
    <div class="carousel-item ">
      <img src="images/slideshow8.png" alt="##">
    </div>
    <div class="carousel-item ">
      <img src="images/slideshow9.jpg" alt="##">
    </div>
    <div class="carousel-item ">
      <img src="images/slideshow3.jpg" alt="##">
    </div>
    <div class="carousel-item ">
      <img src="images/slideshow4.jpg" alt="##">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<div class="col-9">
	 <jsp:include page="/common/inform.jsp"></jsp:include>
	 
	<div class="row p-2">
	<div class="col-12">
      <h3 class="right_block_title1"><span>Product </span> </h3>
    </div>
    <br>	
	<c:forEach var="item" items="${videos}">
	<input type="hidden" id="id__video" name="id" value="${item.videoId}" />
		<div class="col-4 mt-2" style="min-height: 300px">
			<div class="card text-center ">
				<div class="card-body ">
					<a href="VideodetailServlet?videoId=${item.videoId}"> <img src="images/${item.poster}" style="" alt="" class="img-fluid"> </a>
					<div class="row border-top mt-2" >
						<b class="tc">${item.title }</b>
					</div>
					<br />US $${item.price}<br />
				</div>
				<div class=" card-footer ">
					<a href="LikeVideo?videoId=${item.videoId }" class="btn btn-success">Like</a> 
					<a href="ShareVideo?videoId=${item.videoId }"class="btn btn-info">Share</a>
				
				</div>
			</div>
		</div>
	</c:forEach>
	</div>	
	<div class="row">
		<div class="col">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center">
					<li class="page-item disabled"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item active"><a class="page-link" href="Homepage">1</a></li>
					<li class="page-item "><a class="page-link" href="Homepage">2</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<div class="col-3">
	<div class="poly-cart bor0">
      <div class="panel panel-default mbt10 bor0" >
        <div class="panel-body1 bor0">
          <img src="images/D1.jpg" alt="##">
          <img src="images/D2.png" alt="##">
          <img src="images/D3.jpg" alt="##">
          <img src="images/D4.png" alt="##">
          <img src="images/D5.jpg" alt="##">
          <img src="images/D6.png" alt="##">
        </div>
      </div>
    </div>
</div>
