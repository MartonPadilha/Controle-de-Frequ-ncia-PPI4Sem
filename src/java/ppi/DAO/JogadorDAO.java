/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppi.DAO;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ppi.Model.JogadorModel;

/**
 *
 * @author Marton
 */
public class JogadorDAO implements InterfaceDAO<JogadorModel>{
    private Connection conexao;
   
    public int totalJogadores(){
      
        
        ResultSet rs = null;
        int contador = 0;
        try{
            conexao = Conexao.conectar();
            String query = "SELECT id from jogador where status = 1";
            PreparedStatement stmt = conexao.prepareStatement(query);        
            rs = stmt.executeQuery();           
                while(rs.next()){
                contador++;
                }
                
        } catch(Exception e){
            out.print("Erro: " + e.getMessage());
        } finally{
            Conexao.desconectar(conexao);
        }
        return contador;
     
    }
    
    
    @Override
    public boolean inserir(JogadorModel objeto) {
        try {
            conexao = Conexao.conectar();
            String query = "insert into jogador(nome, status) values(?, 1)";
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement(query);
            stmt.setString(1, objeto.getNome());
            stmt.execute();
            stmt.close();
 
            return true;
                             
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro" + e.getMessage());
            return false;
        } finally{
            Conexao.desconectar(conexao);
        }
    }

    @Override
    public List<JogadorModel> buscar() {
        ResultSet resultSet = null;
      List<JogadorModel> lista = new ArrayList<JogadorModel>();
      try {
          conexao = Conexao.conectar();
          String query = "select id, nome from jogador where status = 1";
          PreparedStatement stmt = conexao.prepareStatement(query);        
          resultSet = stmt.executeQuery();
          
          while(resultSet.next()){
              JogadorModel jogM = new JogadorModel();
              jogM.setId(resultSet.getInt("id"));
              jogM.setNome(resultSet.getString("nome"));
              
              lista.add(jogM);
          }
          
          resultSet.close();
      } catch(Exception e){
          System.out.println("Erro ao inserir" + e.getMessage());
      } finally {
          Conexao.desconectar(conexao);
          return lista;
      }
    }

    @Override
    public boolean apagar(JogadorModel objeto) {
        try {
            //não apaga, só oculta do campo da view
            conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("update jogador set status = 0 where id=?");
            stmt.setInt(1, objeto.getId());
            
            stmt.execute();
            stmt.close();
            System.out.println("Registro deletado com sucesso!"); 
            return true;
        } catch(Exception e){
            System.out.println("Erro ao deletar " + e.getMessage());
            return false;
        } finally{
            Conexao.desconectar(conexao);
        }
    }

    @Override
    public boolean editar(JogadorModel objeto) {
         try {
            conexao = Conexao.conectar();
            String query = "update jogador set nome = ? where id = ?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, objeto.getNome());
            stmt.setInt(2, objeto.getId());
            stmt.executeUpdate();
            System.out.println("Cadastro de id " + objeto.getId() + " atualizado com sucesso.");
            stmt.close();
            return true;
        }
        catch(Exception e){
            System.out.println("Erro ao atualizar. " + e.getMessage());
            return false;
        }
        finally{
            Conexao.desconectar(conexao);
        }
    }

    @Override
    public JogadorModel buscar(int id) {
        ResultSet resultSet = null;
        JogadorModel jogM = null;
        
        try{
            conexao = Conexao.conectar();
            String query = "select id, nome from jogador where id = ?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id);
            resultSet = stmt.executeQuery();
            
            while(resultSet.next()){
                jogM = new JogadorModel();
                jogM.setId(resultSet.getInt("id"));
                jogM.setNome(resultSet.getString("nome"));
            }
            resultSet.close();   
        }
        catch(Exception e){
            System.out.println("Esso: " + e.getMessage());
        }
        finally{
            Conexao.desconectar(conexao);
            return jogM;
        }
    }


}
