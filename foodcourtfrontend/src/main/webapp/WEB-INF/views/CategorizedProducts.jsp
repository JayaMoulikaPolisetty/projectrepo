<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>  
    <%@ page language="java" contentType="text/html;" %>
        <html>
        <head>
        <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
            <meta http-equiv="Content-Type" content="text/html;">
            <title>Add Products</title>
            <jsp:include page="header.jsp"></jsp:include>
            
        </head>
        <body>
        <div class="table-responsive" >
            <table align="center" class="table table-inverse" style = "width:80%">
			<tr>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Price</th>
			</tr>
			<c:forEach items = "${catprodlist}" var="products">
			
			<tr>
			<td>${products.productName}</td>
			<td>${products.productDesc}</td>
			<td>${products.productPrice}</td>
			</tr>
			</c:forEach>
			</table>
			</div>
        
        
        </body>
        </html>