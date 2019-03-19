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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import ppi.Model.JogadorModel;
import ppi.Model.PartidaModel;

/**
 *
 * @author Marton
 */
public class PartidaDAO implements InterfaceDAO<PartidaModel> {
    private Connection conexao;
    
    
     public int totalPartidas(){
      
        
        ResultSet rs = null;
        int contador = 0;
        try{
            conexao = Conexao.conectar();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dataAtual = formatter.format( new Date() );
            String query = "SELECT id from partida where data < '"+dataAtual+"' and status = 1";
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
     
     public boolean verificaPartida(int id_partida) throws Exception{
        boolean existe;
        conexao = Conexao.conectar();
            PreparedStatement psmt = conexao.prepareStatement("SELECT  id_partida FROM frequencia WHERE id_partida = ?");
            psmt.setInt(1, id_partida); 
            ResultSet rs = psmt.executeQuery();
            existe = rs.next();
            conexao.close();
            return existe; 
    }
    
    @Override
    public boolean inserir(PartidaModel objeto) {
            try {
            conexao = Conexao.conectar();
            String query = "insert into partida(equipe1, equipe2, local, data, hora, status) values(?, ?, ?, ?, ?, 1)";
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement(query);
            stmt.setString(1, objeto.getEquipe1());
            stmt.setString(2, objeto.getEquipe2());
            stmt.setString(3, objeto.getLocal());
            stmt.setString(4, objeto.getData());
            stmt.setString(5, objeto.getHora());
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
    public List<PartidaModel> buscar() {
        ResultSet resultSet = null;
        List<PartidaModel> lista = new ArrayList<PartidaModel>();
      try {
            Calendar cal = GregorianCalendar.getInstance();
            int anoAtual = cal.get(Calendar.YEAR);
          conexao = Conexao.conectar();
          String query = "select id, equipe1, equipe2, local, data, hora from partida where data > '" + anoAtual + "-01-01' and status = 1 order by data";
          PreparedStatement stmt = conexao.prepareStatement(query);        
          resultSet = stmt.executeQuery();
          
          while(resultSet.next()){
              PartidaModel partidaM = new PartidaModel();
              partidaM.setId(resultSet.getInt("id"));
              partidaM.setEquipe1(resultSet.getString("equipe1"));
              partidaM.setEquipe2(resultSet.getString("equipe2"));
              partidaM.setLocal(resultSet.getString("local"));
              partidaM.setData(resultSet.getString("data"));
              partidaM.setHora(resultSet.getString("hora"));
              
              lista.add(partidaM);
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
    public boolean apagar(PartidaModel objeto) {
        try {
            //não apaga, só oculta do campo da view
            conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("update partida set status = 0 where id=?");
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
    public boolean editar(PartidaModel objeto) {
        try {
            conexao = Conexao.conectar();
            String query = "update partida set equipe1 = ?, equipe2 = ?, local = ?, data = ?, hora = ? where id = ?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, objeto.getEquipe1());
            stmt.setString(2, objeto.getEquipe2());
            stmt.setString(3, objeto.getLocal());
            stmt.setString(4, objeto.getData());
            stmt.setString(5, objeto.getHora());
            stmt.setInt(6, objeto.getId());
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
    public PartidaModel buscar(int id) {
         ResultSet resultSet = null;
         PartidaModel partidaM = null;
        
        try{
            conexao = Conexao.conectar();
            String query = "select id, equipe1, equipe2, local, data, hora from partida where status = 1 and id = ?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id);
            resultSet = stmt.executeQuery();
            
            while(resultSet.next()){
                partidaM = new PartidaModel();
                partidaM.setId(resultSet.getInt("id"));
                partidaM.setEquipe1(resultSet.getString("equipe1"));
                partidaM.setEquipe2(resultSet.getString("equipe2"));
                partidaM.setLocal(resultSet.getString("local"));
                partidaM.setData(resultSet.getString("data"));
                partidaM.setHora(resultSet.getString("hora"));
            }
            resultSet.close();   
        }
        catch(Exception e){
            System.out.println("Esso: " + e.getMessage());
        }
        finally{
            Conexao.desconectar(conexao);
            return partidaM;
        }
    }
    
}
