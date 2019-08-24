<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

<div class="container">
	<div class="row">


		<div class="col-md-12">
			<div class="table-responsive">


				<table id="mytable" class="table table-bordred table-striped">

					<thead>

						<th>ProductID</th>
						<th>ProductName</th>
						<th>ProductPrice</th>
						

					</thead>
					<tbody>

						<c:forEach items="${productList}" var="product">
							<tr>
								<td>${product.productId}</td>
								<td>${product.productName}</td>
								<td>${product.productPrice}</td>
							</tr>
						</c:forEach>


					</tbody>

				</table>


			</div>

		</div>
	</div>
</div>









