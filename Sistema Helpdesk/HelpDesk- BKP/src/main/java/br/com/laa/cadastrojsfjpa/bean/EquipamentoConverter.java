
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.EquipamentoDao;
import br.com.laa.cadastrojsfjpa.modelo.Equipamento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Equipamento.class, value = "equipamentoConverter")
public class EquipamentoConverter implements Converter {
   
    
    
    
     @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            if (value == null || value.isEmpty()) {
                System.out.println("Nulooooo");
                return null;
            } else {
                try {
                    Long id = Long.parseLong(value);
                    System.out.println("Buscar: " + id);
                    Equipamento equipamento = new EquipamentoDao().buscar(id);
                    System.out.println("Converteu Equipamento: " + equipamento.getNumeroPatrimonio());
                    return equipamento;
                } catch (Exception e) {
                    return null;
                }

            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            System.out.println("Converteu2: " + value);
            try {
                Equipamento equipamento = (Equipamento) value;
                if (equipamento != null) {
                    return String.valueOf(equipamento.getId());
                } else {
                    System.out.println("Nulooooo2");
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }

    
}
