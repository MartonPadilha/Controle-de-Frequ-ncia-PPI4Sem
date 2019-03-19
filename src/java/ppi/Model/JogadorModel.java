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
public class JogadorModel {
    private int id;
    private String nome;
    private int status;

    public JogadorModel() {
    }

    public JogadorModel(int id, String nome, int status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JogadorModel{" + "id=" + this.getId() + ", nome=" + this.getNome() + ", status=" + this.getStatus() + '}';
    }
    
    
    
}
