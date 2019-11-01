
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.modelo.Equipamento;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value = "equipamentoMB")
@SessionScoped
public class EquipamentoMB extends AppMB implements Serializable{
     private Equipamento equipamento = new Equipamento();

    private List<Equipamento> listaEquipamento;
    
   
      public EquipamentoMB() {
        
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public List<Equipamento> getListaEquipamento() {
        return listaEquipamento;
    }

    public void setListaEquipamento(List<Equipamento> listaEquipamento) {
        this.listaEquipamento = listaEquipamento;
    }

 
    
}
