
package br.es.senac.tarefa1;


public class TrianguloEquilatero {
     public static void main(String[] args) {
        
    
//Testando areas do tringulo.
        for(double lado = 1; lado < 10; lado++) {

            double testeCalculoTriangulo = calculoTriangulo(lado);
            if (testeCalculoTriangulo * 4 / 1.73205080757 / lado == lado) {
                System.out.println("testeCalculoTriangulo OK");
            } else {
                System.out.println("testeCalculoTriangulo Falhou!!");
            }

        }
     }
     //funcao
         public static double calculoTriangulo(double lado) {
        return (lado * lado * 1.73205080757) / 4;

    }
}

