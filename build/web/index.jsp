<%-- 
    Document   : index
    Created on : 22/10/2018, 22:01:26
    Author     : Marton
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Random"%>
<%@page import="ppi.Model.FrequenciaModel"%>
<%@page import="ppi.DAO.FrequenciaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ppi.DAO.PartidaDAO"%>
<%@page import="ppi.Model.PartidaModel"%>
<%@page import="java.util.List"%>
<%@page import="ppi.DAO.Conexao"%>
<%@page import="ppi.DAO.JogadorDAO"%>
<%@page import="ppi.Model.JogadorModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="estilo.css" rel="stylesheet" type="text/css">
    </head>

    <body class="container">
        <h3>Napoli FC</h3>
        <div class="col-md-1"></div>
        <div class="menu col-md-10">
            <ul>
                <li><a href="partidas?action=list">Partidas</a></li>
                <li><a href="jogadores?action=list">Jogadores</a></li>
            </ul>

        
<!--        </div>-->
        <%   
                  FrequenciaDAO freqD = new FrequenciaDAO();
                  FrequenciaModel freqM = new FrequenciaModel();
                  PartidaModel partM = new PartidaModel();
                  JogadorModel jogM = new JogadorModel();
                  JogadorDAO jogD = new JogadorDAO();
                  List<JogadorModel> lista = jogD.buscar();
                  int i = 0;
                  Random random = new Random();
                  int totalPresencas = 0;
                  int totalPartidas = new PartidaDAO().totalPartidas();
                  int[] hexadecimal = new int[10];
        
                  // freq = (TotalPresençasX100)/totalPartidas;
        %>
        <div class="op">
        
           <table class="table">
            <tbody class="principal">
                
            <h5>Total de partidas realizadas: <%=totalPartidas%></h5>
              
            <% 
                  for(JogadorModel jogadores : lista){
                      
                      while(i < 10){
                       hexadecimal[i]=i;
                       i++;
                   } 
                    String cor = "#";
                    
                    for(i = 0; i < 6; i++) {
                        int index = random.nextInt(10);
                        cor += hexadecimal[index];                     
                    }
                    
                  totalPresencas = freqD.totalPresencas(jogadores.getId());
                  int frequencia = (totalPresencas*100)/totalPartidas; 
              %>
              <tr id="barras">
            <div class="barra<%=i%>" style="width:<%=frequencia%>%;background-color:<%=cor%>;"><%=jogadores.getNome() %> - <%=frequencia%>%</div>
            <style>
                .barra<%=i%>{ 	
  color:#FFF;
  padding-left:10px;
  height:35px;
  line-height:30px;
  font-size: 16px;
}
            </style>
              </tr>
              <%i++; } %>
            </tbody>
          </table>
        </div>
            <div class="col-md-1"></div>
        <style>
            @font-face {
               font-family: 'intro';
               src: url("Intro.otf");
             }

            h3{
                font-family: 'intro';
                width: 20%;
                margin-left: 40%;
/*                font-size: 32px;*/
                -webkit-text-stroke-width: 0.3px;
                -webkit-text-stroke-color: black;
                font-size: 2.5em;
                color: #fffdd9;
                font-weight: 600;
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
            
            .op{
                background-color: rgba(0,0,0,0.3);
                border-radius: 15px;
                padding: 10px 20px 10px 20px;
                height: 100%;
                margin-bottom: 30px;
            }
            
            
            .menu ul{
                margin-top: 50px;
                font-size: 20px;
                margin-left: 28%;
                list-style: none;
                padding: 0;
                align-items: center;
                display: flex;
                
            }
            
            .menu li{
                margin-left: 40px;
                text-transform: uppercase;
                
            }
            
            .menu li:hover{
                opacity: 0.5;
            }
            
            .menu a{
                color: white;
                letter-spacing: 2px;
                text-decoration: none;
            }
            
            
            .principal {
  width:300px;
  margin-left:10px;
  font-family:Verdana, Helvetica, sans-serif;
  font-size:19px;
}
#barras{
  width:300px;
  margin: 2px 0;
}


        </style>
    </body>
</html>
