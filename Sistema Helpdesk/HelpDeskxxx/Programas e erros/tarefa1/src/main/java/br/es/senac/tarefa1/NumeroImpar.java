
package br.es.senac.tarefa1;

import javax.swing.JOptionPane;


public class NumeroImpar {
    public static void main(String[] args) {
        String saida="";
String entrada=JOptionPane.showInputDialog("Entre com um numero");

int i = Integer.parseInt(entrada);

if(i % 2 == 0)
saida+= "O numero não é impar";
else
saida+="O numero é impar";

JOptionPane.showMessageDialog(null,
"Valor "+saida,"Testa numero ",JOptionPane.INFORMATION_MESSAGE);
System.exit(0);
    }
            
}
