<!-- 	core da jstl é voltado par controle de fluxo -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- url monta o caminho completo com contexto dinamico, definindo em uma variavel -->
<c:url value="/novaEmpresa" var="linkServletNovaEmresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de empresa</title>
</head>
<body>

	<!-- 	chamar o servlet, por default usa o method GET -->
<!-- 	usando expression language para setar a variavel do caminho do servlet -->
	<form action="${linkServletNovaEmresa }" method="POST">

		<label for="novaEmpresa">Empresa:</label> 
		<input type="text" name="nomeEmpresa" id="nomeEmpresa"> 
		<input type="submit" value="Cadastrar">
	</form>

</body>
</html>