
package br.es.senac.programa;


public class Senac {
    public static void main(String[] args) {
        String retorno = concatenaDuasStrings("Senac" + " ","Turma 182");
        System.out.println(retorno);
        
        String testeRetorno = concatenaDuasStrings("Turma","182");
        
        if(testeRetorno.equals("Turma182"))
            System.out.println("SUCESSO !!!");
        else
            System.err.println("FALHOU");
        
        int resultado = soma3Numeros(3, 5, 10);
        System.out.println(resultado);
        if(resultado == 18)
            System.err.println("CORRETO!!");
        else 
            System.err.println("INCORRETO");
    }
        public static String concatenaDuasStrings(String str1,String str2){
            return str1 + str2;
        }
        
        public static int soma3Numeros(int v1,int v2,int v3){
            return v1 + v2 + v3;
        }
}
