<%@ include file="/layout/header.jsp"%>


<div class="container">
	<div class="row">
		<div class="col-md-6 offset-md-3 pt-5">
			<div class="card">
				<div class="card-header">
					<div class="card-title">Edit</div>
				</div>
				<form action="edit" method="POST">

					<%@page import="java.util.*,models.*,javax.servlet.http.HttpSession" %>
					<%List<userDTO> user = (List<userDTO>) request.getAttribute("user");
					for (userDTO st : user) {
					 %>		
					<div class="card-body">
						<div class="form-group pb-2">
							<label for="">Name</label> <input type="text" name="name"
								placeholder="Name" class="form-control" value="<%=st.getUser_name()%>">

						</div>
						<div class="form-group pb-2 ">
							<label for="">Position</label> <input type="text" name="pid"
								placeholder="Position" class="form-control value="<%=st.getDepartment_name()%>"> <span
								class="text-danger"><small></small></span>

						</div>
						<div class="form-group pb-2">
							<label for="">Telephone</label> <input type="text" name="phone"
								placeholder="Telphone" class="form-control"> <span
								class="text-danger"><small></small></span>

						</div>
						<div class="form-group pb-2">
							<label for="">Address</label> <input type="text" name="address"
								placeholder="Address" class="form-control"> <span
								class="text-danger"><small></small></span>

						</div>
						<div class="form-group pb-2">
							<label for="">Remark</label> <input type="text" name="remark"
								placeholder="Remark" class="form-control"> <span
								class="text-danger"><small></small></span>

						</div>
						<div class="form-group pb-2">
							<label for="">Hire Date</label> <input type="date"
								name="hiredate" placeholder="Hire Date" class="form-control">

							<span class="text-danger"><small></small></span>

						</div>
					</div>
					<div class="card-footer">
						<button type="submit" class="btn btn-primary mt-3">Submit</button>
					</div>
				</form>
				<%} %>
			</div>


		</div>
	</div>
</div>







<%@ include file="/layout/footer.jsp"%>