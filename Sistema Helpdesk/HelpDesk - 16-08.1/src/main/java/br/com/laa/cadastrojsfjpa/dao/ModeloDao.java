
package br.com.laa.cadastrojsfjpa.dao;


import br.com.laa.cadastrojsfjpa.modelo.Modelo;
import java.util.List;


public class ModeloDao extends AppDao<Modelo> {
     public ModeloDao() {
        super(Modelo.class);
    }

   

 public void salvarLista(List<Modelo> listaModelo) {
        for (Modelo modelo : listaModelo) {
            System.out.println("Modelo" + modelo.getNome());
            if (modelo.getNome() == null || modelo.getNome().isEmpty()) {
                System.out.println("descartou");
                continue;
            }
            if (modelo.getId() != null && modelo.getId() > 0) {
                System.out.println("atualizou");
                super.atualizar(modelo);
            } else {
                System.out.println("inseriu");
                super.inserir(modelo);
            }

        }
    }

     
}
