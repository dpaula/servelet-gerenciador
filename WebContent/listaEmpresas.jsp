<%@page import="br.com.lima.model.Empresa"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="br.com.lima.util.JPAUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- 	core da jstl é voltado par controle de fluxo -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- fmt da jstl é voltado para formatações -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
    //trazendo a lista de empresas que foi setado no servlet
// 	List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard TagLib</title>
</head>
<body>

<!-- 		fazendo um if null com expression language						 -->
		<c:if test="${not empty nomeEmpresa }">
	<!-- 		Usando linguagem de expressão para imprimir a variável que foi setada no request do servlet -->
			Nova Empresa: ${ nomeEmpresa } cadastrada com sucesso!
		</c:if>
		<c:if test="${empty nomeEmpresa }">
	<!-- 		Usando linguagem de expressão para imprimir a variável que foi setada no request do servlet -->
			Empresa: ${ nomeEmpresa } já cadastrada!
		</c:if>
		<br>

	Lista Empresas: <br>
	

	<ul>
<!-- 		usando expression language para buscar empresas que foi carregada o servlet -->
		<c:forEach items="${empresas}" var="empresa">
<!-- 			com expression language, basta usar ponto e nome do atributo diretamente -->
			<li>${empresa.nome} - 
<!-- 			usando formatação de data, trazendo a data do objeto, q é tipo java.util.Date e passando um padrão -->
			<fmt:formatDate value="${empresa.data }" pattern="dd/MM/yyyy"/></li>
		
		</c:forEach>
	
	</ul>
	
	
	
<%-- 	<% --%>
<!--  		for (Empresa empresa : empresas) { -->
<%-- 	%> --%>
<%-- 	<li><%=empresa.getNome() %></li> --%>
<%-- 	<% --%>
<!--  		} -->
<%-- 	%> --%>

</body>
</html>