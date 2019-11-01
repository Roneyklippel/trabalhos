
import static br.es.senac.tarefa1.MilhasKM.milhasParaKm;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MilhasKMTest {

    
    @Test
  public void testeVerdadeiro(){
     double milhas =1; 
     double testeMilhasParaKm = milhasParaKm(milhas); 
      assertTrue("O resultado tem que ser Verdadeiro",milhas == 1.609);
  }

    
}
//double milhas = 1.609;
       // double testeMilhasParaKm = milhasParaKm(milhas);