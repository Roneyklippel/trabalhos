
package br.com.laa.cadastrojsfjpa.dao;

import br.com.laa.cadastrojsfjpa.modelo.Chamado;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ChamadoDao extends AppDao<Chamado>{
     public ChamadoDao(){
      super(Chamado.class);
    }
}
