<%@ page import="java.util.*,br.edu.ifpb.bd.model.Filme" %>
<!DOCTYPE html>
<html lang="en">
<head>
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Filme</title>
</head>
<body>
    <h1>Cadastre agora</h1>

    <form  action="cadastrarFilme" method="post">
        <label for="titulo">Titulo</label>
        <input type="text" name="titulo" id="titulo">


        <label for="duracao">Duração</label>
        <input type="number" name="duracao" id="duracao">

        <label for="classificacao">Classificação</label>
        <input type="text" name="classificacao" id="classificacao">

        <label for="genero">Genero</label>
        <input type="text" name="genero" id="genero">


        <input type="submit" value="Cadastrar">
    </form>
    
</body>
</html>