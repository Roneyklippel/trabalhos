
package br.com.laa.cadastrojsfjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
    private static EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("helpdeskPU");
           
    public static EntityManager getEntityManager(){
        try {
            return emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao acessar o  banco de dados");
        }
    
    }
    
}
