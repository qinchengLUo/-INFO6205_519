/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic.algorithm;

import Functions.Functions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luoqincheng
 */
public class MainFunction {

    
public static boolean end = false;
    
    public static void main(String[] args) throws InterruptedException{
    	
//      Generate Environment
        Functions fun=new Functions();
        int[][] environment= new int [50][50];
        environment=fun.generateEnvironment(environment);

//      Start threads
        List<ParallelGenerator> generators = new ArrayList<ParallelGenerator>();
        for(int i =0;i<5;i++) {
        	generators.add(new ParallelGenerator(environment,fun,i));
        }
        for(int i =0;i<5;i++) {
        	generators.get(i).start();
        }
        for(int i =0;i<5;i++) {
        	generators.get(i).join();
        }
    }
    
   
}
