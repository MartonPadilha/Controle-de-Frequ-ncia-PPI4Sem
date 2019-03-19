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
import ppi.DAO.JogadorDAO;
import ppi.Model.JogadorModel;

/**
 *
 * @author Marton
 */
@WebServlet(name = "jogadores", urlPatterns = {"/jogador", "/jogadores"})
public class JogadorController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JogadorDAO jogD;
        JogadorModel jogM;
        String pagina = "index.jsp";
        String action = request.getParameter("action");
        
        switch(action){
            case "list":
                jogD = new JogadorDAO();
                List<JogadorModel> lista = jogD.buscar();
                request.setAttribute("lista", lista);
                pagina = "jogadores.jsp";
                break;
            case "del":
                jogM = new JogadorModel();
                jogD = new JogadorDAO();
                String id = request.getParameter("id");
                jogM.setId(Integer.parseInt(id));
                boolean apagar = jogD.apagar(jogM);
                String msg = null;
                if (apagar) {
                    msg = "<script>alert('Jogador deletado com sucesso!');</script>";
                } else {
                    msg = "<script>alert('Falha ao deletar jogador!');</script>";
                }
                List<JogadorModel> listae = jogD.buscar();
                request.setAttribute("lista", listae);
                request.setAttribute("msg", msg);
                pagina = "jogadores.jsp";
                break;
            case "edit":
                jogD = new JogadorDAO();
                String idedit = request.getParameter("id");
                JogadorModel obj = jogD.buscar(Integer.parseInt(idedit));
                request.setAttribute("buscaid", obj);
                
                pagina = "editJogador.jsp";
                break;
                
                
                
        }
        RequestDispatcher rd = request.getRequestDispatcher(pagina);
        rd.forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        
        JogadorModel jogM = new JogadorModel();
        JogadorDAO jogD = new JogadorDAO();
        
        String pagina = "index.jsp";
        jogM.setNome(nome);
        
        if (request.getParameter("id")==null) {
            jogD.inserir(jogM);
            out.print("<script>alert('Jogador adicionado com sucesso!');</script>");
            pagina = "index.jsp";
        } else {
            jogM.setId(Integer.parseInt(id));
            jogD.editar(jogM);
            pagina = "index.jsp";
        }
        request.setAttribute("mensagem", "Cadastro realizado com sucesso");
        RequestDispatcher rd = request.getRequestDispatcher(pagina);
                rd.forward(request, response);
    }

}
