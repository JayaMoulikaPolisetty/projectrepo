<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html;"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html;">
<title>Registration</title>

<jsp:include page="header.jsp"></jsp:include>

</head>

<body>
	<form:form id="regForm" modelAttribute="customer"
		action="registerProcess" method="post"
		 novalidate="true">
		<h2 style="text-align: center">Registration form</h2>
		</br>
		<div class="container">
			<div class="row">

				<div class=col-sm-3></div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="firstName">First Name:</label>
						<form:input path="firstName" name="firstName" id="firstName"
							required="true" pattern="[a-zA-Z]{4,12}" class="form-control" title="min 4 max 12 char" />
							<form:errors path="firstName" style="color: red"/>
						
					</div>
					<div class="form-group">
						<label for="lastName">Last Name:</label>
						<form:input path="lastName" name="lastName" id="lastName"
							required="true" pattern="[a-zA-Z]{4,12}" class="form-control" title="min 4 max 12 char" />
					
					<form:errors path="lastName" style="color: red"/>
					</div>
					<div class="form-group">
						<label for="address">Address:</label>
						<form:input path="address" name="address" id="address"
							required="true" class="form-control" novalidate="true" />
					
					</div>
					<div class="form-group">
						<label for="username">Username:</label>
						<form:input path="username" name="username" id="username"
							required="true" pattern="[a-zA-Z]{4,12}" class="form-control" title="min-4 max-12 char" />
					<form:errors path="username" style="color: red"/>
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<form:input path="password" type="password" id="password"
							required="true" pattern="[a-zA-Z0-9]{8,12}" class="form-control" title="min-8 max-12 char" />
					<form:errors path="password"/>
					</div>
					<div class="form-group">
						<label for="password">Confirm Password:</label>
						<form:input path="confirmPassword" type="password"
							id="confirmPassword" required="true" pattern="[a-zA-Z0-9]{8,12}" title="min-4 max-12 char"
							class="form-control" />
					</div>
					
				    <div style="color: red">${errorPass}</div>
					<form:input path="is_Active" hidden="true" value="TRUE" />
					<div class="form-group">
						<label for="mobile">Mobile:</label>
						<form:input path="mobile" name="mobile" id="mobile"
							required="true" pattern="[0-9]{10,10}" class="form-control" />
					<form:errors path="mobile"/>
					</div>
					<button type="submit" class="btn btn-default">Register</button>

				</div>
			</div>
		</div>

	</form:form>

	<script type="text/javascript">
		function validateConPass() {
			if (document.getElementById("password").value != document
					.getElementById("confirmPassword").value) {
				document.getElementById("passerror").innerHTML = "password and confirm password should be same";
				return false;
			} else {
				return true;
			}
		}
	</script>

</body>
<%@include file="footer.jsp"%>
</html>