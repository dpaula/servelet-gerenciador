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
<!-- 		valeu carrega por expression language a empresa que foi carregada no request do servlet que chamou este jsp -->
		<input type="text" name="nomeEmpresa" id="nomeEmpresa" value="${empresa.nome }"> 
		<label for="data">Data:</label> 
		<input type="date" name="data" id="data" value="${empresa.data }"> 
		<input type="submit" value="Salvar">
	</form>

</body>
</html>