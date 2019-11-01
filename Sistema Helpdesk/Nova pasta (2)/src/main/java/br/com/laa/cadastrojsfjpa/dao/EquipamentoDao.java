
package br.com.laa.cadastrojsfjpa.dao;

import br.com.laa.cadastrojsfjpa.modelo.Equipamento;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class EquipamentoDao extends AppDao<Equipamento>{
    public EquipamentoDao(){
      super(Equipamento.class);
    }
    
    
  
}
