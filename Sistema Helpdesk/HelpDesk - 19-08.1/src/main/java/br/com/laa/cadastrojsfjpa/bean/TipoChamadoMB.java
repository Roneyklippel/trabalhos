
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.TipoChamadoDao;
import br.com.laa.cadastrojsfjpa.modelo.TipoChamado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "tipoChamadoMB")
@SessionScoped
public class TipoChamadoMB extends AppMB implements Serializable{
     private TipoChamado tipoChamado = new TipoChamado();

    private List<TipoChamado> listaTipoChamado;

    private Boolean addNovo;

    public TipoChamadoMB() {
        this.addNovo = false;
    }

    public List<TipoChamado> getListaTipoChamado() {
        TipoChamadoDao dao = new TipoChamadoDao();
        if (listaTipoChamado == null) {
            listaTipoChamado = dao.buscarTodos();
        }
        if (listaTipoChamado == null) {
            listaTipoChamado = new ArrayList<>();
        }
        if (listaTipoChamado.isEmpty() || addNovo) {
            listaTipoChamado.add(new TipoChamado());
            addNovo = false;
        }
        return listaTipoChamado;
    }

    public void setListaTipoChamado(List<TipoChamado> listaChamados) {
        this.listaTipoChamado = listaChamados;
    }

    public String excluir(TipoChamado tipoChamado) {
        TipoChamadoDao dao = new TipoChamadoDao();
        dao.excluir(tipoChamado);
        listaTipoChamado.remove(tipoChamado);
        return null;
    }

    public String salvar() {
        TipoChamadoDao dao = new TipoChamadoDao();
        dao.salvarLista(this.listaTipoChamado);
        return null;
    }

    public String novo() {
        addNovo = true;
        return null;

    }

}
