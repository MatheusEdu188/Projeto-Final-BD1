<%@ page import="java.util.*,br.edu.ifpb.bd.model.Filme" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Filmes</title>
    
</head>
<body>

    <a href="index.jsp">Voltar ao Menu</a>

    <h1>Filmes Cadastrados</h1>

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
            <% 
                List<Filme> filmes = (List<Filme>) request.getAttribute("filmes");
                if(filmes != null && !filmes.isEmpty()){
                    for(Filme filme : filmes){
            %>
                <tr>
                    <td><%= filme.getId() %></td>
                    <td><%= filme.getTitulo() %></td>
                    <td><%= filme.getDuracao() %></td>
                    <td><%= filme.getClassificacao() %></td>
                    <td><%= filme.getGenero() %></td>
                    <td>
                        <a href="editarFilme?id=<%= filme.getId() %>">Editar</a>
                    </td>
                    <td>
                        <a href="removerFilme?id=<%= filme.getId() %>">Remover</a>
                    </td>
                </tr>
            <%  
                    }
                } else { 
            %>
                <tr>
                    <td colspan="6">Nenhum filme cadastrado.</td>
                </tr>
            <% } %>
        </tbody>
    </table>

</body>
</html>
