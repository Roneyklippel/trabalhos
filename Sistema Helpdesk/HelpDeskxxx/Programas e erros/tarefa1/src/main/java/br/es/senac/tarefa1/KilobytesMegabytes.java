package br.es.senac.tarefa1;


public class KilobytesMegabytes {
    public static void main(String[] args) {
        
    
    //Testando converssao de kilobytes para megabytes
        for (int km = 0; km < 1; km++) {

            double testeGigabytesParaKilobytes = gigabytesParaKilobytes(km);

            if (testeGigabytesParaKilobytes / 1048576 == km) {
                System.out.println("testeGigabytesParaKilobytes OK");
            } else {
                System.out.println("testeGigabytesParaKilobytes Falhou !!");
            }

        }
    }
    //funcao
        public static double gigabytesParaKilobytes(double x) {
        return x * 1048576;
    }
}
