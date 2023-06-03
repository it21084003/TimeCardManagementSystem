<%@ include file="/layout/header.jsp"%>
<%@ include file="/layout/nav.jsp"%>



<div class="container text-dark pt-5">
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<div class="row">
						<div class="col-md-6">
							<div class="card-title">Users</div>
						</div>
						<div class="col-md-6 ">
							<a href="<%=request.getContextPath()%>/create.jsp"
								class="btn btn-primary btn-sm float-end mb-3"> <i
								class="fa-solid fa-plus-circle"></i> Add New
							</a>
						</div>
					</div>
				</div>
				<div class="card-body">
					<!-- 	<div class="alert alert-warning alert-dismissible fade show"
						role="alert">
						<strong>Hey! </strong>
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div> -->
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Department</th>
								<th>Phone</th>
								<th>Address</th>
								<th>Remark</th>
								<th>Hire Date</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<%@page
								import="java.util.*,models.*,javax.servlet.http.HttpSession"%>
							<%
							List<userDTO> userList = (List<userDTO>) request.getAttribute("useList");

							for (userDTO st : userList) {
							%>

							<tr>
								<td><%=st.getUser_id()%></td>
								<td><%=st.getUser_name()%></td>
								<td><%=st.getDepartment_name()%></td>
								<td><%=st.getUser_tel()%></td>
								<td><%=st.getUser_address()%></td>
								<td><%=st.getRemark()%></td>
								<td><%=st.getHire_date()%></td>
								<td>
									<form action="#" method="get">
										<a href="{{url('admin/category/'.$categories->id.'/edit')}}"
											class="btn btn-info btn-sm"><i
											class="fa-regular fa-pen-to-square"></i> Edit</a> 
										<a
											href="delete?id=<%=st.getUser_id()%>"
											class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you wanted to delete?')"><i
											class="fa-solid fa-trash-can"></i> Delete</a>
										<a
										
											href="details?id=<%=st.getUser_id() %>"
											class="btn btn-primary btn-sm"><i
											class="fa-solid fa-trash-can"></i> Details</a>
									</form>
								</td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				<div class="card-fotter"></div>
			</div>
		</div>

	</div>


</div>


<%@ include file="/layout/footer.jsp"%>