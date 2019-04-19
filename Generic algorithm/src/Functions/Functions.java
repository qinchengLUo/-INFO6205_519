/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import java.util.Random;

/**
 *
 * @author luoqincheng
 */
public class Functions {
    String fittest;
    int fittestint=Integer.MAX_VALUE;
    String secondFittest;
    int secondFittestint=Integer.MAX_VALUE;
    int lastFittestint=Integer.MIN_VALUE;
    int lastFittestindex;
    
    Random rn= new Random();
    
     public int[][] generateEnvironment(int[][] environment){
        for(int i=0;i<environment.length;i++){
            for(int j=0;j<environment[0].length;j++){
                environment[i][j]=rn.nextInt()%6;
            }
        }
        return environment;
    }
     
     public int calculateFitness(String[] population, int[][] environment){
            int fitness=0;
            fittestint=Integer.MAX_VALUE;
            secondFittestint=Integer.MAX_VALUE;
            lastFittestint=Integer.MIN_VALUE;
            lastFittestindex=0;
            int secindex=0;
            int firstindex=0;
        
         for(int i=0;i<population.length;i++){
             int right=0;
             int up=0;
             int temfit=0;
             for(int j=0;j<population[i].length();j++){
                 if(population[i].charAt(j)=='1'){
                     temfit=temfit+Math.abs(environment[right+1][up]-environment[right][up]);
                     right++;
                 }else{
                     temfit=temfit+Math.abs(environment[right][up]-environment[right][up+1]);
                     up++;
                 }
             }
             if(temfit<fittestint&&temfit<secondFittestint){
                 secondFittest=fittest;
                 secondFittestint=fittestint;
                 secindex=firstindex;
                 fittestint=temfit;
                 fittest=population[i];
                 firstindex=i;
             }else if(temfit<secondFittestint){
                 secondFittestint=temfit;
                 secondFittest=population[i];
                 secindex=i;
             }
             
             if(temfit>lastFittestint){
                 lastFittestindex=i;
                 lastFittestint=temfit;
             }
             fitness=fitness+temfit;
         }
         
         if(fittestint==secondFittestint){
            population[secindex]= mutation(secondFittest);
         }
         return fitness;
     }
     
     
     public String corssOver(String first, String second){
         int start=Math.abs(rn.nextInt()%99);
         int end=Math.abs(rn.nextInt()%99);
         int diffleft=0;
         int diffright=0;
         
         
         if(start>end){
             int tem=start;
             start=end;
             end=tem;
         }
         
         
         int replaceRight=0;
         int replaceUp=0;
         for(int i=0;i<start;i++){
             if(second.charAt(i)=='1'&&first.charAt(i)=='0'){
                 replaceRight++;
             }else if(second.charAt(i)=='0'&&first.charAt(i)=='1'){
                 replaceUp++;
             }
         }
         diffleft=replaceRight-replaceUp;
         
         replaceRight=0;
         replaceUp=0;
         for(int i=end+1;i<second.length();i++){
             if(second.charAt(i)=='1'&&first.charAt(i)=='0'){
                 replaceRight++;
             }else if(second.charAt(i)=='0'&&first.charAt(i)=='1'){
                 replaceUp++;
             }
         }
         diffright=replaceRight-replaceUp;
         
         StringBuilder sb=new StringBuilder();
         
         for(int i=0;i<second.length();i++){
             if(i>=start&&i<=end){
                sb.append(first.charAt(i));
             }else if(i<start){
                if(diffleft<0&&second.charAt(i)=='0'){
                    sb.append('1');
                    diffleft++;
                }else if(diffleft>0&&second.charAt(i)=='1'){
                    sb.append('0');
                    diffleft--;
                }else{
                    sb.append(second.charAt(i));
                }
             }else{
                 if(diffright<0&&second.charAt(i)=='0'){
                    sb.append('1');
                    diffright++;
                }else if(diffright>0&&second.charAt(i)=='1'){
                    sb.append('0');
                    diffright--;
                }else{
                    sb.append(second.charAt(i));
                }
             }
         }
         
         return sb.toString();
     }
     
 public String mutation(String input){
  
        Random random = new Random();
        int mutationPoint;
        StringBuilder strBuilder = new StringBuilder(input);
  
        for(int i=0;i<5;i++){
  
            mutationPoint = random.nextInt(input.length());
  
            if(strBuilder.charAt(mutationPoint)=='1'){
                strBuilder.setCharAt(mutationPoint, '0');
                mutationPoint = random.nextInt(input.length());
                while(strBuilder.charAt(mutationPoint)=='1') {
                    mutationPoint = random.nextInt(input.length());
                }
                strBuilder.setCharAt(mutationPoint, '1');
            }else {
                strBuilder.setCharAt(mutationPoint, '1');
                mutationPoint = random.nextInt(input.length());
            while(strBuilder.charAt(mutationPoint)=='0') {
                mutationPoint = random.nextInt(input.length());
            }
            strBuilder.setCharAt(mutationPoint, '0');
        }
    }
  input = strBuilder.toString();
  return input;

 }
     
     public void replacetheworst(String[] population,String newcross){
         population[lastFittestindex]=newcross;
     }
     
    public String getFittest() {
        return fittest;
    }

    public int getFittestint() {
        return fittestint;
    }

    public String getSecondFittest() {
        return secondFittest;
    }


    public int getSecondFittestint() {
        return secondFittestint;
    }

     
}
