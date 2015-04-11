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
public class OrderTest {
    
    public OrderTest() {
    }
 
    /**
     * Test of class variables
     */
  
    @Test
    public void testVariabile() {
        System.out.println("Variabile");
        Order o=new Order("1");
        assertEquals(o.userId,"1");
        assertNull(o.tmp);
    }
    
}
