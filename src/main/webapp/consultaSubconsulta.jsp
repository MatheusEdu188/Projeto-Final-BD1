<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Filme com Mais Sessões</title>
</head>
<body>

<h2>Filme com Maior Número de Sessões</h2>

<a href="consultaSubconsulta">Descobrir Filme</a>

<hr>

<h3>Resultado:</h3>

<%
    String resultado = (String) request.getAttribute("resultado");

    if (resultado != null) {
%>
        <p>Filme com mais sessões: <strong><%= resultado %></strong></p>
<%
    }
%>

</body>
</html>