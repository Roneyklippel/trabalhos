
package br.com.laa.cadastrojsfjpa.bean;

import br.com.laa.cadastrojsfjpa.dao.FabricanteDao;
import br.com.laa.cadastrojsfjpa.modelo.Fabricante;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


public class FabricanteConverter {
     @FacesConverter(forClass = Fabricante.class, value = "fabricanteConverter")
    public class LocalConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            if (value == null || value.isEmpty()) {
                System.out.println("Nulooooo");
                return null;
            } else {
                try {
                    Long id = Long.parseLong(value);
                    System.out.println("Buscar: " + id);
                    Fabricante fabricante = new FabricanteDao().buscar(id);
                    System.out.println("Converteu: " + fabricante.getSigla());
                    return fabricante;
                } catch (Exception e) {
                    return null;
                }

            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            System.out.println("Converteu2: " + value);
            try {
                Fabricante fabricante = (Fabricante) value;
                if (fabricante != null) {
                    return String.valueOf(fabricante.getCodigo());
                } else {
                    System.out.println("Nulooooo2");
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }

    }
}

