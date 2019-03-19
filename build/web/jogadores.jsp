<%-- 
    Document   : partida
    Created on : 29/10/2018, 21:48:19
    Author     : Marton
--%>

<%@page import="ppi.DAO.JogadorDAO"%>
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
        <title>Jogadores</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="estilo.css" rel="stylesheet" type="text/css">

    </head>
    <body class="container jogadores">
        <div class="menu">
        <h3>Elenco</h3>
        <%@include file="/insJogador.jsp" %>
        </div>
        <div class="col-md-2"></div>
        <div class="op col-md-8">
            <% 
            JogadorDAO jogD = new JogadorDAO();
            int totalPartidas = new JogadorDAO().totalJogadores();
            %>
            <h5>Total de jogadores: <%=totalPartidas%></h5>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">Nome</th>
              <th scope="col">Ações</th>
            </tr>
          </thead>
          <tbody>
            <%
                ArrayList<JogadorModel> listPartidas = (ArrayList<JogadorModel>) request.getAttribute("lista");
                for(JogadorModel jogadores : listPartidas){
            %>
            <tr>
              <td><%=jogadores.getNome() %></td>
              <td>
                  <a href="jogadores?action=edit&id=<%=jogadores.getId() %>"><button>Editar</button></a>
                  <a href="jogadores?action=del&id=<%=jogadores.getId()%>"><button>Excluir</button></a>
              </td>
            </tr>
            <% } %>
          </tbody>
        </table>
        </div>
          <div class="col-md-2"></div>
         
          <style>
              tr {
                  color: white;
                  font-size: 15px;
                 
              }
              
              .menu{
                  margin-left: 30%;
                  padding-bottom: 20px;
              }
              
             .menu h1{
                 text-transform: uppercase;
                 margin-left: 13%;
              }
              
              .table{
                 
                  margin: 10px 0px 10px 0px;

              }
              .op{
                  background-color: rgba(0,0,0,0.6);
                  border-radius: 20px;
                  width: 70%;
                  margin-bottom: 15px;
              }
                h3{
                font-family: 'intro';
                width: 40%;
                margin-left: 18%;
/*                font-size: 32px;*/
                -webkit-text-stroke-width: 1px;
                -webkit-text-stroke-color: black;
                font-size: 2.5em;
                color: #fffdd9;
                font-weight: 600;
                margin-bottom: 20px;
            }
                        h5{
                margin: 25px 0 20px 0;
                font-size: 20px;
                font-family: 'intro';
                color: white;
                font-weight: 100;
                -webkit-text-stroke-width: 0.1px;
                -webkit-text-stroke-color: black;
            }
          </style>

    </body>
</html>
