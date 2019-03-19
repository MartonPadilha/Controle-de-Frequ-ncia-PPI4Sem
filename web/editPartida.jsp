<%-- 
    Document   : insPartida
    Created on : 31/10/2018, 21:43:16
    Author     : Marton
--%>
<%@page import="ppi.Model.PartidaModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Partida</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="estilo.css" rel="stylesheet" type="text/css">
    </head>
    <body class="container">
        <h3>Editar Partida</h3>
        <% 
            PartidaModel partM = (PartidaModel) request.getAttribute("buscaid");
        %>
        <form action="partida" method="post">
            <label for="idequipe1">Mandante: </label>
            <input type="text" id="idequipe1" name="equipe1" required value="<%=partM.getEquipe1()%>">
            <label for="idequipe2">Visitante: </label>
            <input type="text" id="idequipe2" name="equipe2" required value="<%=partM.getEquipe2()%>">
            <label for="idlocal">Local: </label>
            <input type="text" id="idlocal" name="local" required value="<%=partM.getLocal()%>">
            <label for="iddata">Data: </label>
            <input type="date" id="iddata" name="data" required value="<%=partM.getData() %>">
            <label for="idhora">Hora: </label>
            <input type="time" id="idhora" name="hora" required value="<%=partM.getHora()%>"><br>
            <input type="submit" value="Salvar" style="margin:15px 0 10px 43%;">
            <button><a href="partidas?action=list">Voltar</a></button>
        </form>
            <style>
            h3{
                font-family: 'intro';
                width: 40%;
                margin-left: 35%;
/*                font-size: 32px;*/
                -webkit-text-stroke-width: 1px;
                -webkit-text-stroke-color: black;
                font-size: 2.5em;
                color: #fffdd9;
                font-weight: 600;
                margin-bottom: 20px;
            }
                form{
                    margin: 40px 0px 25px 0px;
                }
                form label{
                    margin-left: 8px;
                }
                
                a{
                    color: black;
                }
            </style>
    </body>
</html>
