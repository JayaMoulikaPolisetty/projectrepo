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
<div class="row">
<div class="col-md-2"></div>
<div class="col-md-8">
<h3><b>Hello ${customer.getFirstName()},</b></h3><br>

<h4>Your Cart Details are:</h4>
		<div class="table-responsive">
			<table border="2" align="center" class="table table-inverse">

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
				<tr>
				<td colspan="3">Total Bill:</td>
				<td>${cart.totalCartPrice}</td>
				</tr>
				
			</table>
</div>

<h3>Delivery Address: ${customer.getAddress()}</h3>
<br>

<center>
<a href="${contextPath}/customer/confirm"><button type="submit" class="btn btn-primary" style="text-align: center">Place Order</button></a>


<a href="${contextPath}/customer/myCart">
				<button type="button" class ="btn btn-danger" style="align: center">Back</button>
				</a>
	</center>
</div>
</div>
</div>	
	
</body>
<%@include file="footer.jsp"%>
</html>