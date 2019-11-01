
package br.com.laa.cadastrojsfjpa.dao;


import br.com.laa.cadastrojsfjpa.modelo.Modelo;
import java.util.List;


public class ModeloDao extends AppDao<Modelo> {
     public ModeloDao() {
        super(Modelo.class);
    }

   

    public void inserir(List<Modelo> listaModelo) {
       
            }

    public void salvarLista(List<Modelo> listaModelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
}
