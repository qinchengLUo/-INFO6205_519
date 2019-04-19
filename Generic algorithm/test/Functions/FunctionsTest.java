/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luoqincheng
 */
public class FunctionsTest {
    
    public FunctionsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateEnvironment method, of class Functions.
     */
    @Test
    public void testGenerateEnvironment() {
        System.out.println("generateEnvironment");
        int[][] environment = null;
        Functions instance = new Functions();
        int[][] expResult = null;
        int[][] result = instance.generateEnvironment(environment);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateFitness method, of class Functions.
     */
    @Test
    public void testCalculateFitness() {
        System.out.println("calculateFitness");
        String[] population = null;
        int[][] environment = null;
        Functions instance = new Functions();
        int expResult = 0;
        int result = instance.calculateFitness(population, environment);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of corssOver method, of class Functions.
     */
    @Test
    public void testCorssOver() {
        System.out.println("corssOver");
        String first = "";
        String second = "";
        Functions instance = new Functions();
        String expResult = "";
        String result = instance.corssOver(first, second);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mutation method, of class Functions.
     */
    @Test
    public void testMutation() {
        System.out.println("mutation");
        String input = "";
        Functions instance = new Functions();
        String expResult = "";
        String result = instance.mutation(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replacetheworst method, of class Functions.
     */
    @Test
    public void testReplacetheworst() {
        System.out.println("replacetheworst");
        String[] population = null;
        String newcross = "";
        Functions instance = new Functions();
        instance.replacetheworst(population, newcross);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFittest method, of class Functions.
     */
    @Test
    public void testGetFittest() {
        System.out.println("getFittest");
        Functions instance = new Functions();
        String expResult = "";
        String result = instance.getFittest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFittestint method, of class Functions.
     */
    @Test
    public void testGetFittestint() {
        System.out.println("getFittestint");
        Functions instance = new Functions();
        int expResult = 0;
        int result = instance.getFittestint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondFittest method, of class Functions.
     */
    @Test
    public void testGetSecondFittest() {
        System.out.println("getSecondFittest");
        Functions instance = new Functions();
        String expResult = "";
        String result = instance.getSecondFittest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondFittestint method, of class Functions.
     */
    @Test
    public void testGetSecondFittestint() {
        System.out.println("getSecondFittestint");
        Functions instance = new Functions();
        int expResult = 0;
        int result = instance.getSecondFittestint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
