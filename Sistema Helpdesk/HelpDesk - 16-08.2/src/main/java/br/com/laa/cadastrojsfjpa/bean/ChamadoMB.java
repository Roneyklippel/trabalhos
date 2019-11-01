
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.ChamadoDao;
import br.com.laa.cadastrojsfjpa.dao.EquipamentoDao;
import br.com.laa.cadastrojsfjpa.dao.TipoChamadoDao;
import br.com.laa.cadastrojsfjpa.modelo.Chamado;
import br.com.laa.cadastrojsfjpa.modelo.Equipamento;
import br.com.laa.cadastrojsfjpa.modelo.TipoChamado;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "chamadoMB")
@SessionScoped
public class ChamadoMB extends AppMB implements Serializable{
    
    private Chamado chamado = new Chamado();
   
    private List<Chamado> listachamado;
    private List<TipoChamado> listaTipoChamado;
    private List<Equipamento> listaequipamento;

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public List<Chamado> getListachamado() {
         ChamadoDao dao = new ChamadoDao();
        return dao.buscarTodos();
    }

    public void setListachamado(List<Chamado> listachamado) {
        this.listachamado = listachamado;
    }

    public List<TipoChamado> getListaTipoChamado() {
         TipoChamadoDao dao = new TipoChamadoDao();
        return dao.buscarTodos();
    }

    public void setListaTipoChamado(List<TipoChamado> listaTipoChamado) {
        this.listaTipoChamado = listaTipoChamado;
    }

    public List<Equipamento> getListaequipamento() {
         EquipamentoDao dao = new EquipamentoDao();
        return dao.buscarTodos();
    }

    public void setListaequipamento(List<Equipamento> listaequipamento) {
        this.listaequipamento = listaequipamento;
    }
    public String gravar(){
        ChamadoDao dao = new ChamadoDao();
        if(chamado.getId() !=null && chamado.getId()>0){
            dao.atualizar(chamado);
            addMessageInfo("Chamado atualizado com sucesso!!");
            
        }else{
            dao.inserir(chamado);
            addMessageInfo("Chamado inserido com sucesso!!");
        }
        return "listar?faces-redirect=true";
    }
    public String editar(Chamado chamado){
        this.chamado = chamado;
        return "editar?faces-redirect=true";
    }
    public String excluir(Chamado chamado){
        ChamadoDao dao = new ChamadoDao();
        dao.excluir(chamado);
         addMessageInfo("Chamado excluído com sucesso!!");
        return null;
    }
    public String novoChamado(){
        this.chamado = new Chamado();
        return "editar?faces-redirect=true";
    }
   
    
    
    
}
