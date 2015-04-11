/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;

/**
 *
 * @author Ariana
 */
public class CustomerTest {
    
    public CustomerTest() {
    }


    /**
     * Test of CurrentDate method, of class Customer.
     */
    @Test
    public void testCurrentDate() {
        System.out.println("CurrentDate");
        Customer instance = new Customer();
        Calendar cal=new GregorianCalendar();
        int month=cal.get(Calendar.MONTH);
        month++;
        int year=cal.get(Calendar.YEAR);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        String expResult =""+day+"/"+month+"/"+year;
        System.out.println(expResult);
        String result = instance.CurrentDate();
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.  
    }

    /**
     * Test the User which is logged in
     */
    @Test
    public void testUser() {
        System.out.println("UserTest");
        Customer instance = new Customer("1");
        assertEquals(instance.userId,"1");
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test the Connection with DataBase
     */
    @Test
    public void connectTest(){
        System.out.println("Connection");
        Customer instance = new Customer();
        assertNotNull(instance.conn);
    }
    
    /**
     * Test the variables of the class
     */
    @Test
    public void variablesTest(){
        System.out.println("Variabile");
        Customer instance = new Customer("1");
        assertNull(instance.stoc);
        assertNull(instance.price);
        assertNull(instance.name);
    }  
    
}
