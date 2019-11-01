
package br.es.senac.tarefa1;


public class RemoveVogais {
    public static void main(String[] args) {

        //Testando removedor de vogais.
        String testeFuncaoRemoverVogais = removedorDeVogais("A vida pode ser uma maravilha");
         System.out.println(testeFuncaoRemoverVogais);
        if (testeFuncaoRemoverVogais.equals(" vd pd sr m mrvlh")) {
            System.out.println("testeFuncaoRemoverVogais Ok");
        } else {
            System.out.println("testeFuncaoRemoverVogais Falhou");
        }
}

    //funcao
    public static String removedorDeVogais(String a) {
        String nova = a.toLowerCase().replace("a", "").replace("e", "").replace("i", "").replace("o", "").replace("u", "");
        return nova;
        
    }
    
  
}
