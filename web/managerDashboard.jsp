<%-- 
    Document   : memberDashboard
    Created on : 5 Apr 2026, 3:36:45?pm
    Author     : ASUS
--%>

<%
if(session.getAttribute("username") == null){
    response.sendRedirect("login.jsp");
}
%>

<h2>Manager Dashboard</h2>
Welcome, ${sessionScope.username}

<hr>

<h3>Membership</h3>
<a href="add_membership.html">Add Membership</a><br>
<a href="ViewMembershipServlet">View Membership</a>

<br><br>

<a href="login.jsp">Logout</a>