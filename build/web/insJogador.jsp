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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    </head>
    <body>

        <form action="jogadores" method="post">
            <label for="idnome">Nome: </label>
            <input type="text" id="idnome" name="nome" required>
            <input type="submit" value="Adicionar">
            <button><a href="index.jsp" style="color:black;">Voltar</a></button>
        </form>
        

    </body>
</html>
