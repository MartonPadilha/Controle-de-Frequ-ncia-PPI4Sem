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
public class PartidaModel {
    private int id;
    private String equipe1, equipe2, data, hora, local;

    public PartidaModel() {
    }

    public PartidaModel(int id, String equipe1, String equipe2, String data, String hora, String local) {
        this.id = id;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.data = data;
        this.hora = hora;
        this.local = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(String equipe1) {
        this.equipe1 = equipe1;
    }

    public String getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(String equipe2) {
        this.equipe2 = equipe2;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "PartidaModel{" + "id=" + this.getId() + ", equipe1=" + this.getEquipe1() + ", equipe2=" + this.getEquipe2() + ", data=" + this.getData() + ", hora=" + this.getHora() + ", local=" + this.getLocal() + '}';
    }
    
    
}
