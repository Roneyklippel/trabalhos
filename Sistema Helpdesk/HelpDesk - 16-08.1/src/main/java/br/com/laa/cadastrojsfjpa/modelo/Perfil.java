
package br.com.laa.cadastrojsfjpa.modelo;




public enum Perfil {
     
     
     
     
    User("Usuário"),
    Tecn("Técnico"),
    Admi("Administrador");

    private String valor;

    private Perfil(String valor) {
        this.valor = valor;
    }

    public String toString() {
        return valor;
    }

  
}
