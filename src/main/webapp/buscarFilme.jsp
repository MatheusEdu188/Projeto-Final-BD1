<%@ page import="br.edu.ifpb.bd.model.Filme" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Buscar Filme</title>
    
</head>
<body>

    <a href="index.jsp">Voltar ao Menu</a>

    <h1>Buscar Filme por ID</h1>

    <form action="buscarFilme" method="get">
        <label for="id">ID do Filme:</label>
        <input type="text" name="id" id="id" required>
        <button type="submit">Buscar</button>
    </form>

    <% 
        String mensagem = (String) request.getAttribute("mensagem");
        Filme filme = (Filme) request.getAttribute("filme");
        
        if(mensagem != null){
    %>
        <div class="mensagem"><%= mensagem %></div>
    <% } else if(filme != null) { %>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Duração (min)</th>
                    <th>Classificação</th>
                    <th>Gênero</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%= filme.getId() %></td>
                    <td><%= filme.getTitulo() %></td>
                    <td><%= filme.getDuracao() %></td>
                    <td><%= filme.getClassificacao() %></td>
                    <td><%= filme.getGenero() %></td>
                    <td>
                        <a href="editarFilme?id=<%= filme.getId() %>">Editar</a> |
                        <a href="removerFilme?id=<%= filme.getId() %>">Remover</a>
                    </td>
                </tr>
            </tbody>
        </table>
    <% } %>

</body>
</html>
