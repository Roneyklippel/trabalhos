
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.modelo.Chamado;
import br.com.laa.cadastrojsfjpa.modelo.Equipamento;
import br.com.laa.cadastrojsfjpa.modelo.Status;
import br.com.laa.cadastrojsfjpa.modelo.TipoChamado;
import br.com.laa.cadastrojsfjpa.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value = "chamadoMB")
@SessionScoped
public class ChamadoMB extends AppMB implements Serializable{
 private Chamado chamado = new Chamado();
    
    private List<Chamado> listaChamadosAberto;
    
    private List<Chamado> listaChamadosFechado;
    
    private List<Usuario> listaUsuarios;
    
    private List<Equipamento> listaEquipamentos;
    
    private List<TipoChamado> listaTipoChamados;
    
    private Status [] status;

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public List<Chamado> getListaChamadosAberto() {
        return listaChamadosAberto;
    }

    public void setListaChamadosAberto(List<Chamado> listaChamadosAberto) {
        this.listaChamadosAberto = listaChamadosAberto;
    }

    public List<Chamado> getListaChamadosFechado() {
        return listaChamadosFechado;
    }

    public void setListaChamadosFechado(List<Chamado> listaChamadosFechado) {
        this.listaChamadosFechado = listaChamadosFechado;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Equipamento> getListaEquipamentos() {
        return listaEquipamentos;
    }

    public void setListaEquipamentos(List<Equipamento> listaEquipamentos) {
        this.listaEquipamentos = listaEquipamentos;
    }

    public List<TipoChamado> getListaTipoChamados() {
        return listaTipoChamados;
    }

    public void setListaTipoChamados(List<TipoChamado> listaTipoChamados) {
        this.listaTipoChamados = listaTipoChamados;
    }

    public Status[] getStatus() {
        return status;
    }

    public void setStatus(Status[] status) {
        this.status = status;
    }
    
    
}