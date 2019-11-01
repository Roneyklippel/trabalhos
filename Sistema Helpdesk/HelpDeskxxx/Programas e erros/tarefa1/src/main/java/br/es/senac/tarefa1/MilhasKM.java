
package br.es.senac.tarefa1;


public class MilhasKM {
    public static void main(String[] args) {
        
    double milhas;
      //Testando conversão de milhas para km.
        for ( milhas = 1; milhas < 1; milhas++) {

            double testeMilhasParaKm = milhasParaKm(milhas);
            System.out.println(milhas);
            if (testeMilhasParaKm * 1.609 == milhas) {
                System.out.println("testeMilhasParaKm Ok");
            } else {
                System.out.println("testeMilhasParaKm Falhou !!" + "" +testeMilhasParaKm * 1.609344);
            }
        }
    }
    //funcao
         public static double milhasParaKm(double milhas) {
        return milhas / 1.609;
    }
}
