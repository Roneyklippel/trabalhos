
import br.es.senac.tarefa1.RemoveVogais;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveVogaisTest {

    @Test
    public void comparaDuasStrings() {
        String testeFuncaoRemoverVogais = RemoveVogais.removedorDeVogais("A vida pode ser uma maravilha");
        System.out.println(testeFuncaoRemoverVogais);
        //Fazer o codigo de remover vogais;
        // str2 = str2.replace("e", "");
        assertEquals("Falhou - As Strings  são iguais", " vd pd sr m mrvlh", testeFuncaoRemoverVogais);
    }
}
