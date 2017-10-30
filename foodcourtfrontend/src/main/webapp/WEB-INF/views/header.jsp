
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>  
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Food Court</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="product">Products</a></li>
      <li class="dropdown">
        <a href="category" class="dropdown-toggle" data-toggle="dropdown" >Categories
        <b class="caret"></b></a>
        <ul class="dropdown-menu">
        
         <c:forEach items = "${catlist}" var="cat">
         <li><a href="products">${cat.catName}</a></li>
         </c:forEach>
        
        </ul>
        
       
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="register"><span class="glyphicon glyphicon-user"></span>Register</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav> 
