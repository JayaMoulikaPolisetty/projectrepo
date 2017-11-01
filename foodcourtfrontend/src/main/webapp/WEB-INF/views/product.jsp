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
            <form:form id="prodForm" modelAttribute="product" action="prodProcess" enctype="multipart/form-data" method="post">
            <div class="table-responsive">
            <center><h2>Products form</h2></center></br>
                <table align="center" class="table" style = "width:60%">
                    
                    <tr>
                        <td>
                            <form:label path="productName">Product Name</form:label>
                        </td>
                        <td>
                            <form:input path="productName" name="productName" id="productName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="productDesc">Product Description</form:label>
                        </td>
                        <td>
                            <form:input path="productDesc" name="productDesc" id="productDesc" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="productPrice">Product Price</form:label>
                        </td>
                        <td>
                            <form:input path="productPrice" name="productPrice" id="productPrice" />
                        </td>
                    </tr>
                     <tr>
                     <td>
                      <form:label path="category">Select Category</form:label>
                     </td>
                     <td>
    				<form:select path="category.catId">
    				 <form:option value="0" label="---Select Category---" />
                      <form:options items="${catlist}" itemValue="catId" itemLabel="catName" />
                    </form:select>
                     </td>
                     </tr>
                      <tr>
                      <td>
                          <form:label path="pimage">Upload Image</form:label>
                      </td>
                      <td>
                           <form:input path ="pimage" type ="file" />
                      </td>
                      </tr>
                       <tr>
                       <td></td>
                        <td>
                            <form:button id="product" name="addProduct" >Add product</form:button>
                        </td>
                    </tr>
                    <tr>
                    
                    </tr>
                    
                </table>
                </div>
            </form:form>
            <div class="table-responsive" >
            <table align="center" class="table table-inverse" style = "width:80%">
			<tr>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Price</th>
			</tr>
			<c:forEach items = "${prodlist}" var="products">
			
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