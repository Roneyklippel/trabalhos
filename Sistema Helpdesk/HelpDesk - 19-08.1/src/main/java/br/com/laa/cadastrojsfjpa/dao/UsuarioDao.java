
package br.com.laa.cadastrojsfjpa.dao;

import br.com.laa.cadastrojsfjpa.modelo.Usuario;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@ApplicationScoped
public class UsuarioDao extends AppDao<Usuario>{

    public UsuarioDao(){
      super(Usuario.class);
    }
    
    
    
public Usuario autenticar(String login, String senha) {
        try {
                    em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
            Query q = em.createQuery("Select u from Usuario u where u.cpf like :cpf and u.senha like :senha");
            System.out.println("vai logar: " + login + " - " + senha);
            q.setParameter("cpf", login);
            q.setParameter("senha", senha);
            Usuario u = (Usuario) q.getSingleResult();
        em.getTransaction().commit(); 
        em.close();
        return u;
            
        } catch (NoResultException e) {
            System.out.println("Usuário não autenticado");
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
