
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<style>
.img-thumbnail {
	height: 200px;
	width: 200px;
}

.carousel-control {
	height: 400px;
}

.carousel-inner>.item>img {
	height: 400px;
	width: 100%;
}

.c-wrapper {
	width: 70%;
	margin: auto;
}
</style>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${contextPath}/">Food Court</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="${contextPath}">Home</a></li>
			<security:authorize access="hasAuthority('ROLE_ADMIN')">
				<li><a href="${contextPath}/admin/product">Product
						Operations</a></li>

				<li><a href="${contextPath}/admin/category">Category
						Operations</a></li>
			</security:authorize>
			<security:authorize access="!hasAuthority('ROLE_ADMIN')">
				<li><a href="${contextPath}/products">Products</a></li>

				<li><a href="${contextPath}/category" class="dropdown-toggle"
					data-toggle="dropdown">Categories<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<c:forEach items="${catlist}" var="cat">
							<li><a
								href="${contextPath}/CategorizedProducts/${cat.catId}">${cat.catName}</a></li>
						</c:forEach>
					</ul></li>
			</security:authorize>
		</ul>
		
		<ul class="nav navbar-nav navbar-right">
			<security:authorize access="isAnonymous()">
				<li><a href="${contextPath}/register"><span
						class="glyphicon glyphicon-user"></span>Register</a></li>
				<li><a href="${contextPath}/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</security:authorize>

			<security:authorize access="hasAuthority('ROLE_USER')">
				<li><a href="${contextPath}/customer/myCart"><span
						class="glyphicon glyphicon-shopping-cart"
						style="margin-left: 2px; margin-right: 2px;"></span><%-- <span
						style="border-radius: 10px; background-color: blue; color: white; padding: 8px; margin-right: 2px;">${cart.cartQuantity}</span> --%>My
						Cart</a></li>
				<li id="logout"><a href="${contextPath}/perform_logout"><span
						class="glyphicon glyphicon-user"></span>Logout</a></li>
			</security:authorize>
		</ul>
	</div>
</nav>
