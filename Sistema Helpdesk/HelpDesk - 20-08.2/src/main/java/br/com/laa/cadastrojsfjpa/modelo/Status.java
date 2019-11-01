
package br.com.laa.cadastrojsfjpa.modelo;


public enum Status {
    Aber("Aberto"),
    Pend("Pendente"),
    Anda("Em Andamento"),
    Fech("Fechado") ;
    
    private String valor;

    private Status(String valor) {
        this.valor = valor;
    }

    public String toString() {
        return valor;
    }
}
