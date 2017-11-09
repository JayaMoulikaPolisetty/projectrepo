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
              <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
            <c:set var="image" value="${contextPath}/resources"/>
            
        </head>
        <body>
            <form:form id="prodForm" modelAttribute="product" action="prodProcess" enctype="multipart/form-data" method="post">
            <div class="table-responsive">
            <h2 style = "text-align: center">Products form</h2></br>
       <div class="container">
	   <div class="row">
		
		<div class=col-sm-3></div>   
		<div class="col-sm-6">
		 	<div class="form-group">
		      <label for="productName">Product Name:</label>
		      <form:input path="productName" name="productName" id="firstName" class="form-control"/>
		     </div>
		    <div class="form-group">
		      <label for="productDesc">Product Description:</label>
		       <form:input path="productDesc" name="productDesc" id="productDesc" class="form-control"/>
		    </div>
		    <div class="form-group">
		      <label for="productPrice">Price:</label>
		       <form:input path="productPrice" name="productPrice" id="productPrice" class="form-control"/>
		    </div>
		    <div class="form-group">
		      <label for="category">Category:</label>
		      <div class="dropdown">
		      <form:select path="category.catId" class="form-control">
    				 <form:option value="0" label="---Select Category---" />
                      <form:options items="${catlist}" itemValue="catId" itemLabel="catName" />
              </form:select>
              </div>
		    </div>
		    <div class="form-group">
		      <label for="pimage">Upload Image:</label>
		      <form:input path ="pimage" type ="file" class="form-control"/>
		       
		    </div>
		    
		    <button type="submit" class="btn btn-default">Add Product</button>
		    
		  </div>
		  </div>
		  </div>
        </div>
            </form:form>
            <%-- <div class="table-responsive" >
            <table border = "2" align="center" class="table table-inverse" style = "width:80%">
			<tr>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Price</th>
			</tr>
			<c:forEach items = "${prodlist}" var="products">
			
			<tr>
			<td><a href="${contextPath}/productDisplay/${products.productId}">${products.productName}</a></td>
			<td>${products.productDesc}</td>
			<td>${products.productPrice}</td>
			</tr>
			</c:forEach>
			</table>
			</div> --%>
			<div class="row">
			<h2 style = "text-align: center">Products List</h2></br>
				<c:forEach items = "${prodlist}" var="products">
				  <div class="col-md-3" style="text-align:center">
				 
						<a href="${contextPath}/productDisplay/${products.productId}"><img src="${image}/${products.productId}.jpg" class="img-thumbnail">
						<h3>${products.productName}</h3> </a>
						<h3>${products.productPrice}</h3>
					
				  </div>
				  </c:forEach>
				
				</div>
			
	            
        </body>
        </html>