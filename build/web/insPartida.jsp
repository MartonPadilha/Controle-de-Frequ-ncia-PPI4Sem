<%-- 
    Document   : insPartida
    Created on : 31/10/2018, 21:43:16
    Author     : Marton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    </head>
    <body>
        <form action="partida" method="post">
            <label for="idequipe1">Mandante: </label>
            <input type="text" id="idequipe1" name="equipe1" required>
            <label for="idequipe2">Visitante: </label>
            <input type="text" id="idequipe2" name="equipe2" required>
            <label for="idlocal">Local: </label>
            <input type="text" id="idlocal" name="local" required>
            <label for="iddata">Data: </label>
            <input type="date" id="iddata" name="data" required>
            <label for="idhora">Hora: </label>
            <input type="time" id="idhora" name="hora" required><br>
            <input type="submit" value="Cadastrar" style="margin:20px 0 25px 40%;">
            <button class="t"><a href="index.jsp">Voltar</a></button>
        </form>
        <style>
             form label{
                    margin-left: 8px;
                }
            a{ 
                text-decoration: none;
                color: black;
            }
            a:hover{
                text-decoration: none;
                color: black;
            }
        </style>
    </body>
</html>
