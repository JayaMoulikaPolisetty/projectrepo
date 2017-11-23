<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
	prefix="fn"%>
<!DOCTYPE html>
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
<title>Food Court</title>


</head>
<body>
	<%@include file="header.jsp"%>
	
	<center>
	
	<h2>Thanks For Shopping!!</h2>
	
	<h3>Your Orders will be delivered in 30-40 mins.</h3>
	
	<a href="${contextPath}/"><button type="button" class="btn btn-info">Continue Shopping</button></a>
	
	</center>

</body>
<%@include file="footer.jsp"%>
</html>