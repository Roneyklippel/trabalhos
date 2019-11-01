
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.modelo.Perfil;
import br.com.laa.cadastrojsfjpa.modelo.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AppMB {
    public void addMessageInfo(String message){
         FacesContext facesContext = FacesContext.getCurrentInstance() ; 
            facesContext.addMessage("Sucesso", 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            message, "Sucesso")
                    
                    );
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
     public void addMessageErro(String message){
         FacesContext facesContext = FacesContext.getCurrentInstance() ; 
            facesContext.addMessage("Erro", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            message, "Erro")
                    
                    );
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
     
       public void addMessageWarnning(String message){
         FacesContext facesContext = FacesContext.getCurrentInstance() ; 
            facesContext.addMessage("Aviso", 
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            message, "Aviso")
                    
                    );
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
       public Usuario getUsuarioLogado(){
       FacesContext fc = FacesContext.getCurrentInstance();
        //recuperar valor de sessão
        return (Usuario) fc.getExternalContext().getSessionMap().get("usuarioLogado");
       }
         public Boolean isTecnico(){
           if(getUsuarioLogado()==null 
              || getUsuarioLogado().getPerfil()==null)
               return false;
           
           if(getUsuarioLogado().getPerfil().equals(Perfil.Tecn) 
              || isAdministrador() ){
               return true;
           }
           return false;
       }
       
        public Boolean isAdministrador(){
           if(getUsuarioLogado()==null 
              || getUsuarioLogado().getPerfil()==null)
               return false;
           
           if(getUsuarioLogado().getPerfil().equals(Perfil.Admi) ){
               return true;
           }
           return false;
       }
        
        public Boolean isUsuario(){
           if(getUsuarioLogado()==null 
              || getUsuarioLogado().getPerfil()==null)
               return false;
           
           if(getUsuarioLogado().getPerfil().equals(Perfil.User) ){
               return true;
           }
           return false;
       }
}
