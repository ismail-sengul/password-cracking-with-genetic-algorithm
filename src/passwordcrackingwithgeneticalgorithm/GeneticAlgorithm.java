
package passwordcrackingwithgeneticalgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GeneticAlgorithm {
    private String target;
    private String chars = "0123456789abcdefghijklmnopqrstuwxvzABCDEFGHIJKLMNOPQRSTWXVZ ";
    private int populationSize;
    private int generation = 1;
    private double mutationRate;
    private ArrayList<Chromosome> population = new ArrayList();
    Random rd = new Random();
    public GeneticAlgorithm(String target, int populationSize , double mutationRate){
        this.target = target;
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        for (int i = 0; i < populationSize; i++) {
            population.add(new Chromosome(getRandomChromosome() , target));
        }
        Collections.sort(population);
    }
    public GeneticAlgorithm(String target , int populationSize){
        this.target = target;
        this.populationSize = populationSize;
        this.mutationRate = 0.03;
        for (int i = 0; i < populationSize; i++) {
            population.add(new Chromosome(getRandomChromosome() , target));
        }
        Collections.sort(population);
    }
    public String getRandomChromosome(){
        String chromosome = "";
        for (int i = 0; i < target.length(); i++) {
            int rand_int = rd.nextInt(chars.length());
            chromosome += chars.charAt(rand_int);
        }
        return chromosome;
    }
    public Chromosome crossover(String chr1 , String chr2){
        String newChromosome = "";
        for (int i = 0; i < target.length(); i++) {
            double rand_double = rd.nextDouble();
            if(rand_double < (1-this.mutationRate)/2){
                newChromosome += chr1.charAt(i);
            }else if(rand_double < (1 - this.mutationRate)){
                newChromosome += chr2.charAt(i);
            }else{
                newChromosome += mutate();
            }
        }
        return new Chromosome(newChromosome , target);
    }
    public char mutate(){
        return chars.charAt(rd.nextInt(chars.length()));
    }
    public void evolve(){
        ArrayList<Chromosome> newPopulation = new ArrayList();
        newPopulation.add(population.get(0));
        newPopulation.add(population.get(1));
        for (int i = 2; i < populationSize; i++) {
            newPopulation.add(crossover(population.get(0).getChromosome(),population.get(1).getChromosome()));
        }
        System.out.println("Generation: "+generation+" Best Fit: "+population.get(0).getChromosome());
        Collections.sort(newPopulation);
        this.population = newPopulation;
        this.generation++;
    }
    public boolean isTargetFound(){
        if (population.get(0).getFitnessScore() == target.length()) {
            return true;
        }
        return false;
    }
    public int getGeneration() {
        return generation;
    }
    
    public int getPopulationSize() {
        return populationSize;
    }

    public ArrayList<Chromosome> getPopulation() {
        return population;
    }
    
}
