package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Entities.Population;
import Functions.Functions;

/**
* @author Guanrui Wang
*/
public class FunctionsTest {

	/**
     * Test method for generateEnvironment
     */
    @Test
    public void testgenerateEnvironmentTest() {
    	Functions fun = new Functions();
    	int[][] generateEnvironment = new int[50][50];
    	int[][] testResult = fun.generateEnvironment(generateEnvironment);
    	assertEquals(50, testResult.length);
    	boolean range = true;
    	for(int i = 0;i<50;i++) {
    		for(int j = 0;j<50;j++) {
    			if(testResult[i][j]<-5||testResult[i][j]>5) {
    				range = false;
    			}
    		}
    	}
    	assertEquals(true, range);
    }
    
    /**
     * Test method for calculateFitness
     */
    @Test
    public void calculateFitnessTest() {
    	String[] population = new String[3];
    	population[0] = "0101";
    	population[1] = "0011";
    	population[2] = "1100";
    	int[][] environment = new int[3][3];
    	environment[0][0] = 1;
    	environment[0][1] = 7;
    	environment[0][2] = 9;
    	environment[1][0] = 4;
    	environment[1][1] = 2;
    	environment[1][2] = 8;
    	environment[2][0] = 6;
    	environment[2][1] = 5;
    	environment[2][2] = 3;
    	Functions fun = new Functions();
    	assertEquals(44, fun.calculateFitness(population, environment));   	
    }
    
    /**
     * Test method for mutation
     */
    @Test
    public void mutationTest() {
    	Functions fun = new Functions();
    	String gene = "1010101010";
    	String mutatedGene = fun.mutation(gene);
    	int count0 = 0;
    	int count1 = 0;
    	boolean same = false;
    	if(gene.equals(mutatedGene)) same = true;
    	for(int i =0;i<10;i++) {
    		if(gene.charAt(i)=='1') {
    			count1++;
    		}else count0++;
    	}
    	assertEquals(5, count0);
    	assertEquals(5, count1);
    	assertEquals(false, same);
    }
    
    /**
     * Test method for initializePopulation
     */
    @Test
    public void initializePopulation() {
    	Population po = new Population(10);
    	po.initializePopulation();
    	assertEquals(10, po.population.length);
    	boolean path = true;
    	int count0=0;
    	int count1=0;
    	for(int i=0;i<po.population.length;i++) {
    		for(int j=0;j<po.population[i].length();j++) {
    			if(po.population[i].charAt(j)=='1') {
    				count1++;
    			}else count0++;
    		}
    		if(count0!=49||count1!=49) {
    			path=false;
    		}
    		count0=0;
    		count1=0;
    	}
    	assertEquals(true, path);
    	
    	
    }

}
