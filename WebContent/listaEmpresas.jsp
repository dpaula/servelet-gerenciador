<%@page import="br.com.lima.model.Empresa"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="br.com.lima.util.JPAUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
    //trazendo a lista de empresas que foi setado no servlet
	List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
	</ul>
	<%
		for (Empresa empresa : empresas) {
	%>
	<li><%=empresa.getNome() %></li>
	<%
		}
	%>

</body>
</html>