<%-- 
    Document   : insPartida
    Created on : 31/10/2018, 21:43:16
    Author     : Marton
--%>

<%@page import="ppi.Model.JogadorModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Jogador</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="estilo.css" rel="stylesheet" type="text/css">
    </head>
    <body class="container">
                <h3>Editar Jogador</h3>
                <div class="col-md-4"></div>
        <div class="col-md-4">
        <% 
            JogadorModel jogM = (JogadorModel) request.getAttribute("buscaid");
        %>
        <form action="jogadores" method="post">
            <input type="text" id="id" name="id" readonly style="display: none;" value="<%=jogM.getId()%>">
            <label for="idnome">Nome: </label>
            <input type="text" id="idnome" name="nome" value="<%=jogM.getNome()%>">
            <input type="submit" value="Salvar"> 
            <button><a href="jogadores?action=list">Voltar</a></button>
        </form>
        </div>
            <div class="col-md-4"></div>
            <style>
                        h3{
                font-family: 'intro';
                width: 20%;
                margin-left: 40%;
/*                font-size: 32px;*/
                -webkit-text-stroke-width: 1px;
                -webkit-text-stroke-color: black;
                font-size: 2.5em;
                color: #fffdd9;
                font-weight: 600;
                margin-bottom: 20px;
            }
            </style>
    </body>
</html>
