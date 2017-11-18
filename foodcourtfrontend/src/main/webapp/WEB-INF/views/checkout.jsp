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

	<c:set var="images" value="${contextPath}/resources/carouselPics" />
	<c:set var="image" value="${contextPath}/resources" />

<div class="container">

		<div class="table-responsive">
			<table border="2" align="center" class="table table-inverse"
				style="width: 70%">

				<tr>
					<td>Product</td>
					<td>Price of Product</td>
					<td>Quantity</td>
					<td>Total Price</td>
				</tr>
				<c:forEach items="${cartItems}" var="cartItem">
				<tr>
					<td>${cartItem.product.productName}</td>
					<td>${cartItem.product.productPrice}</td>
					<td>${cartItem.cartItemQuantity}</td>
					<td>${cartItem.cartItemPrice}</td>					
				</tr>
				
				</c:forEach>
			<a href="${contextPath}/customer/confirm">
				<button type="button" class="btn btn-primary">Place Order</button>
			</a>
			
			<a href="${contextPath}/customer/myCart">
			<button type="button" class ="btn btn-danger">Back</button>
			</a>

</body>
</html>