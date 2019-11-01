package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.FabricanteDao;
import br.com.laa.cadastrojsfjpa.modelo.Fabricante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "fabricanteMB")
@SessionScoped
/*extends AppMB*/
public class FabricanteMB extends AppMB implements Serializable {

     private  Fabricante fabricante = new Fabricante();

    private List<Fabricante> listaFabricante;
    
    

    private Boolean addNovo;

    public FabricanteMB() {
        this.addNovo = false;
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

    public String excluir(Fabricante fabricante) {
        FabricanteDao dao = new FabricanteDao();
        dao.excluir(fabricante);
        listaFabricante.remove(fabricante);
        return null;
    }

    public String salvar() {
        FabricanteDao dao = new FabricanteDao();
        dao.salvarLista(this.listaFabricante);
        return null;
    }

    public String novo() {
        addNovo = true;
        return null;

    }

}
