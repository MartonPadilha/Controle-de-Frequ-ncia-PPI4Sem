/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppi.DAO;

import java.util.List;

/**
 *
 * @author Marton
 */
public interface InterfaceDAO<T> {
    public boolean inserir(T objeto);
    public List<T> buscar();
    public boolean apagar(T objeto);
    public boolean editar(T objeto);
    public T buscar(int id);
}
