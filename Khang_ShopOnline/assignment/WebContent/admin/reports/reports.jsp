<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="VideoEditing-tab" data-toggle="tab"
			href="#VideoEditing" role="tab" aria-controls="VideoEditing"
			aria-selected="true">Favorites</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="VideoList-tab" data-toggle="tab" href="#VideoList" role="tab"
			aria-controls="VideoList" aria-selected="false">Favorite Users</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="shareFriends-tab" data-toggle="tab" href="#shareFriends"
			role="tab" aria-controls="shareFriends" aria-selected="false">Share
				Friends</a></li>

	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="VideoEditing"
			role="tabpanel" aria-labelledby="VideoEditing-tab">
			<table class="table table-bordered mt-3">
				<tr>
					<td>Video Title</td>
					<td>Favorites Count</td>
					<td>Lasted Date</td>
					<td>Oldest Date</td>
				</tr>
				<c:forEach var="item" items= "${favList}">
				<tr>
					<td>${item.videoTitle}</td>
					<td>${item.favoriteCount}</td>
					<td>${item.newestDate}</td>
					<td>${item.oldestDate}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="tab-pane fade" id="VideoList" role="tabpanel"
			aria-labelledby="VideoList-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group">
								<label>Video Title 
								<select name="videoUserId" id="videoUserId"
									class="from-control ml-3">
									<c:forEach var="item" items="${vidList }">
										<option value="${item.videoId }" 
										    ${item.videoId == videoUserId?'selected':'' }>${item.title }</option>
								    </c:forEach>
								</select>
								</label>
								<button class="btn btn-info ml-2">Search</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<td>Username</td>
								<td>Fullname</td>
								<td>Email</td>
								<td>Favorite Date</td>
							</tr>
							<c:forEach var="item" items="${favUsers }"> 
							<tr>
								<td>${item.username }</td>
								<td>${item.fullname }</td>
								<td>${item.email }</td>
								<td>${item.likeDate }</td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="shareFriends" role="tabpanel"
			aria-labelledby="shareFriends-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group ">
								<label>Video Title 
								<select name="" id="" class="from-control ml-2">
									<c:forEach var="item" items="${vidList }">
										<option value="${item.videoId }" ${item.videoId == videoUserId?'selected':'' }>${item.title }</option>
								    </c:forEach>
								</select>
								</label>
								<button class="btn btn-info ml-2">Search</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<td>Sender Name</td>
								<td>Sender Email</td>
								<td>Receiver Email</td>
								<td>Sent Date</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
