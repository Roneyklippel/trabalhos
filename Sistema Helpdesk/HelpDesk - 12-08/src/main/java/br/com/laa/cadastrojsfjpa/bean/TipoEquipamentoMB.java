
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.TipoEquipamentoDao;
import br.com.laa.cadastrojsfjpa.modelo.TipoEquipamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "tipoEquipamentoMB")
@SessionScoped
public class TipoEquipamentoMB extends AppMB implements Serializable{
     private TipoEquipamento tipoEquipamento = new TipoEquipamento();

    private List<TipoEquipamento> listaTipoEquipamento;

    private Boolean addNovo;

    public List<TipoEquipamento> getListaTipoEquipamento() {
       TipoEquipamentoDao dao = new TipoEquipamentoDao();
        if (listaTipoEquipamento == null) {
            listaTipoEquipamento = dao.buscarTodos();
        }
        if (listaTipoEquipamento == null) {
            listaTipoEquipamento= new ArrayList<>();
        }
        if (listaTipoEquipamento.isEmpty() || addNovo) {
            listaTipoEquipamento.add(new TipoEquipamento());
            addNovo = false;
        }
        return listaTipoEquipamento;
    }

    
    public void setListaTipoEquipamento(List<TipoEquipamento> listaEquipamentos) {
        this.listaTipoEquipamento = listaEquipamentos;
    }

    public String excluir(TipoEquipamento tipoEquipamento) {
        TipoEquipamentoDao dao = new TipoEquipamentoDao();
        dao.excluir(tipoEquipamento);
        listaTipoEquipamento.remove(tipoEquipamento);
        return null;
    }

    public String salvar() {
        TipoEquipamentoDao dao = new TipoEquipamentoDao();
        dao.salvarLista(this.listaTipoEquipamento);
        return null;
    }

    public String novo() {
        addNovo = true;
        return null;

    }
}
