<%-- 
    Document   : partida
    Created on : 29/10/2018, 21:48:19
    Author     : Marton
--%>

<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ppi.DAO.PartidaDAO"%>
<%@page import="ppi.Model.PartidaModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partidas</title>
        <link href="estilo.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body class="container">
        <h3>Jogos</h3>
         <%@include file="/insPartida.jsp" %>
         <div class="op">
         <table class="table">
          <thead>
            <tr>
              <th scope="col">Mandante</th>
              <th scope="col">X</th>
              <th scope="col">Visitante</th>
              <th scope="col">Local</th>
              <th scope="col">Data</th>
              <th scope="col">Hora</th>
              <td scope="col" colspan="3" align="center">#</td>
            </tr>
          </thead>
          <tbody>
            <%               
                ArrayList<PartidaModel> listPartidas = (ArrayList<PartidaModel>) request.getAttribute("lista");
                for(PartidaModel partidas : listPartidas){
            %>
            <tr>
              <td><%=partidas.getEquipe1()%></td>
              <td>X</td>
              <td><%=partidas.getEquipe2()%></td>
              <td><%=partidas.getLocal()%></td>
              <td><%=partidas.getData()%></td>
              <td><%=partidas.getHora()%></td>
              <%
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String dataAtual = formatter.format( new Date() );
                Date dataJogo = formatter.parse(partidas.getData());
                Date dataSistema = formatter.parse(dataAtual);
                PartidaDAO partD = new PartidaDAO();

  if(partD.verificaPartida(partidas.getId()) == false && dataJogo.before(dataSistema)){%>
              <td><button><a href="chamada?action=list&idpartida=<%=partidas.getId()%>">Presença</a></button></td>
              <%}%>
              <td><button><a href="partida?action=edit&idpartida=<%=partidas.getId()%>">Editar</a></button></td>
              <td><button><a href="partida?action=del&idpartida=<%=partidas.getId()%>">Excluir</a></button></td>
            </tr>
            <% } %>
          </tbody>
        </table>
         </div>
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
              .table button{
                  margin-left: -40px;
              }
              .table {
                  font-size: 16px;
                  color: white;
              }
              
              .op{
               background-color: rgba(0,0,0,0.6);
               border-radius: 15px;
               padding: 15px 15px 15px 15px;
              }
              
              th{
                  font-size: 17px;
                  color: rgb(0,206,209);
              }
          </style>
    </body>
</html>
