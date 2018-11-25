<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!-- 	core da jstl é voltado par controle de fluxo -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!--     scriptLet -->
<%
	//este atributo foi setado no request do servlet que chama esta pagina jsp, 
	//String novaEmpresa = (String) request.getAttribute("nomeEmpresa");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<h2>
<!-- 		fazendo um if null com expression language						 -->
		<c:if test="${not empty nomeEmpresa }">
	<!-- 		Usando linguagem de expressão para imprimir a variável que foi setada no request do servlet -->
			Nova Empresa: ${ nomeEmpresa } cadastrada com sucesso!
		</c:if>
		<c:if test="${empty nomeEmpresa }">
	<!-- 		Usando linguagem de expressão para imprimir a variável que foi setada no request do servlet -->
			Empresa: ${ nomeEmpresa } já cadastrada!
		</c:if>


	</h2>

</body>
</html>