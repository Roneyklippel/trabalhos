
package br.com.laa.cadastrojsfjpa.dao;

import br.com.laa.cadastrojsfjpa.modelo.Chamado;
import br.com.laa.cadastrojsfjpa.modelo.Status;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

@ApplicationScoped
public class ChamadoDao extends AppDao<Chamado>{
     public ChamadoDao(){
      super(Chamado.class);
    }

/**
     * Retonra a lista de chamados abertos e em atendimento
     * @return 
     */
    public List<Chamado> getListaChamadosAbertos(){
        List<Chamado> listaRetorno=null;
        String hql = "SELECT c FROM Chamado c where c.status = :aberto or c.status= :atendimento";
        
        this.em = JPAUtil.getEntityManager(); 
        Query query = em.createQuery(hql);
        query.setParameter("aberto", Status.Aber);
        query.setParameter("atendimento", Status.Anda);
        
        try {
             //em.getTransaction().begin();
             listaRetorno = query.getResultList() ;
              //em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }finally{
            em.close(); 
        }
        return listaRetorno;
    }
    
    /**
     * Retorna lista de chamados Fechados
     * @return 
     */
    public List<Chamado> getListaChamadosEncerrados(){
        List<Chamado> listaRetorno=null;
        String hql = "SELECT c FROM Chamado c where c.status = :fechado";
        
        this.em = JPAUtil.getEntityManager(); 
        Query query = em.createQuery(hql);
        query.setParameter("fechado", Status.Fech);
        
        try {
             //em.getTransaction().begin();
             listaRetorno = query.getResultList() ;
              //em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }finally{
            em.close(); 
        }
        return listaRetorno;
    }

    public void update(Chamado chamado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}