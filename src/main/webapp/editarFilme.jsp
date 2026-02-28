<%@ page import="br.edu.ifpb.bd.model.Filme" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar Filme</title>
</head>
<body>

    <a href="listarFilmes">Voltar</a>

    <h1>Editar Filme</h1>

    <%
        Filme filme = (Filme) request.getAttribute("filme");

        if(filme != null){
    %>

    <form action="editarFilme" method="post">

        
        <input type="hidden" name="id" value="<%= filme.getId() %>">

        <label>Título:</label><br>
        <input type="text" name="titulo" value="<%= filme.getTitulo() %>"><br><br>

        <label>Duração:</label><br>
        <input type="number" name="duracao" value="<%= filme.getDuracao() %>"><br><br>

        <label>Classificação:</label><br>
        <input type="text" name="classificacao" value="<%= filme.getClassificacao() %>"><br><br>

        <label>Gênero:</label><br>
        <input type="text" name="genero" value="<%= filme.getGenero() %>"><br><br>

        <input type="submit" value="Salvar Alterações">

    </form>

    <%
        } else {
    %>
        <p>Filme não encontrado.</p>
    <%
        }
    %>

</body>
</html>
