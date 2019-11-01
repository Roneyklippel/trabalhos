
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.TipoEquipamentoDao;
import br.com.laa.cadastrojsfjpa.modelo.TipoEquipamento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = TipoEquipamento.class, value = "tipoEquipamentoConverter")
public class TipoEquipamentoConverter implements Converter{

    @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            if (value == null || value.isEmpty()) {
                System.out.println("Nulooooo");
                return null;
            } else {
                try {
                    Long id = Long.parseLong(value);
                    System.out.println("Buscar: " + id);
                    TipoEquipamento tipoEquipamento = new TipoEquipamentoDao().buscar(id);
                    System.out.println("Converteu: " + tipoEquipamento.getNome());
                    return tipoEquipamento;
                } catch (Exception e) {
                    return null;
                }

            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            System.out.println("Converteu2: " + value);
            try {
                TipoEquipamento tipoEquipamento = (TipoEquipamento) value;
                
                if (tipoEquipamento != null) {
                    return String.valueOf(tipoEquipamento.getId());
                } else {
                    System.out.println("Nulooooo2");
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }

    
}
