<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Sistema de Cinema</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>

<div class="barraNav">
    <h2 id="titulo">🎬 Sistema de Gerenciamento de Cinema</h2>
</div>

<br>

<div class="container">

    <h3>📌 Operações com Filme</h3>

    <a href="cadastrarFilme" class="btn">Cadastrar Filme</a>
    <a href="listarFilmes" class="btn">Editar Filme</a>
    <a href="buscarFilme" class="btn">Buscar Filme</a>

    <hr>

    <h3>📊 Consultas SQL do Projeto</h3>

    <a href="consultaGenero.jsp" class="btn">Consulta 1 - INNER JOIN (Gênero)</a>
    <a href="consultaClassificacao.jsp" class="btn">Consulta 2 - INNER JOIN (Classificação)</a>
    <a href="consultaQtdFilme.jsp" class="btn">Consulta 3 - GROUP BY (Sessões por Filme)</a>
    <a href="consultaTipoSala.jsp" class="btn">Consulta 4 - GROUP BY (Tipo Sala)</a>
    <a href="consultaLeftJoin.jsp" class="btn">Consulta 5 - LEFT JOIN</a>
    <a href="consultaSubconsulta.jsp" class="btn">Consulta 6 - Subconsulta</a>

</div>

</body>
</html>