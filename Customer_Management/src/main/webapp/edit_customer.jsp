<%@page import="com.kuu.entities.Customer"%>
<%@page import="com.kuu.factories.ConnectionFactories"%>
<%@page import="com.kuu.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="all-css.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Customer</p>
						
						<%
						
						 int id = Integer.parseInt(request.getParameter("id"));
						CustomerDAO dao = new CustomerDAO(ConnectionFactories.getConnection());
						Customer c = dao.getCustomerById(id);
						
						%>
						
						
						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">First_Name</label> <input value="<%=c.getFirst_name() %>"
									name="first_name" type="text" class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">Last_Name</label> <input value="<%=c.getLast_name()%>"
									name="last_name" type="text" class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">Street</label> <input value="<%=c.getStreet()%>" name="street"
									type="text" class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input value="<%=c.getAddress()%>" name="address"
									type="text" class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">City</label> <input value="<%=c.getCity()%>" name="city"
									type="text" class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">State</label> <input value="<%=c.getState() %>" name="state"
									type="text" class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input value="<%=c.getEmail() %>" name="email"
									type="email" class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">Phone</label> <input value="<%=c.getPhone() %>" name="phone"
									type="text" class="form-control">

							</div>
							
							<input type="hidden" name="id" value="<%=c.getId() %>">

							<button type="submit" class="btn btn-primary col-md-12" >Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>