
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.EquipamentoDao;
import br.com.laa.cadastrojsfjpa.dao.FabricanteDao;
import br.com.laa.cadastrojsfjpa.dao.LocalDao;
import br.com.laa.cadastrojsfjpa.dao.ModeloDao;
import br.com.laa.cadastrojsfjpa.dao.TipoEquipamentoDao;
import br.com.laa.cadastrojsfjpa.modelo.Equipamento;
import br.com.laa.cadastrojsfjpa.modelo.Fabricante;
import br.com.laa.cadastrojsfjpa.modelo.Local;
import br.com.laa.cadastrojsfjpa.modelo.Modelo;
import br.com.laa.cadastrojsfjpa.modelo.Perfil;
import br.com.laa.cadastrojsfjpa.modelo.TipoEquipamento;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value = "equipamentoMB")
@SessionScoped
public class EquipamentoMB extends AppMB implements Serializable{
     private Equipamento equipamento = new Equipamento();

    private List<Equipamento> listaEquipamento;
    private List<Fabricante> listaFabricante;
    private List<Modelo> listaModelo;
    private List<Local> listaLocal;
    private List<TipoEquipamento> listaTipoEquipamento;
     
     private Perfil[] perfil;
      
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

    public Perfil[] getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil[] perfil) {
        this.perfil = perfil;
    }

    public List<Modelo> getListaModelo() {
        ModeloDao dao = new ModeloDao();
        return dao.buscarTodos();
    }

    public void setListaModelo(List<Modelo> listaModelo) {
        this.listaModelo = listaModelo;
    }

    public List<Local> getListaLocal() {
      LocalDao dao = new LocalDao();
        return dao.buscarTodos();
    }

    public void setListaLocal(List<Local> listaLocal) {
        this.listaLocal = listaLocal;
    }

    public List<TipoEquipamento> getListaTipoEquipamento() {
        TipoEquipamentoDao dao = new TipoEquipamentoDao();
        return dao.buscarTodos();
    }

    public void setListaTipoEquipamento(List<TipoEquipamento> listaTipoEquipamento) {
        this.listaTipoEquipamento = listaTipoEquipamento;
    }



    
}
