package generic.algorithm;

import java.util.Random;

import Entities.Population;
import Functions.Functions;

/**
* @author Guanrui Wang
*/
public class ParallelGenerator extends Thread{
	
	int[][] environment;
	Functions fun;
	int i;
	
	public ParallelGenerator(int[][] environment , Functions fun, int i) {
		this.environment=environment; 
		this.fun=fun;
		this.i=i;
	}
	
	public void run() {
		
//		Generate the first generation of population randomly
        Population po=new Population(10);
        po.initializePopulation();
        
//      CalculateFitness for first generation
        int fitness=fun.calculateFitness(po.population,environment);
        synchronized (fun) {
        	System.out.println("Generator"+i+": Fitness of first Generation is :"+fitness);
		}
        
//      Evolution until the fitness of that generation is less than 3000
        String fittest;
        String secfittest;
       
        
        while(fitness>2600&&po.generation<200){
        	if(MainFunction.end==true) {
        		return;
        	}
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
        synchronized (fun) {
        	if(MainFunction.end==false) {
        	System.out.println("Generator"+i+": Genaration:"+ po.generation+"  fitness:"+fitness);
        	}else return;
		}
        }
        
        
        if(po.generation==200){
            System.out.println("Generator"+i+": We can't find the suitable solution");
        }else {
        	System.out.println("Generator"+i+" found the gene!  fitness:"+fitness);
        	System.out.println("The final path is: "+fun.getFittest());
        	MainFunction.end=true;
        }
        
	}
	
}

