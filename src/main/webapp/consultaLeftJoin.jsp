<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Filmes com ou sem Sessão</title>
</head>
<body>

<h2>Filmes com ou sem Sessão</h2>

<a href="consultaLeftJoin">Carregar Consulta</a>

<hr>

<h3>Resultado:</h3>

<%
    List<String> resultado = (List<String>) request.getAttribute("resultado");

    if (resultado != null && !resultado.isEmpty()) {
        for (String linha : resultado) {
%>
            <p><%= linha %></p>
<%
        }
    } else if (resultado != null) {
%>
        <p>Nenhum resultado encontrado.</p>
<%
    }
%>

</body>
</html>