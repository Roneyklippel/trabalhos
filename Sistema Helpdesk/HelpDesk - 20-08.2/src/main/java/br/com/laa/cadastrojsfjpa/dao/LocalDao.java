
package br.com.laa.cadastrojsfjpa.dao;

import br.com.laa.cadastrojsfjpa.modelo.Local;
import br.com.laa.cadastrojsfjpa.modelo.Usuario;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LocalDao extends AppDao<Local>{

     public LocalDao(){
      super(Local.class);
    }
}
