<%@ page import="java.util.*,br.edu.ifpb.bd.model.Filme" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Filmes</title>
    <style>
        table { border-collapse: collapse; width: 80%; }
        th, td { border: 1px solid #000; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        a { text-decoration: none; color: blue; }
    </style>
</head>
<body>

    <a href="index.html">Voltar ao Menu</a>

    <h1>Filmes Cadastrados</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Duração (min)</th>
                <th>Classificação</th>
                <th>Gênero</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Filme> filmes = (List<Filme>) request.getAttribute("filmes");
                if(filmes != null){
                    for(Filme filme : filmes){
            %>
                <tr>
                    <td><%= filme.getId() %></td>
                    <td><%= filme.getTitulo() %></td>
                    <td><%= filme.getDuracao() %></td>
                    <td><%= filme.getClassificacao() %></td>
                    <td><%= filme.getGenero() %></td>
                </tr>
            <%  
                    }
                } else { 
            %>
                <tr>
                    <td colspan="5">Nenhum filme cadastrado.</td>
                </tr>
            <% } %>
        </tbody>
    </table>

</body>
</html>
