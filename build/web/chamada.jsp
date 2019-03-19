<%-- 
    Document   : partida
    Created on : 29/10/2018, 21:48:19
    Author     : Marton
--%>

<%@page import="ppi.Model.JogadorModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ppi.DAO.PartidaDAO"%>
<%@page import="ppi.Model.PartidaModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chamada</title>
        <link href="estilo.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body class="container">
        <h3>Chamada</h3>
        <div class="op">
         <table class="table">
          <thead>
            <tr>
              <th scope="col">Nome</th>
              <th scope="col">Presente?</th>
            </tr>
          </thead>
          <tbody>
            <%
                int i = 0;
                PartidaModel partM = (PartidaModel)request.getAttribute("buscaid");
                ArrayList<JogadorModel> listPartidas = (ArrayList<JogadorModel>) request.getAttribute("lista");
                for(JogadorModel jogadores : listPartidas){
            %>
            <tr>
              <td><%=jogadores.getNome() %></td>
          <form action="chamada" method="post">
              <td><input style="display: none;" name="idpartida" value="<%=partM.getId()%>">
                  <input style="display: none;" name="idjogador_<%=i%>" value="<%=jogadores.getId()%>">
                  <input type="radio" id="presencas" name="presenca_<%=i%>" value="1" checked>
                   <label for="presencas">Sim</label>
                   <input type="radio" id="presencan" name="presenca_<%=i%>" value="0">
                   <label for="presencan">Não</label>
              </td>
            </tr>
            <% i++;} %>
            <tr>
                <td></td>
                <td><input type="submit" value="Salvar" class="buttom">
                    <button><a href="partidas?action=list" class="buttom">Voltar</a></button>
                </td>
            </tr>
            </form>
          </tbody>
        </table>
      </div>
            <style>
              .op{
                  background-color: rgba(0,0,0,0.6);
                  border-radius: 20px;
                  width: 70%;
                  margin-bottom: 15px;
                  margin-left: 15%;
                  padding-left: 5px;
                  padding-right: 5px;
                  padding-top: 10px;
              }
              
              table{
                  color: white;
                  font-size: 17px;
              }
              
              table .buttom{
                  color: black;
              }
              
                h3{
                font-family: 'intro';
                width: 20%;
                margin-left:40%;
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
