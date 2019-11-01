
package br.com.laa.cadastrojsfjpa.bean;

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
}
