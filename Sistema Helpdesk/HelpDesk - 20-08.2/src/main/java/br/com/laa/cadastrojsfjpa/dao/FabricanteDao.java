package br.com.laa.cadastrojsfjpa.dao;

import br.com.laa.cadastrojsfjpa.modelo.Fabricante;
import java.util.List;

public class FabricanteDao extends AppDao<Fabricante> {

    public FabricanteDao() {
        super(Fabricante.class);
    }


    public void salvarLista(List<Fabricante> listaFabricante) {
        for (Fabricante fabricante : listaFabricante) {
            System.out.println("Fabricante" + fabricante.getNome());
            if (fabricante.getNome() == null || fabricante.getNome().isEmpty()) {
                System.out.println("descartou");
                continue;
            }
            if (fabricante.getId() != null && fabricante.getId() > 0) {
                System.out.println("atualizou");
                super.atualizar(fabricante);
            } else {
                System.out.println("inseriu");
                super.inserir(fabricante);
            }

        }
    }

   
}
