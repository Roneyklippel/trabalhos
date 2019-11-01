
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.LocalDao;
import br.com.laa.cadastrojsfjpa.modelo.Local;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "localMB")
@SessionScoped

public class LocalMB extends AppMB implements Serializable{

    //Objeto local que será preenchido na tela
    private Local local;
    
    private List<Local> listaLocal;
  
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
        
    //construtor do Manegedbean
    public LocalMB() {
        //estanciando o objeto local
        local = new Local();
    }
    
    public String gravar(){
        LocalDao dao = new LocalDao();
        if(local.getId()!=null && local.getId()>0){
            dao.atualizar(local);
            addMessageInfo("Local atualizado com sucesso!!");
            
        }else{
            dao.inserir(local);
            addMessageInfo("Local inserido com sucesso!!");
        }
        return "listar?faces-redirect=true";
    }
    public String editar(Local local){
        this.local = local;
        return "editar?faces-redirect=true";
        
    }
     public String excluir(Local local){
        LocalDao dao = new LocalDao();
        dao.excluir(local);
         addMessageInfo("Local excluído com sucesso!!");
        return null;
    }
    public String novoLocal(){
        this.local = new Local();
        return "editar?faces-redirect=true";
    }

    public List<Local> getListaLocal() {
        LocalDao dao = new LocalDao();
        return dao.buscarTodos();        
    }

    public void setListaLocal(List<Local> listaLocal) {
        this.listaLocal = listaLocal;
    }
    
    
}
