package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.FabricanteDao;
import br.com.laa.cadastrojsfjpa.dao.ModeloDao;
import br.com.laa.cadastrojsfjpa.modelo.Fabricante;
import br.com.laa.cadastrojsfjpa.modelo.Modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value = "modeloMB")
@SessionScoped
/*extends AppMB*/
public class ModeloMB extends AppMB implements Serializable {
    
    List<Modelo> listaModelo = new ArrayList<>();
    private List<Fabricante> listaFabricante;
    
    

    private Boolean addNovo = false;
      public List<Modelo> getListaModelo() {
        ModeloDao dao = new ModeloDao();
        if (listaModelo==null) {
            listaModelo = dao.buscarTodos();
        }
        if (listaModelo==null) {
            listaModelo = new ArrayList<>();
        }
        if (listaModelo.isEmpty()|| addNovo) {
            listaModelo.add(new Modelo());
            addNovo = false;
        }
        return listaModelo;
    }
public void setListaModelo(List<Modelo> listaModelo) {
        this.listaModelo = listaModelo;
    }

    public List<Fabricante> getListaFabricante() {
        FabricanteDao dao = new FabricanteDao();
        if (listaFabricante==null) {
            listaFabricante = dao.buscarTodos();
        }
        if (listaFabricante==null) {
            listaFabricante = new ArrayList<>();
        }
        if (listaFabricante.isEmpty()|| addNovo) {
            listaFabricante.add(new Fabricante());
            addNovo = false;
        }
        return listaFabricante;
    }

    public void setListaFabricante(List<Fabricante> listaFabricante) {
        this.listaFabricante = listaFabricante;
    }
    public String excluir(Modelo modelo ) {
        ModeloDao dao = new ModeloDao();
        dao.excluir (modelo);
        listaModelo.remove(modelo);
        return null;
    }

    public String salvar() {
        ModeloDao dao = new ModeloDao();
        dao.salvarLista(this.listaModelo);
        return null;
    }

    public String novo() {
        addNovo = true;
        return null;

    }
    


   
    

    
}
