
package br.com.laa.cadastrojsfjpa.bean;


import br.com.laa.cadastrojsfjpa.dao.LocalDao;
import br.com.laa.cadastrojsfjpa.dao.UsuarioDao;
import br.com.laa.cadastrojsfjpa.modelo.Local;
import br.com.laa.cadastrojsfjpa.modelo.Perfil;
import br.com.laa.cadastrojsfjpa.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value = "usuarioMB")
@SessionScoped
public class UsuarioMB extends AppMB implements Serializable {

    private Usuario usuario = new Usuario();

    private List<Usuario> listaUsuario;
    
    private List<Local> listaLocal;
    
    private Perfil[] perfil;

       public Perfil[] getPerfil() {
        return Perfil.values();
    }

    public void setPerfis(Perfil[] perfil) {
        this.perfil = perfil;
    }
    
    public List<Usuario> getListaUsuario() {
        UsuarioDao dao = new UsuarioDao();
        return dao.buscarTodos();
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public UsuarioMB() {

    }

    public Usuario getUsuario() {
        
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

      public List<Local> getListaLocal() {
        LocalDao localDao = new LocalDao();
        return localDao.buscarTodos();
    }

    public void setListaLocal(List<Local> listaLocal) {
        this.listaLocal = listaLocal;
    }

    public String gravar(){
        UsuarioDao dao = new UsuarioDao();
        if(usuario.getId()!=null && usuario.getId()>0){
            dao.atualizar(usuario);
            addMessageInfo("Usuario atualizada com sucesso!!");
            
        }else{
            dao.inserir(usuario);
            addMessageInfo("Usuario inserida com sucesso!!");
        }
        return "listar?faces-redirect=true";
    }
    public String editar(Usuario usuario){
        this.usuario = usuario;
        return "editar?faces-redirect=true";
    }
    public String excluir(Usuario usuario){
        UsuarioDao dao = new UsuarioDao();
        dao.excluir(usuario);
         addMessageInfo("Usuario excluída com sucesso!!");
        return null;
    }
    public String novoUsuario(){
        this.usuario = new Usuario();
        return "editar?faces-redirect=true";
    }

  
 

   
    
}
