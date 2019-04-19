/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Random;

/**
 *
 * @author luoqincheng
 */
public class Population {
    public String[] population;
    public int generation;
    
    
    public Population(int n){
        population=new String[n];
    }
    
    public void initializePopulation(){
        Random rn=new Random();
        for(int i=0;i<population.length;i++){
            StringBuilder sb= new StringBuilder();
            int countRight=0;
            int countUp=0;
            for(int j=0;j<98;j=countRight+countUp){
                
                if(rn.nextBoolean()&&countRight<49){
                    sb.append('1');
                    countRight++;
                }else{
                    if(countUp<49){
                        sb.append('0');
                        countUp++;
                    }
                }
            }
            population[i]=sb.toString();
        }
    }
}
