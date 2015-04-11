/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariana
 */
public class JavaConnectTest {
    
    public JavaConnectTest() {
    }

    /**
     * Test of ConnectDB method, of class JavaConnect.
     */
    @Test
    public void testConnectDB() {
        System.out.println("ConnectDB");
        Connection result = JavaConnect.ConnectDB();
        assertNotNull(result);
    }
    
}
