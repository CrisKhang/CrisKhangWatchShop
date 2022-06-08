<%@ page 
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4">
    <jsp:include page="/common/inform.jsp"></jsp:include>

	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="VideoEditing-tab" data-toggle="tab"
			href="#VideoEditing" role="tab" aria-controls="VideoEditing"
			aria-selected="true">User Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="VideoList-tab" data-toggle="tab" href="#VideoList" role="tab"
			aria-controls="VideoList" aria-selected="false">User List</a></li>

	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="VideoEditing"
			role="tabpanel" aria-labelledby="VideoEditing-tab">
			<form action="" method="post">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col">
								<div class="form-group">
									<label for="username">Username</label> <input type="text"
										class="form-control" name="username" id="username"
										aria-describedby="usernameHid" placeholder="Username" value="${user.username}">
									<small id="usernameHid" class="form-text text-muted">Username
										is required</small>
								</div>
								<div class="form-group">
									<label for="fullname">Fullname</label> <input type="text"
										class="form-control" name="fullname" id="fullname"
										aria-describedby="fullnameHid" placeholder="Fullname" value="${user.fullname}">
									<small id="fullnameHid" class="form-text text-muted">Fullname
										is required</small>
								</div>
							
								<div class="form-group">
									<label for="password">Password</label> <input type="password"
										class="form-control" name="password" id="password"
										aria-describedby="passwordHid" placeholder="Password" value="${user.password}">
									<small id="passwordHid" class="form-text text-muted">Password
										is required</small>
								</div>
								<div class="form-group">
									<label for="email">Email</label> <input type="text"
										class="form-control" name="email" id="email"
										aria-describedby="EmailHid" placeholder="Email" value="${user.email}"> <small
										id="EmailHid" class="form-text text-muted">Email is
										required</small>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<div class="col-3 pull-right" style=" min-width:200px;">
						<button class="btn btn-primary" formaction="UserManagementServlet/create">Create</button>
						<button class="btn btn-warning" formaction="UserManagementServlet/update">Update</button>
						<button class="btn btn-danger" formaction="UserManagementServlet/delete">Delete</button>
						<button class="btn btn-info" formaction="UserManagementServlet/reset">Reset</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="VideoList" role="tabpanel"
			aria-labelledby="VideoList-tab">
			<table class="table table-stripe">
				<tr>
					<td>Username</td>
					<td>Fullname</td>
					<td>Password</td>
					<td>Email</td>
					<td>Role</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach items ="${listUser}" var = "u">
					<tr>
						<td>${u.username}</td>
						<td>${u.fullname}</td>
						<td>${u.password}</td>
						<td>${u.email}</td>
						<td>${u.admin ? 'Admin' : 'User'}</td>
						<td><a href="UserManagementServlet/edit?username=${u.username }"><i class="fa fa-edit" aria-hidden="true"></i>
								Edit</a> <a href="UserManagementServlet/delete?username=${u.username }"><i class="fa fa-trash" aria-hidden="true"></i>
								Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>