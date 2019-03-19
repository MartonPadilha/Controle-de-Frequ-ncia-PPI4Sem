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
import ppi.Model.FrequenciaModel;
import ppi.Model.JogadorModel;
import ppi.Model.PartidaModel;

/**
 *
 * @author Marton
 */
public class FrequenciaDAO{
    
    private Connection conexao;
    
    
    public int totalPresencas(int id_jogador){
        // freq = (TotalPresençasX100)/totalPartidas;
        ResultSet rs = null;
        int contador = 0;
        int i = 0;
        try{
            conexao = Conexao.conectar();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dataAtual = formatter.format( new Date() );
            String query = "SELECT count(*) from frequencia where id_jogador = ? and presenca = 1";
            PreparedStatement stmt = conexao.prepareStatement(query);        
            stmt.setInt(1, id_jogador);
            rs = stmt.executeQuery();           
                if(rs.next()){
                contador = rs.getInt(1);
                }
                
        } catch(Exception e){
            out.print("Erro: " + e.getMessage());
        } finally{
            Conexao.desconectar(conexao);
        }
        return contador;
     
    }
    
    public boolean inserir(FrequenciaModel objeto) {
    try {
            conexao = Conexao.conectar();
            String query = "insert into frequencia(id_partida, id_jogador, presenca) values(?, ?, ?)";
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement(query);
            stmt.setInt(1, objeto.getId_partida());
            stmt.setInt(2, objeto.getId_jogador());
            stmt.setInt(3, objeto.getPresenca());
            stmt.execute();
            stmt.close();
 
            return true;
                             
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally{
            Conexao.desconectar(conexao);
        }        
    }
    
    public List<FrequenciaModel> buscar() {
      ResultSet resultSet = null;
      List<FrequenciaModel> lista = new ArrayList<FrequenciaModel>();
      try {
          conexao = Conexao.conectar();
          String query = "select id_partida, id_jogador, presenca from frequencia";
          PreparedStatement stmt = conexao.prepareStatement(query);        
          resultSet = stmt.executeQuery();
          
          while(resultSet.next()){
              FrequenciaModel freqM = new FrequenciaModel();
              freqM.setId_partida(resultSet.getInt("id_partida"));
              freqM.setId_jogador(resultSet.getInt("id_jogador"));
              freqM.setPresenca(resultSet.getInt("presenca"));
              
              lista.add(freqM);
          }
          
          resultSet.close();
      } catch(Exception e){
          System.out.println("Erro: " + e.getMessage());
      } finally {
          Conexao.desconectar(conexao);
          return lista;
      }        
    }
    
    public boolean apagar(FrequenciaModel objeto) {
        try {
            //não apaga, só oculta do campo da view
            conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("delete from frequencia where id_partida = ?");
            stmt.setInt(1, objeto.getId_partida());
//            stmt.setInt(2, objeto.getId_jogador());
            
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

    public boolean editar(FrequenciaModel objeto) {
         try {
            conexao = Conexao.conectar();
            String query = "update frequencia set frequencia = ? where id_partida = ? and id_jogador = ?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, objeto.getPresenca());
            stmt.setInt(2, objeto.getId_partida());
            stmt.setInt(3, objeto.getId_jogador());
            
            stmt.executeUpdate();
            System.out.println("Cadastro de id atualizado com sucesso.");
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

    public FrequenciaModel buscar(int id_partida, int id_jogador) {
        ResultSet resultSet = null;
        FrequenciaModel freqM = null;
        
        try{
            conexao = Conexao.conectar();
            String query = "select id_partida, id_jogador, presenca from frequencia where id_partida = ? and id_jogador = ?" ;
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id_partida);
            stmt.setInt(2, id_jogador);
            resultSet = stmt.executeQuery();
            
            while(resultSet.next()){
                freqM = new FrequenciaModel();
                freqM.setId_partida(resultSet.getInt("id_partida"));
                freqM.setId_jogador(resultSet.getInt("id_jogador"));
                freqM.setPresenca(resultSet.getInt("presenca"));
            }
            resultSet.close();   
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        finally{
            Conexao.desconectar(conexao);
            return freqM;
        }        
    }
}
