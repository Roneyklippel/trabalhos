
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.EquipamentoDao;
import br.com.laa.cadastrojsfjpa.dao.FabricanteDao;
import br.com.laa.cadastrojsfjpa.modelo.Equipamento;
import br.com.laa.cadastrojsfjpa.modelo.Fabricante;
import br.com.laa.cadastrojsfjpa.modelo.Perfil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value = "equipamentoMB")
@SessionScoped
public class EquipamentoMB extends AppMB implements Serializable{
     private Equipamento equipamento = new Equipamento();

    private List<Equipamento> listaEquipamento;
    private List<Fabricante> listaFabricante;
    
   
      public EquipamentoMB() {
        
    }
 
    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public List<Equipamento> getListaEquipamento() {
        EquipamentoDao dao = new EquipamentoDao();
        return dao.buscarTodos();
        //return new ArrayList<Equipamento>();
                
    }

    public void setListaEquipamento(List<Equipamento> listaEquipamento) {
        this.listaEquipamento = listaEquipamento;
    }

  public String gravar(){
        EquipamentoDao dao = new EquipamentoDao();
        if(equipamento.getId() !=null && equipamento.getId()>0){
            dao.atualizar(equipamento);
            addMessageInfo("Equipamento atualizada com sucesso!!");
            
        }else{
            dao.inserir(equipamento);
            addMessageInfo("Equipamento inserida com sucesso!!");
        }
        return "listar?faces-redirect=true";
    }
    public String editar(Equipamento equipamento){
        this.equipamento = equipamento;
        return "editar?faces-redirect=true";
    }
    public String excluir(Equipamento equipamento){
        EquipamentoDao dao = new EquipamentoDao();
        dao.excluir(equipamento);
         addMessageInfo("Equipamento excluída com sucesso!!");
        return null;
    }
    public String novoEquipamento(){
        this.equipamento = new Equipamento();
        return "editar?faces-redirect=true";
    }

    public List<Fabricante> getListaFabricante() {
       FabricanteDao dao = new FabricanteDao();
        return dao.buscarTodos();
    }

    public void setListaFabricante(List<Fabricante> listaFabricante) {
        this.listaFabricante = listaFabricante;
    }

    
}
