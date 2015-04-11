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
public class OPDeptTest {
    
    public OPDeptTest() {
    }

    /**
     * Test of SearchProd method, of class OPDept.
     * Testing if the method gives us the right stoc amount
     */
    @Test
    public void testSearchProd() {
        System.out.println("SearchProd");
        OPDept instance = new OPDept("Jeansi negri","2","4","1");
        instance.SearchProd();
        assertEquals("2", instance.stoc);
    }
    
    /**
     * Test of Constructor and Variables
     */
    @Test
    public void testConstructor(){
        System.out.println("Constructor");
        OPDept instance = new OPDept("Jeansi skinny","10","3","1");
        assertEquals(instance.name,"Jeansi skinny");
        assertEquals(instance.cant,"10");
        assertEquals(instance.idp,"3");
    }
    
}
