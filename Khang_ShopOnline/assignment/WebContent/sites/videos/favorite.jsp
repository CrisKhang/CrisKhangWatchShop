<%@ page 
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <base href="/Assignment/" />
   <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<%-- <div class="col">
	
		 
			<input type="hidden" id="id__video" name="id" value="${video.videoId}" />
			<c:forEach items="${listFavoriteVideo}" var="video">
			<div class="row p-2">
				<div class="col-3 mt-2">
					<div class="card">
						
						<div class="card-body">
							<img src="images/${video.poster}" alt="" class="img-fluid">
							<div class="row">
								<b>${video.title}</b>
							</div>
						</div>
						<div class="card-footer text-muted">
							<a href="" class="btn btn-primary">Unlike</a> 
							<a href=""class="btn btn-info">share</a>
						</div>
					</div>
				</div>	
			</div>
		
	</c:forEach>
</div> --%>
	<div class="col-12">
	 <jsp:include page="/common/inform.jsp"></jsp:include>
	<div class="row p-6">
	<c:forEach var="item" items="${listFavoriteVideo}">
		<div class="col-3 mt-2">
			<div class="card text-center">
				<div class="card-body">
					<img src="images/${item.poster}" style="width: 100%;" alt="" class="img-fluid">
					<div class="row border-top mt-2">
						<b>${item.title }</b>
					</div>
				</div>
				<div class=" card-footer">
					<a href="LikeVideo?videoId=${item.videoId }" class="btn btn-primary">UnLike</a> 
					<a href="ShareVideo?videoId=${item.videoId }"class="btn btn-info">Share</a>
				
				</div>
			</div>
		</div>
	</c:forEach>
	</div>
	</div>
	 <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
</div>
