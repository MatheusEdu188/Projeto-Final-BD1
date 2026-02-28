<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Consulta por Gênero</title>
</head>
<body>

<h2>Consultar Sessões por Gênero</h2>

<form action="consultaGenero" method="get">
    Gênero: 
    <input type="text" name="genero" required>
    <button type="submit">Buscar</button>
</form>

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