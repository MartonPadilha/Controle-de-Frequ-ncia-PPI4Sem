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
import ppi.DAO.PartidaDAO;
import ppi.Model.FrequenciaModel;
import ppi.Model.PartidaModel;

/**
 *
 * @author Marton
 */
@WebServlet(name = "partida", urlPatterns = {"/partida", "/partidas"})
public class PartidaController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PartidaDAO partD;
        PartidaModel partM;
        String pagina = "index.jsp";
        String action = request.getParameter("action");
        switch(action){
            case "list":
                partD = new PartidaDAO();
                List<PartidaModel> lista = partD.buscar();
                request.setAttribute("lista", lista);
                pagina = "partida.jsp";
                break;        
            case "del":
                partD = new PartidaDAO();
                partM = new PartidaModel();
                FrequenciaDAO freqD = new FrequenciaDAO();
                FrequenciaModel freqM = new FrequenciaModel();
                String id = request.getParameter("idpartida");
                freqM.setId_partida(Integer.parseInt(id));
                partM.setId(Integer.parseInt(id));
                boolean apagar = partD.apagar(partM);
                apagar = freqD.apagar(freqM);
                List<PartidaModel> listae = partD.buscar();
                request.setAttribute("lista", listae);
                pagina = "index.jsp";
                break;
            case "edit":
                partD = new PartidaDAO();
                String idedit = request.getParameter("idpartida");
                PartidaModel obj = partD.buscar(Integer.parseInt(idedit));
                request.setAttribute("buscaid", obj);
                pagina = "editPartida.jsp";
                break;
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(pagina);
        rd.forward(request, response);
 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("idpartida");
        String equipe1 = request.getParameter("equipe1");
        String equipe2 = request.getParameter("equipe2");
        String local = request.getParameter("local");
        String data = request.getParameter("data");
        String hora = request.getParameter("hora");
        
        PartidaModel partM = new PartidaModel();
        PartidaDAO partD = new PartidaDAO();
        
        String pagina = "index.jsp";
        
        partM.setEquipe1(equipe1);
        partM.setEquipe2(equipe2);
        partM.setLocal(local);
        partM.setData(data);
        partM.setHora(hora);
        
        if (request.getParameter("idpartida")==null) {
            partD.inserir(partM);
            pagina = "index.jsp";
        } else {
            partM.setId(Integer.parseInt(id));
            partD.editar(partM);
            pagina = "index.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
    }


}
