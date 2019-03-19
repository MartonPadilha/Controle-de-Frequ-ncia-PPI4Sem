/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppi.Model;

/**
 *
 * @author Marton
 */
public class FrequenciaModel {
    private int presenca;
    private int id_jogador;
    private int id_partida;

    public FrequenciaModel() {
    }

    public FrequenciaModel(int presenca,int id_jogador, int id_partida) {
        this.presenca = presenca;
        this.id_jogador = id_jogador;
        this.id_partida = id_partida;
    }

    public int getId_jogador() {
        return id_jogador;
    }

    public void setId_jogador(int id_jogador) {
        this.id_jogador = id_jogador;
    }

    public int getId_partida() {
        return id_partida;
    }

    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }

    public int getPresenca() {
        return presenca;
    }

    public void setPresenca(int presenca) {
        this.presenca = presenca;
    }

    @Override
    public String toString() {
        return "FrequenciaModel{" + "presenca=" + this.getPresenca();
    }
    
    
    
    
}
