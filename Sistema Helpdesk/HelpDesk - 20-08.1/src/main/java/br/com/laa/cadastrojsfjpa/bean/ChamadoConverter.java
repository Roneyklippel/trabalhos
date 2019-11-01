
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.ChamadoDao;
import br.com.laa.cadastrojsfjpa.modelo.Chamado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Chamado.class , value = "chamadoConverter")
public class ChamadoConverter implements Converter{
     
    @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            if (value == null || value.isEmpty()) {
                System.out.println("Nulooooo");
                return null;
            } else {
                try {
                    Long id = Long.parseLong(value);
                    System.out.println("Buscar: " + id);
                    Chamado chamado = new ChamadoDao().buscar(id);
                    System.out.println("Converteu: " + chamado.getId());
                    return chamado;
                } catch (Exception e) {
                    return null;
                }

            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            System.out.println("Converteu2: " + value);
            try {
                Chamado chamado = (Chamado) value;
                if (chamado != null) {
                    return String.valueOf(chamado.getId());
                } else {
                    System.out.println("Nulooooo2");
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }

   
    
}
