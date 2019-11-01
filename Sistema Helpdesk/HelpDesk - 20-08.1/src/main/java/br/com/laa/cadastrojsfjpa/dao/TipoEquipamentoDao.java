
package br.com.laa.cadastrojsfjpa.dao;

import br.com.laa.cadastrojsfjpa.modelo.TipoChamado;
import br.com.laa.cadastrojsfjpa.modelo.TipoEquipamento;
import java.util.List;


public class TipoEquipamentoDao extends AppDao<TipoEquipamento> {
    
     public TipoEquipamentoDao() {
        super(TipoEquipamento.class);
    }
        public void salvarLista(List<TipoEquipamento> listaTipoEqauipamento) {
        for (TipoEquipamento tipoEquipamento : listaTipoEqauipamento) {
            System.out.println("Tipo Equipamento" + tipoEquipamento.getNome());
            if (tipoEquipamento.getNome() == null || tipoEquipamento.getNome().isEmpty()) {
                System.out.println("descartou");
                continue;
            }
            if (tipoEquipamento.getId() != null && tipoEquipamento.getId() > 0) {
                System.out.println("atualizou");
                super.atualizar(tipoEquipamento);
            } else {
                System.out.println("inseriu");
                super.inserir(tipoEquipamento);
            }

        }
    }
}
