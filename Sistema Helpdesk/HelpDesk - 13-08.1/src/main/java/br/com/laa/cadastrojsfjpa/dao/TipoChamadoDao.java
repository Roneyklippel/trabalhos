
package br.com.laa.cadastrojsfjpa.dao;

import br.com.laa.cadastrojsfjpa.modelo.TipoChamado;
import java.util.List;


public class TipoChamadoDao extends AppDao<TipoChamado> {
    public TipoChamadoDao() {
        super(TipoChamado.class);
}
    
 
        public void salvarLista(List<TipoChamado> listaTipoChamado) {
        for (TipoChamado tipoChamado : listaTipoChamado) {
            System.out.println("Tipo Chamado" + tipoChamado.getNome());
            if (tipoChamado.getNome() == null || tipoChamado.getNome().isEmpty()) {
                System.out.println("descartou");
                continue;
            }
            if (tipoChamado.getId() != null && tipoChamado.getId() > 0) {
                System.out.println("atualizou");
                super.atualizar(tipoChamado);
            } else {
                System.out.println("inseriu");
                super.inserir(tipoChamado);
            }

        }
    }
}
