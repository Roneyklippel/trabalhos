
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.TipoChamadoDao;
import br.com.laa.cadastrojsfjpa.modelo.Equipamento;
import br.com.laa.cadastrojsfjpa.modelo.TipoChamado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Equipamento.class, value = "tipoChamadoConverter")
public class TipoChamadoConverter implements Converter{
      @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            if (value == null || value.isEmpty()) {
                System.out.println("Nulooooo");
                return null;
            } else {
                try {
                    Long id = Long.parseLong(value);
                    System.out.println("Buscar: " + id);
                    TipoChamado tipoChamado = new TipoChamadoDao().buscar(id);
                    
                    return tipoChamado;
                } catch (Exception e) {
                    return null;
                }

            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            System.out.println("Converteu2: " + value);
            try {
                TipoChamado tipoChamado = (TipoChamado) value ;
                
                if (tipoChamado != null) {
                    return String.valueOf(tipoChamado.getId());
                } else {
                    System.out.println("Nulooooo2");
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }

   
}
