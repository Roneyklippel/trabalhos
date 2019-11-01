
package br.com.laa.cadastrojsfjpa.bean;


import br.com.laa.cadastrojsfjpa.dao.LocalDao;

import br.com.laa.cadastrojsfjpa.modelo.Local;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Local.class, value = "localInstalacaoConverter")
public class LocalInstalacaoConverter implements Converter{
    
    @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            if (value == null || value.isEmpty()) {
                System.out.println("Nulooooo");
                return null;
            } else {
                try {
                    Long id = Long.parseLong(value);
                    System.out.println("Buscar: " + id);
                    Local Local = new LocalDao().buscar(id);
                    System.out.println("Converteu: " + Local.getNome());
                    return Local;
                } catch (Exception e) {
                    return null;
                }

            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            System.out.println("Converteu2: " + value);
            try {
                Local local = (Local) value;
                if (local != null) {
                    return String.valueOf(local.getId());
                } else {
                    System.out.println("Nulooooo2");
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }
}
