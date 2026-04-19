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

<h2>Member Dashboard</h2>
Welcome, ${sessionScope.username}