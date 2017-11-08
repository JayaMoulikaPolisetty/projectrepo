
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>  


        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${contextPath}/">Food Court</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${contextPath}">Home</a></li>
      <li><a href="${contextPath}/product">Products</a></li>
      <li><a href="${contextPath}/category">Category</a></li>
      
      <li>
       
          <a href="${contextPath}/category" class="dropdown-toggle" data-toggle="dropdown" ><input type="text" class="form-control" placeholder="Search for products" /></a>
                 <ul class="dropdown-menu">
                      <c:forEach items = "${catlist}" var="cat">
					         <li><a href="${contextPath}/CategorizedProducts/${cat.catId}">${cat.catName}</a></li>
					  </c:forEach>
					        
			     </ul>
	  </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${contextPath}/register"><span class="glyphicon glyphicon-user"></span>Register</a></li>
      <li><a href="${contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav> 
