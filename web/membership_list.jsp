<%-- 
    Document   : membership_list
    Created on : Apr 12, 2026, 12:38:04?PM
    Author     : user
--%>

<%@page import="java.util.*, com.lab.model.Membership"%>

<h2>Membership List</h2>

<%
List<Membership> list = (List<Membership>) request.getAttribute("list");

if (list == null || list.isEmpty()) {
%>
    <p>No membership found.</p>
<%
} else {
%>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Plan</th>
    <th>Status</th>
    <th>Expiry</th>
    <th>Action</th>
</tr>

<%
    for (Membership m : list) {
%>
<tr>
    <td><%=m.getMembershipId()%></td>
    <td><%=m.getStudentName()%></td>
    <td><%=m.getPlanType()%></td>
    <td><%=m.getStatus()%></td>
    <td><%=m.getExpiryDate()%></td>
    <td>
        <a href="DeleteMembershipServlet?id=<%=m.getMembershipId()%>">Delete</a>
    </td>
</tr>
<%
    }
%>
</table>

<%
}
%>

<a href="managerDashboard.jsp">Back</a>