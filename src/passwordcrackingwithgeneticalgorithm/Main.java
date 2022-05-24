
package passwordcrackingwithgeneticalgorithm;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("First Password Cracking Process\n");
        double generationAverage = 0.0;
        for (int i = 0; i < 3; i++) {
           System.out.print("Enter population size: ");
           int populationSize = in.nextInt();
           System.out.println("-------------------------------------------------------");
           GeneticAlgorithm ga = new GeneticAlgorithm("Deep Learning 2022",populationSize,0.03);
           long startTime = System.currentTimeMillis();
           while(!(ga.isTargetFound())){
                ga.evolve(); 
           }
           generationAverage += ga.getGeneration();
           System.out.println("-------------------------------------------------------");
           System.out.println("Target Founded!"+"\n"+"Generation: "+ga.getGeneration()+
                " Founded Target: "+ga.getPopulation().get(0).getChromosome()+
                " Passed Time: "+(System.currentTimeMillis() - startTime)+"ms");
            System.out.println("Generation Average: "+generationAverage/(i+1));
           System.out.println("-------------------------------------------------------");
        } 
        System.out.println("\nSecond Password Cracking Process");
        generationAverage = 0.0;
        for (int i = 0; i < 3; i++) {
           System.out.print("Enter population size: ");
           int populationSize = in.nextInt();
           System.out.println("-------------------------------------------------------");
           GeneticAlgorithm ga = new GeneticAlgorithm("DeepLearning",populationSize,0.03);
           long startTime = System.currentTimeMillis();
           while(!(ga.isTargetFound())){
                ga.evolve(); 
           }
           generationAverage += ga.getGeneration();
           System.out.println("-------------------------------------------------------");
           System.out.println("Target Founded!"+"\n"+"Generation: "+ga.getGeneration()+
                " Founded Target: "+ga.getPopulation().get(0).getChromosome()+
                " Passed Time: "+(System.currentTimeMillis() - startTime)+"ms");
           System.out.println("Generation Average: "+generationAverage/(i+1));
           System.out.println("-------------------------------------------------------");
        }  
    }   
}
