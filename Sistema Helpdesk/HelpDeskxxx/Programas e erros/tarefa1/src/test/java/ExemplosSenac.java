/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sala302b
 */
public class ExemplosSenac {
  
    @Test   
  
    public void comparaDuasStrings(){
        
        
        String str2 = "TESTE";
        //Fazer o codigo de remover vogais;
        
       // str2 = str2.replace("e", "");
        
        assertEquals("Falhou - As Strings não são iguais","TESTE",str2);
    }
    
    @Test
    public void testeNaoNulo(){
   // Object object = new Object();
    //    assertNotNull("O objeto não pode ser nulo",object);
        
        Object objeto = null;
         assertNull("O objeto tem que ser nulo",objeto);
    }
      @Test
public void testaFalso(){
boolean retorno = true;
retorno = false;
          assertFalse("Tem que ser Falso", retorno);
    
}
  @Test
  public void testeVerdadeiro(){
      boolean retorno; 
      retorno = true;
      assertTrue("O resultado tem que ser Verdadeiro",retorno);
  }
  @Test
  public void testeObjetoIguail(){
  Integer numero = Integer.valueOf(768);
  //Integer numero2 = Integer.valueOf(768);
  
  assertSame("Os objetos não são os mesmos",numero,numero);
  }
  
   @Test
  public void testeObjetoDiferente(){
  
  
  assertNotSame("Os objetos são iguais",new Object(),new Object());
  }
}
