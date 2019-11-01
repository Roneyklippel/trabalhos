
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.ChamadoDao;
import br.com.laa.cadastrojsfjpa.dao.EquipamentoDao;
import br.com.laa.cadastrojsfjpa.dao.TipoChamadoDao;
import br.com.laa.cadastrojsfjpa.modelo.Chamado;
import br.com.laa.cadastrojsfjpa.modelo.Equipamento;
import br.com.laa.cadastrojsfjpa.modelo.Status;
import br.com.laa.cadastrojsfjpa.modelo.TipoChamado;
import java.io.Serializable;
import java.util.Date;
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
    private List<Chamado> listaChamadosAberto;
    private List<Chamado> listaChamadosFechado;
   
    
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
            try {
                //insere o usuario de abertura quando salver um novo usuairo
                chamado.setUsuarioAbertura(getUsuarioLogado());
                
                //muda o status para aberto
                chamado.setStatus(Status.Aber);
                
                //Insere a data atual como a data de abertura
                chamado.setDataAbertura(new Date());
                
                //Insere como data para atendimento a data atual mais o tempo para atendimento do chamado
                chamado.setDataAbertura(addHora(new Date(), chamado.getTipoChamado().getTempoAtendimento()));
                dao.inserir(chamado);
                addMessageInfo("Chamado inserido com sucesso!!");
                return "listar?faces-redirect=true";
            } catch (Exception e) {
                addMessageErro(e.getMessage());
                return null;
            }
        }
        return "listar?faces-redirect=true";
    }

    public String editar(Chamado chamado) {
        this.chamado = chamado;
        return "editar?faces-redirect=true";
    }

    public String novoChamado() {
        this.chamado = new Chamado();
        return "editar?faces-redirect=true";
    }

    public String atender(Chamado chamado) {
        this.chamado = chamado;
        
        //insere o técnico responsável quando o usuario clicar em atender
        this.chamado.setTecnicoResponsavel(getUsuarioLogado());
        
        //Coloca o status do chamado como em atendimento
        this.chamado.setStatus(Status.Anda);
        
        return "editar?faces-redirect=true";
    }
   
    public String encerrar(){
        //Coloca o status do chamado como fechado
        chamado.setStatus(Status.Fech);
        
        //chama o gravar
        gravar();
        
       //envia email
        //enviarEmail(chamado);
        
        return "editar";
    }
    
    
     /** 
     * @param horasAdicionais - Horas a serem adicionas (int)
     * @param data - Data a ser modificada (Date)
     * @return - Data alterada (Date)
     */
    public Date addHora(Date data, int horasAdicionais) {
        int umaHora = 60*60*1000; //1h = 60min * 60seg * 1000miliseg
        data.setTime(data.getTime() + horasAdicionais*umaHora);
        return data;
    }

               //inserir usuario de abertura=usuario logado
               
               //inserir data abertura = data atual
               
               //inserir status chamado = aberto
               
               
               //inserir data limite atendimento = data atual + tempo de atendimento do tipo de chamado


    public String excluir(Chamado chamado){
        ChamadoDao dao = new ChamadoDao();
        dao.excluir(chamado);
         addMessageInfo("Chamado excluído com sucesso!!");
        return null;
    }

  
       public boolean proprietario (Chamado chamado){
       
      if (getUsuarioLogado().equals(chamado.getUsuarioAbertura())){
          
          return true;
      }
      
      return false;
               
   }

    public List<Chamado> getListaChamadosAberto() {
       ChamadoDao dao = new ChamadoDao();
        return dao.getListaChamadosAbertos();
    }

    public void setListaChamadosAberto(List<Chamado> listaChamadosAberto) {
        this.listaChamadosAberto = listaChamadosAberto;
    }

    public List<Chamado> getListaChamadosFechado() {
       ChamadoDao dao = new ChamadoDao();
        return dao.getListaChamadosEncerrados();
    }

    public void setListaChamadosFechado(List<Chamado> listaChamadosFechado) {
        this.listaChamadosFechado = listaChamadosFechado;
    }
    
    
}
