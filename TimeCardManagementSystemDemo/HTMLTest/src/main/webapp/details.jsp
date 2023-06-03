<%@page import="dao.usertimeDAO"%>
<%@ include file="/layout/header.jsp"%>


<div class="container pt-5">
	<div class="row">
		<div class="col-md-12">

			<div class="card">
				<div class="card-header">
					<div class="row">
						<div class="col-md-6">
							<div class="card-title">Projects</div>
						</div>
						<div class="col-md-6 ">
							<a href="" class="btn btn-primary btn-sm float-end mb-3"> <i
								class="fa-solid fa-plus-circle"></i> Add New
							</a>
						</div>
					</div>
				</div>
				<div class="card-body">


					<table class="table table-bordered table-hover">

						
						<thead>
							<tr>
								<th>ID</th>
								<th>Date</th>
								<th>StartTime</th>
								<th>EndTime</th>
								<th>WorkingTime</th>
							</tr>
						</thead>
						<tbody>
						<%@page
							import="java.util.*,models.*,javax.servlet.http.HttpSession"%>

						<%
						List<usertimeDTO> timeCardList = (List<usertimeDTO>) request.getAttribute("timeList");
						usertimeDTO totalhours = new usertimeDTO();
						for (usertimeDTO st : timeCardList) {
						%>
							<tr>

								<td><%=st.getId()%></td>
								<td><%=st.getDate() %></td>
								<td><%=st.getStart_time()%></td>
								<td><%=st.getEnd_time() %></td>
								<%-- <td><%=st.getWorkingTime() %></td> --%>
									<td><%=st.getWorking_timeH()+":"+st.getWorking_timeS()%></td>
								
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				<div class="card-footer">
					<div class="row  ">
						<div class="col-md-2 ms-auto">
							<div class="card-title">Total <%=totalhours.getTotalHours() %></div>
						</div>
						
					</div>
				</div>
			</div>

		</div>
	</div>
</div>






<%@ include file="/layout/footer.jsp"%>