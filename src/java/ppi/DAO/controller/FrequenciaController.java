/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppi.DAO.controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ppi.DAO.FrequenciaDAO;
import ppi.DAO.JogadorDAO;
import ppi.DAO.PartidaDAO;
import ppi.Model.FrequenciaModel;
import ppi.Model.JogadorModel;
import ppi.Model.PartidaModel;

/**
 *
 * @author Marton
 */

@WebServlet(name = "frequencia", urlPatterns ={"/frequencia", "/chamada"})
public class FrequenciaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FrequenciaModel freqM = new FrequenciaModel();
        FrequenciaDAO freqD = new FrequenciaDAO();
        JogadorDAO jogD = new JogadorDAO();
        PartidaDAO partD = new PartidaDAO();
        String pagina = "index.jsp";
        String acao = request.getParameter("action");
        switch(acao){
            case "list":
                List<JogadorModel> lista = jogD.buscar();
                request.setAttribute("lista", lista);
                String idpartida = request.getParameter("idpartida");
                PartidaModel obj = partD.buscar(Integer.parseInt(idpartida));
                request.setAttribute("buscaid", obj);
                
                pagina = "chamada.jsp";
                break;
        }
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FrequenciaDAO freqD = new FrequenciaDAO();
        String idpartida = request.getParameter("idpartida");
        
        int i = 0;
        while(request.getParameter("idjogador_"+ i) != null){
            FrequenciaModel freqM = new FrequenciaModel();
            String idjogador = request.getParameter("idjogador_"+ i);
            String presenca = request.getParameter("presenca_"+i);
            
            freqM.setId_partida(Integer.parseInt(idpartida));
            freqM.setId_jogador(Integer.parseInt(idjogador));
            freqM.setPresenca(Integer.parseInt(presenca));
            freqD.inserir(freqM);
            
            i++;
        }
        
             
        String pagina = "index.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(pagina);
        rd.forward(request, response);
    }

}
