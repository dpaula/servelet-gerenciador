<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!--     scriptLet -->
<%
	//este atributo foi setado no request do servlet que chama esta pagina jsp, 
	String novaEmpresa = (String) request.getAttribute("nomeEmpresa");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>
		Nova Empresa:
		<%=novaEmpresa%>
		cadastrada com sucesso!

	</h2>

</body>
</html>