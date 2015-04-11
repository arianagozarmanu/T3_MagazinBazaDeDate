/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariana
 */
public class ExistWinTest {
    
    public ExistWinTest() {
    }
    

    /**
     * Test of close method, of class ExistWin.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        ExistWin instance = new ExistWin();
        instance.close();
        assertNotNull(instance.winClosingEvent);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of constructor
     */
    @Test
    public void testConstructor() {
        System.out.println("constructor");
        ExistWin instance=new ExistWin("1","10","2","1");
        assertEquals(instance.ID,"1");
        assertEquals(instance.cant,"10");
        assertEquals(instance.idp,"2");
    }
    
}
