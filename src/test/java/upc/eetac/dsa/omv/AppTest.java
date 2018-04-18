package upc.eetac.dsa.omv;


import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.font.TrueTypeFont;

import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class AppTest {

    @Before
    public void setUp()
    {
        MathManagerImpl.getInstance();
    }

    @After
    public void tearDown()
    {
        MathManagerImpl.getInstance().setDown();
    }

    @Test
    public void realizarOperacionTest(){
        MathManagerImpl mathManager = MathManagerImpl.getInstance();

        Operacion operacion1 = new Operacion("2+2*2-2", "dniBruno");

        TestCase.assertEquals(mathManager.realizarOperacion(operacion1),true);
    }

    @Test
    public void procesarOperacionTest(){
        MathManagerImpl mathManager = MathManagerImpl.getInstance();
        boolean num;
        int taminicial = mathManager.colaOperaciones.size();
        mathManager.procesarOperacion();
        int tamFinal = mathManager.colaOperaciones.size();
        if(tamFinal != taminicial){
            num = true;
        }else{
            num = false;
        }

        TestCase.assertEquals(num , true);
    }

}
