<%@ include file="/layout/header.jsp" %>




<h1>Logout Page</h1>
<%
session.removeAttribute("token");
%>

<a href="home.jsp">Go to Home page</a><br>
<a href="member.jsp">Go to Member page</a>














<%@ include file="/layout/footer.jsp" %>
