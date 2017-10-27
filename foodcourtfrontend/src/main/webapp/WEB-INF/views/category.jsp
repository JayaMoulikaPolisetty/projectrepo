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
            <title>Add Categories</title>
            <jsp:include page="header.jsp"></jsp:include>
            
            
            
        </head>
        <body>
            <form:form id="catForm" modelAttribute="category" action="catProcess" method="post">
            <div class="table-responsive">
            <center><h2>Category form</h2></center></br>
                <table align="center" class="table" style = "width:60%">
                    
                    <tr>
                        <td>
                            <form:label path="catName">Category Name</form:label>
                        </td>
                        <td>
                            <form:input path="catName" name="catName" id="catName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="catDesc">Category Description</form:label>
                        </td>
                        <td>
                            <form:input path="catDesc" name="catDesc" id="catDesc" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <form:button id="category" name="addCategory">Add Category</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    
                </table>
                </div>
            </form:form>
            <div class="table-responsive" >
            <table align="center" class="table table-inverse" style = "width:80%">
			<tr>
			<th>Category Name</th>
			<th>Category Description</th>
			
			</tr>
			<c:forEach items = "${catlist}" var="cat">
			
			<tr>
			<td>${cat.catName}</td>
			<td>${cat.catDesc}</td>
			</tr>
			</c:forEach>
			</table>
			</div>
        </body>
        </html>