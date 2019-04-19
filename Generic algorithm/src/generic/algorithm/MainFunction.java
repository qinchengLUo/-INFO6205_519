/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic.algorithm;

import Entities.Population;
import Functions.Functions;
import java.util.Random;

/**
 *
 * @author luoqincheng
 */
public class MainFunction {

    
    public static void main(String[] args){
//      Generate Environment
        Functions fun=new Functions();
        int[][] environment= new int [50][50];
        environment=fun.generateEnvironment(environment);
        
//      Generate the first generation of population randomly
        Population po=new Population(10);
        po.initializePopulation();
        
//      CalculateFitness for first generation
        int fitness=fun.calculateFitness(po.population,environment);
        System.out.println("Fitness of first Generation is :"+fitness);
        

//      Evolution until the fitness of that generation is less than 3000
        String fittest;
        String secfittest;
        while(fitness>2600&&po.generation<200){
            ++po.generation;
            
//      do select(get the most fitness and second fitness genens)
        fittest=fun.getFittest();
        secfittest=fun.getSecondFittest();
        
//      do crossover and replace the worst gene with the new gene
        String crossover = fun.corssOver(fittest, secfittest);
//      mutate
        Random rn=new Random();
        if(Math.abs(rn.nextInt()%10)<3){
            fun.mutation(crossover);
        }
        fun.replacetheworst(po.population, crossover);
  

//      recalculate the fitness of the new generation and refresh the best fittest second fittest and worst fittest
        fitness=fun.calculateFitness(po.population, environment);
        
        System.out.println("Genaration:"+ po.generation+"  fitness:"+fitness);
        }
        
        
        if(po.generation==200){
            System.out.println("We can't find the suitable solution");
        }else{
            System.out.println("Result:"+fun.getFittest());
        }
    }
    
   
}
