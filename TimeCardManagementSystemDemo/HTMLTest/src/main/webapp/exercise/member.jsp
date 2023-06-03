<%@ include file="/layout/header.jsp" %>


<h1>Member Page</h1>

<%
if(session.getAttribute("token") == null){
	
%>
	<jsp:forward page="logout.jsp"/>
	
<%
	} else{
		out.println(session.getAttribute("token"));
	}
%>







<a href="logout.jsp">Go to Logout page</a>
















<%@ include file="/layout/footer.jsp" %>
