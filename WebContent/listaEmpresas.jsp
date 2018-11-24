<%@page import="br.com.lima.model.Empresa"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="br.com.lima.util.JPAUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	EntityManager em = JPAUtil.getInstance().getEntityManager();
	String jpql = "select e from Empresa e";

	//usando TypedQuery para trazer a lista já com a tipagem correga
	TypedQuery<Empresa> query = em.createQuery(jpql, Empresa.class);
	List<Empresa> empresas = query.getResultList();
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