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
 * @author Ariana
 */
public class WarehouseTest {
    
    public WarehouseTest() {
    }
    
   

    /**
     * Test connection
     */
    @Test
    public void testConnection() {
        System.out.println("Conexiune");
        Warehouse instance = new Warehouse();
        assertNotNull(instance.conn);
        
    }

    /**
     * Test class variables
     */
    @Test
    public void testVariabile() {
        System.out.println("Variabile");
        Warehouse w=new Warehouse();
        assertNotNull(w.name);
        assertNotNull(w.rs);
        assertNotNull(w.pst);
    }
    
}
