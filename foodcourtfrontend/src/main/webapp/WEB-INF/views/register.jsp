<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html;" %>
        <html>
        <head>
        <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
            <meta http-equiv="Content-Type" content="text/html;">
            <title>Registration</title>
            
            <jsp:include page="header.jsp"></jsp:include>
             <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
			<c:set var="images" value="${contextPath}/resources"/>
             
            
        </head>
         <style>
				/* body {
  					  background-image: url("${images}/background1.jpg");
				} */
				body {
background-image: url(${images}/background1.jpg); /*You will specify your image path here.*/

-moz-background-size: cover;
-webkit-background-size: cover;
background-size: cover;
background-position: top center !important;
background-repeat: no-repeat !important;
background-attachment: fixed;
}

			</style>
        <body>
            <form:form id="regForm" modelAttribute="customer" action="registerProcess" method="post">
               <h2 style = "text-align: center">Registration form</h2></br>
		 <div class="container">
		 <div class="row">
		
		<div class=col-sm-3></div>   
		<div class="col-sm-6">
		 	<div class="form-group">
		      <label for="firstName">First Name:</label>
		      <form:input path="firstName" name="firstName" id="firstName" class="form-control"/>
		     </div>
		    <div class="form-group">
		      <label for="lastName">Last Name:</label>
		       <form:input path="lastName" name="lastName" id="lastName" class="form-control"/>
		    </div>
		    <div class="form-group">
		      <label for="address">Address:</label>
		       <form:input path="address" name="address" id="address" class="form-control"/>
		    </div>
		    <div class="form-group">
		      <label for="username">Username:</label>
		       <form:input path="username" name="username" id="username" class="form-control"/>
		    </div>
		    <div class="form-group">
		      <label for="password">Password:</label>
		    <form:input path="password" type="password" id="password" class="form-control"/>
		    </div>
		    <div class="form-group">
		      <label for="password">Confirm Password:</label>
		       <form:input path="password" type="password" id="password" class="form-control"/>
		    </div>
		    <div class="form-group">
		      <label for="mobile">Mobile:</label>
		       <form:input path="mobile" name="mobile" id="mobile" class="form-control"/>
		    </div>
		    <button type="submit" class="btn btn-default">Register</button>
		    
  </div>
  </div>
  </div>
 
   </form:form>
        </body>
        </html>