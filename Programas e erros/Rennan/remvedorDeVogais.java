package br.com.rennan.projeto1;

public class remvedorDeVogais {

    public static void main(String[] args) {

        //Testando se a função removedorDeVogais realmente está correta.
        String testeFuncaoRemovedorDeVogais = removedorDeVogais("Eu sou o Jonathan da nova geracao");

        if (!testeFuncaoRemovedorDeVogais.equals("a,e,i,o,u")) {
            System.out.println("testeFuncaoRemovedorDeVogais Ok");
        } else {
            System.out.println("testeFuncaoRemovedorDeVogais Falhou");
        }
        
        
        //Testando se a área do triangulo está correta.
        for (double lado = 1; lado < 10; lado++) {

            double testeCalcTriangulo = calcTriangulo(lado);
            if (testeCalcTriangulo * 4 / 1.73205080757 / lado == lado) {
                System.out.println("testeCalcTriangulo OK");
            } else {
                System.out.println("testeCalcTriangulo Falhou");
            }

        }
        
        //Testando se a transformação de gigabytesParaKilobytes realemte está correta.
        for (int i = 0; i < 10; i++) {

            double testeGigabytesParaKilobytes = gigabytesParaKilobytes(i);

            if (testeGigabytesParaKilobytes / 1048576 == i) {
                System.out.println("testeGigabytesParaKilobytes OK");
            } else {
                System.out.println("testeGigabytesParaKilobytes Falhou");
            }

        }

        
        //Testando se a transformação de milhasParaKm está correta.
        for (double mi = 1; mi < 10; mi++) {

            double testeMilhasParaKm = milhasParaKm(mi);

            if (testeMilhasParaKm * 1.609 == mi) {
                System.out.println("testeMilhasParaKm Ok");
            } else {
                System.out.println("testeMilhasParaKm Falhou" + "" +testeMilhasParaKm * 1.609344);
            }
        }

    }
    
    
    
    
    
    
       //Funções
    public static String removedorDeVogais(String a) {
        String nova = a.toLowerCase().replace("a", "").replace("e", "").replace("i", "").replace("o", "").replace("u", "");
        return nova;
    }

    public static double calcTriangulo(double lado) {
        return (lado * lado * 1.73205080757) / 4;

    }

    public static double gigabytesParaKilobytes(double a) {
        return a * 1048576;
    }

    public static double milhasParaKm(double mi) {
        return mi / 1.609;
    }

}
